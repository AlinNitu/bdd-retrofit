package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UserRequestDto {

    //serialization not needed here but it's more readable this way
    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;
}
