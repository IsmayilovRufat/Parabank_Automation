Feature: User Registration
  As a new user
  I want to register on ParaBank
  So that I can access online banking services

  Background:
    Given I am on the ParaBank home page
    And I click "Register"

  @registration @smoke
  Scenario: Successful registration with valid data
    When I fill in registration form with:
      | First Name   | John        |
      | Last Name    | Doe         |
      | Address      | 123 Main St |
      | City         | New York    |
      | State        | NY          |
      | Zip Code     | 10001       |
      | Phone        | 5551234567  |
      | SSN          | 123456789   |
      | Username     | johndoe29   |
      | Password     | Test123!    |
      | Confirm      | Test123!    |
    And I click "Register" button
    Then I should see "Your account was created successfully"
    And I should be logged in as "johndoe29"

  @registration @validation
  Scenario: Registration fails when username already exists
    When I fill in registration form with existing username "john"
    And I click "Register" button
    Then I should see an error message about username already in use

  @registration @validation
  Scenario: Registration fails when required fields are empty
    When I leave required registration fields empty
    And I click "Register" button
    Then I should see validation error messages
    And I should remain on the registration page

  @registration @validation
  Scenario: Registration fails when password and confirm password do not match
    When I fill in registration form with:
      | Username | newuser1  |
      | Password | Pass123!  |
      | Confirm  | Pass456!  |
    And I click "Register" button
    Then I should see "Passwords did not match" or similar error

#  @registration @validation
#  Scenario: Registration fails with invalid SSN format
#    When I fill in registration form with invalid SSN "abc"
#    And I click "Register" button
#    Then I should see SSN validation error