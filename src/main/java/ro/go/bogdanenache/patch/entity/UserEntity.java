package ro.go.bogdanenache.patch.entity;


import lombok.Data;

import java.util.List;

@Data
public class UserEntity {

    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
    private AddressEntity address;
    private List<PhoneNumberEntity> phoneNumbers;


}
