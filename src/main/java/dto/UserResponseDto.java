package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("bookings")
    private List<BookingsDto> bookings;
}
