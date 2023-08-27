package co.com.luloinc.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class Phone {
    private String number;
    private String citycode;
    private String countrycode;
}
