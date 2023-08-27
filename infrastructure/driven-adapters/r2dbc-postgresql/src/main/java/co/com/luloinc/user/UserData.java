package co.com.luloinc.user;

import co.com.luloinc.config.GenericModel;
import co.com.luloinc.model.user.Phone;
import co.com.luloinc.phone.PhoneData;
import lombok.Data;
import lombok.Generated;
import org.mapstruct.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Table("tbl_users")
public class UserData  {
    @Id
    private UUID id;

    @Column("name")
    private String name;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Transient
    private List<Phone> phones;

    @Column("token")
    private String token;

    @Column("is_active")
    private Boolean isActive;

    @Column("last_login")
    private LocalDateTime lastLogin;

    @Column("created")
    private LocalDateTime created;

    @Column("modified")
    private LocalDateTime modified;

}