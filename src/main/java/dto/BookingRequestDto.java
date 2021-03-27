package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BookingRequestDto {

    @SerializedName("date")
    private String date;

    @SerializedName("destination")
    private String destination;

    @SerializedName("id")
    private String id;

    @SerializedName("origin")
    private String origin;
}
