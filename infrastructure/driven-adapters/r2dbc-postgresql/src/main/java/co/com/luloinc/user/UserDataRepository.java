package co.com.luloinc.user;

import co.com.luloinc.model.user.User;
import co.com.luloinc.model.user.gateway.UserRepository;
import co.com.luloinc.phone.PhoneData;
import co.com.luloinc.phone.PhoneDataDb;
import co.com.luloinc.phone.PhoneDataMapper;
import co.com.luloinc.phone.PhoneDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDataRepository implements UserRepository {
    private final UserDataMapper userDataMapper;
    private final UserDataDb userDataDb;
    private final PhoneDataMapper phoneMapper;
    private final PhoneDataDb phoneRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Mono<User> createUser(User user) {
        // Validar el formato de correo y contraseña
        if (!isValidEmail(user.getEmail())) {
            return Mono.error(new IllegalArgumentException("Invalid email format"));
        }

        if (!isValidPassword(user.getPassword())) {
            return Mono.error(new IllegalArgumentException("Invalid password format"));
        }

        return userDataDb.findByEmail(user.getEmail())
                .flatMap(existingUserData -> Mono.error(new DataIntegrityViolationException("Email already registered")))
                .switchIfEmpty(
                        userDataDb.save(prepareUserData(user))
                                .flatMap(savedUserData -> {
                                    List<Mono<PhoneData>> phoneDataMonoList = user.getPhones().stream()
                                            .map(phone -> {
                                                PhoneData phoneData = phoneMapper.toData(phone);
                                                phoneData.setUserId(savedUserData.getId());
                                                return phoneRepository.save(phoneData);
                                            })
                                            .collect(Collectors.toList());

                                    return Mono.when(phoneDataMonoList)
                                            .thenReturn(savedUserData);
                                })
                )
                .map(savedUserData -> prepareUserEntity((UserData) savedUserData));
    }

    private UserData prepareUserData(User user) {
        UserData userData = userDataMapper.toData(user);
        userData.setPassword(passwordEncoder.encode(user.getPassword()));
        userData.setCreated(LocalDateTime.now());
        userData.setModified(LocalDateTime.now());
        userData.setLastLogin(LocalDateTime.now());
        userData.setToken(UUID.randomUUID().toString());
        userData.setIsActive(true);
        return userData;
    }

    private User prepareUserEntity(UserData userData) {
        User user = userDataMapper.toEntity(userData);
        user.setToken(userData.getToken());
        return user;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private boolean isValidPassword(String password) {

        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(passwordRegex);
    }
}


