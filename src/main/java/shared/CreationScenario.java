package shared;

import dto.BookingRequestDto;
import dto.UserRequestDto;
import lombok.Data;

@Data
public class CreationScenario {

    private UserRequestDto userRequestBody;
    private BookingRequestDto bookingRequestBody;
}
