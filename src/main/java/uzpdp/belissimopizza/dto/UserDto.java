package uzpdp.belissimopizza.dto;

//Asilbek Fayzullayev 10.04.2022 1:59   

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String fullName;

    private String userName;

    private String password;

    private String gender;
}
