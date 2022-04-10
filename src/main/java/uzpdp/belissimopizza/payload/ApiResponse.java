package uzpdp.belissimopizza.payload;

//Asilbek Fayzullayev 09.04.2022 15:45   

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {

    private String massage;

    private boolean isSuccess;

    private Object data;

    public ApiResponse(String massage, boolean isSuccess) {
        this.massage = massage;
        this.isSuccess = isSuccess;
    }
}
