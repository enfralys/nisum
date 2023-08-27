package co.com.luloinc.config;

import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

public class GenericModel {
    @Column("created")
    private LocalDate created;
}
