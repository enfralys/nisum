package co.com.luloinc.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class User {
    private String name;
    private String email;
    private String password;
    private List<Phone> phones;
    private String token;
}
