package api;

import dto.BookingRequestDto;
import dto.BookingResponseDto;
import dto.UserRequestDto;
import dto.UserResponseDto;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiHandler {

    @POST("user")
    @Headers("Accept: application/json")
    Call<UserResponseDto> createNewUser(
            @Body UserRequestDto userRequest);

    @POST("booking")
    @Headers("Accept: application/json")
    Call<BookingResponseDto> createNewBooking(
            @Body BookingRequestDto userRequest);

    @GET("user")
    @Headers("Accept: application/json")
    Call<UserResponseDto> getUserById(
            @Query("id") String userId);
}
