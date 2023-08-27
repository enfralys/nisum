package co.com.luloinc.phone;

import co.com.luloinc.model.user.Phone;
import co.com.luloinc.phone.PhoneData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneDataMapper {
    Phone toEntity(PhoneData data);
    PhoneData toData(Phone model);
}
