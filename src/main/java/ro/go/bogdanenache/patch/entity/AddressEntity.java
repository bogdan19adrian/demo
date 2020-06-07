package ro.go.bogdanenache.patch.entity;

import lombok.Data;

@Data
public class AddressEntity {

    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;

}
