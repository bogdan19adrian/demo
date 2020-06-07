package ro.go.bogdanenache.patch.api.update;


import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class PatchUserDTO {

    private Optional<String> firstName;
    private Optional<String>  lastName;
    private Gender gender;
    private Optional<Integer> age;
    private Optional<AddressDTO> address;
    private Optional<List<PhoneNumberDTO>> phoneNumbers;


}
