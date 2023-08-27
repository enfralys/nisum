package co.com.luloinc.phone;

import co.com.luloinc.model.user.Phone;
import co.com.luloinc.user.UserData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PhoneDataDb extends ReactiveCrudRepository<PhoneData, Long> {
}
