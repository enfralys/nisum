package co.com.luloinc.api.request;


import co.com.luloinc.model.user.Phone;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneRequest {

    private String number;
    private String citycode;
    private String countrycode;

    public Phone toModel() {
        return Phone.builder()
                .number(number)
                .citycode(citycode)
                .countrycode(countrycode)
                .build();

    }
}