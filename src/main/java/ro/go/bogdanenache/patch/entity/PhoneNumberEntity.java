package ro.go.bogdanenache.patch.entity;

import lombok.Data;

@Data
public class PhoneNumberEntity {

    private String type;
    private String number;
    private String countryCode;
}
