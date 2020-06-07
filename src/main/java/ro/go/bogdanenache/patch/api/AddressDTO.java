package ro.go.bogdanenache.patch.api;

import lombok.Data;

@Data
public class AddressDTO {

    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;

}
