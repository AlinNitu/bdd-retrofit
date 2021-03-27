package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BookingResponseDto {

    @SerializedName("idBooking")
    private String idBooking;

    @SerializedName("idUser")
    private String idUser;

    @SerializedName("origin")
    private String origin;

    @SerializedName("destination")
    private String destination;

    @SerializedName("date")
    private String date;
}
