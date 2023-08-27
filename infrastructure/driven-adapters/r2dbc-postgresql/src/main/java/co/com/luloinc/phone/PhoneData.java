package co.com.luloinc.phone;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("tbl_phones")
public class PhoneData {
    @Id
    private Long id;

    @Column("number")
    private String number;

    @Column("citycode")
    private String citycode;

    @Column("countrycode")
    private String countrycode;

    @Column("user_id")
    private UUID userId;
}