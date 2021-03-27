package shared;

import dto.BookingResponseDto;
import dto.UserResponseDto;
import lombok.Data;
import retrofit2.Response;

@Data
public class SharedResponse {

    private Response<UserResponseDto> userSharedResponse;
    private Response<BookingResponseDto> bookingSharedResponse;
}
