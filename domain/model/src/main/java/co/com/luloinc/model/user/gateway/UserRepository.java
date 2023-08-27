package co.com.luloinc.model.user.gateway;

import co.com.luloinc.model.bedrooms.Bedroom;
import co.com.luloinc.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> createUser(User user);

}
