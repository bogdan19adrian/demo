package ro.go.bogdanenache.patch.api.update;

import lombok.Data;

import java.util.Optional;

@Data
public class AddressDTO {

    private Optional<String> streetAddress;
    private Optional<String> city;
    private Optional<String> state;
    private Optional<String> postalCode;

}
