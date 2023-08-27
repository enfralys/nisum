package co.com.luloinc.user;

import co.com.luloinc.model.user.User;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserDataMapper {
    User toEntity(UserData data);
    UserData toData(User model);
}

