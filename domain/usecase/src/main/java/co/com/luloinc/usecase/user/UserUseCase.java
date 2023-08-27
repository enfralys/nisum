package co.com.luloinc.usecase.user;


import co.com.luloinc.model.user.User;
import co.com.luloinc.model.user.gateway.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor

public class UserUseCase {
    private final UserRepository userRepository;
    public Mono<User> createUser(User user) {

        System.out.println("Bedroom: " + user);
        return userRepository.createUser(user);
    }


}
