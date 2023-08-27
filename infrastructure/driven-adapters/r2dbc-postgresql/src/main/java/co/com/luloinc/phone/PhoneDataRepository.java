package co.com.luloinc.phone;


import co.com.luloinc.model.user.gateway.PhoneRepository;
import co.com.luloinc.user.UserDataDb;
import co.com.luloinc.user.UserDataMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class PhoneDataRepository implements PhoneRepository {
    private final PhoneDataMapper mapper;
    private final PhoneDataDb phoneDataDb;


}



