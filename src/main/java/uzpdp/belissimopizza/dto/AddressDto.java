package uzpdp.belissimopizza.dto;

//Asilbek Fayzullayev 09.04.2022 23:54   

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {

    private double latitude;

    private double longitude;

    private Integer cityId;
}
