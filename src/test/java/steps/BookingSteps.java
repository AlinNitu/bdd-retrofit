package steps;

import api.ApiClientFactory;
import api.ApiHandler;
import dto.BookingRequestDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import retrofit2.Response;
import shared.CreationScenario;
import shared.SharedResponse;

import java.io.IOException;
import java.util.Map;

public class BookingSteps {

    private SharedResponse sharedResponse;
    private CreationScenario creationScenario;
    private ApiHandler apiHandler = ApiClientFactory.setupClient().create(ApiHandler.class);

    public BookingSteps(SharedResponse sharedResponse, CreationScenario creationScenario) {
        this.sharedResponse = sharedResponse;
        this.creationScenario = creationScenario;
    }


    @Given("Set up a booking with the following information")
    public void setUpABookingWithTheFollowingInformation(DataTable bookingDt) {
        Map<String, String> bookingMap = bookingDt.asMap(String.class, String.class);
        BookingRequestDto bookingRequest = new BookingRequestDto();
        assert sharedResponse.getUserSharedResponse().body() != null;
        //TODO create a date function - depending on testing scenarios we can pass it from feature file
        bookingRequest.setDate("2021-03-26T18:25:43.511Z");
        bookingRequest.setDestination(bookingMap.get("destination"));
        bookingRequest.setId(sharedResponse.getUserSharedResponse().body().getId());
        bookingRequest.setOrigin(bookingMap.get("origin"));
        creationScenario.setBookingRequestBody(bookingRequest);
    }


    @When("POST booking creation request")
    public void postBookingCreationRequest() throws IOException {
        Response response = apiHandler.createNewBooking(creationScenario.getBookingRequestBody()).execute();
        sharedResponse.setBookingSharedResponse(response);
    }


    @Then("Response code for booking is {int}")
    public void responseCodeIs(int expectedResponseCode) {
        Assert.assertEquals(sharedResponse.getBookingSharedResponse().code(), expectedResponseCode,
                "Unexpected response code");
    }

    @Then("Booking values in the response payload are correct")
    public void bookingValuesInTheResponsePayloadAreCorrect() {
        assert sharedResponse.getBookingSharedResponse().body() != null;
        assert sharedResponse.getUserSharedResponse().body() != null;

        Assert.assertEquals(creationScenario.getBookingRequestBody().getDestination(),
                sharedResponse.getBookingSharedResponse().body().getDestination(),
                "Destination is not correctly saved");
        Assert.assertEquals(creationScenario.getBookingRequestBody().getOrigin(),
                sharedResponse.getBookingSharedResponse().body().getOrigin(),
                "Origin is not save correctly");
        Assert.assertEquals(sharedResponse.getUserSharedResponse().body().getId(),
                sharedResponse.getBookingSharedResponse().body().getIdUser(),
                "Id user in the booking is not correct");
    }

    @Then("Booking id is not null")
    public void bookingIdIsNotNull() {
        assert sharedResponse.getBookingSharedResponse().body() != null;
        Assert.assertNotNull(sharedResponse.getBookingSharedResponse().body().getIdBooking(),
                "Booking id is NULL");
    }
}
