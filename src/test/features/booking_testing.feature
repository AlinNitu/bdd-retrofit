Feature: Creating bookings

  Background: Create an user
    Given   Set up a random user payload
    When    POST user creation request
    Then    Response code for user is 201

  @sanity
  Scenario: Create a booking and assign it to an user
    Given Set up a booking with the following information
      | destination | MAD |
      | origin      | BER |
    When  POST booking creation request
    Then  Response code for booking is 201
    And   Booking values in the response payload are correct
    And   Booking id is not null


  Scenario: Create multiple bookings for the same user
    Given Set up a booking with the following information
      | destination | MAD |
      | origin      | BER |
    When  POST booking creation request
    Then  Response code for booking is 201
    And   Booking values in the response payload are correct
    And   Booking id is not null

    Given Set up a booking with the following information
      | destination | MAD |
      | origin      | BER |
    When  POST booking creation request
    Then  Response code for booking is 201
    And   Booking values in the response payload are correct
    And   Booking id is not null


  #TODO - some examples of what can be added
  #Scenario: Get previously created booking and assert correct values
  #Scenario: Create multiple bookings for the same user and then retrieve the user and assert the number of bookings in bookings array
  #Scenario: Try to get a non existing booking and assert 404 error
  #Scenario: In case we use some kind of authorization test 401 Unauthorized and 403 Forbidden flows for booking
