package steps;

import api.ApiClientFactory;
import api.ApiHandler;
import dto.UserRequestDto;
import dto.UserResponseDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.testng.Assert;
import retrofit2.Response;
import shared.CreationScenario;
import shared.SharedResponse;

import static utils.RandomHelper.generateRandomEmail;
import static utils.RandomHelper.generateRandomName;

public class UserSteps {

    private ApiHandler apiHandler = ApiClientFactory.setupClient().create(ApiHandler.class);
    private CreationScenario creationScenario;
    private SharedResponse sharedResponse;

    public UserSteps(CreationScenario scenario, SharedResponse sharedResponse) {
        this.creationScenario = scenario;
        this.sharedResponse = sharedResponse;
    }

    @Given("Set up a random user payload")
    public void createRandomUserPayload(){
        creationScenario.setUserRequestBody(createRandomUser());
    }

    @When("POST user creation request")
    public void submitUserCreationRequest() {
        sendCreateUserRequest();
    }

    @When("GET user")
    public UserResponseDto getUser() {
        getUserById(true);
        return sharedResponse.getUserSharedResponse().body();
    }

    @When("GET user for non existing id")
    public UserResponseDto getUserForNonExistingId() {
        getUserById(false);
        return sharedResponse.getUserSharedResponse().body();
    }

    @Then("Response code for user is {int}")
    public void responseCodeIs(int expectedResponseCode) {

        Assert.assertEquals(sharedResponse.getUserSharedResponse().code(), expectedResponseCode,
                "Unexpected response code");
    }

    @Then("Values in the response match the request payload")
    public void valuesInTheResponseMatchTheRequestPayload() {

        assert sharedResponse.getUserSharedResponse().body() != null;
        Assert.assertEquals(creationScenario.getUserRequestBody().getEmail(),
                sharedResponse.getUserSharedResponse().body().getEmail(),
                "Email in the response payload is not as expected");
        Assert.assertEquals(creationScenario.getUserRequestBody().getName(),
                sharedResponse.getUserSharedResponse().body().getName(),
                "Name in the response payload is not as expected");
    }

    @Then("New user has empty bookings by default")
    public void newUserHasEmptyBookingsByDefault() {
        assert sharedResponse.getUserSharedResponse().body() != null;
        Assert.assertTrue(sharedResponse.getUserSharedResponse().body().getBookings().isEmpty(),
                "Bookings are not empty");
    }

    @SneakyThrows
    private void sendCreateUserRequest() {
        Response<UserResponseDto> response = apiHandler.createNewUser(creationScenario.getUserRequestBody()).execute();
        sharedResponse.setUserSharedResponse(response);
    }

    @SneakyThrows
    private UserResponseDto getUserById(boolean existingUser){
        assert sharedResponse.getUserSharedResponse().body() != null;
        String userId = sharedResponse.getUserSharedResponse().body().getId();
        if (!existingUser) {
            userId = "nonExistingUserId";
        }
        Response<UserResponseDto> response = apiHandler.getUserById(userId).execute();
        sharedResponse.setUserSharedResponse(response);
        return response.body();
    }

    private UserRequestDto createRandomUser(){
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setEmail(generateRandomEmail());
        userRequestDto.setName(generateRandomName());
        return userRequestDto;
    }
}
