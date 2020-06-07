package ro.go.bogdanenache.patch.api;


import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
    private AddressDTO address;
    private List<PhoneNumberDTO> phoneNumbers;


}
