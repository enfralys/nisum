package co.com.luloinc.api.request;

import co.com.luloinc.model.user.Phone;
import co.com.luloinc.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserRequest {

    @NonNull
    @NotEmpty
    private String name;

    @NonNull
    @Email
    private String email;

    @NonNull
    @Size(min = 6)
    private String password;

    @NonNull
    private List<PhoneRequest> phones;

    public User toModel() {
        List<Phone> phoneModels = phones.stream().map(PhoneRequest::toModel).collect(Collectors.toList());

       return  User.builder().email(email).name(name).password(password).phones(phoneModels).build();

    }
}