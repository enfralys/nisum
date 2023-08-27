package co.com.luloinc.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserDataDb extends ReactiveCrudRepository<UserData, Long> {
    Mono<UserData> findByEmail(String email);
}
