Feature: Creating and retrieving users


  Scenario: Creating a new user successfully - validate correct response info and empty bookings for new user
    Given   Set up a random user payload
    When    POST user creation request
    Then    Response code for user is 201
    And     Values in the response match the request payload
    And     New user has empty bookings by default

  @sanity
  Scenario: Retrieve a previously created user
    Given   Set up a random user payload
    When    POST user creation request
    Then    Response code for user is 201
    When    GET user
    Then    Response code for user is 200
    And     Values in the response match the request payload


  Scenario: Trying to retrieve an user using a non existing id will throw a 404 error
    Given   Set up a random user payload
    When    POST user creation request
    Then    Response code for user is 201
    When    GET user for non existing id
    Then    Response code for user is 404
    #TODO
    #And    Validate the error response text

  #TODO - just a few examples
  #Scenario: Try to create a new user with invalid various fields and assert the error text (e.g. try to send an invalid email in the request)
  #Scenario: Create a number of n users and retrieve all of the them in a list
  #Scenario: In case we use some kind of authorization test 401 Unauthorized and 403 Forbidden flows
