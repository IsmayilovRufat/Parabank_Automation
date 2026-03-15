Feature: Customer Login
  As a registered customer
  I want to log in to ParaBank
  So that I can access my accounts and perform transactions

  Background:
    Given I am on the ParaBank home page

  @login @smoke
  Scenario: Successful login with valid credentials
    When I enter username "john"
    And I enter password "demo"
    And I click "Log In" button
    Then I should see "Accounts Overview" or "Welcome"
    And I should be on the customer account page

  @login @smoke
  Scenario Outline: Successful login with different valid users
    When I enter username "<username>"
    And I enter password "<password>"
    And I click "Log In" button
    Then I should see "Accounts Overview" or "Welcome"
    Examples:
      | username | password |
      | john     | demo     |
      | jsmith   | demo     |

  @login @validation
  Scenario: Login fails with wrong password
    When I enter username "john"
    And I enter password "wrongpassword"
    And I click "Log In" button
    Then I should see "The username and password could not be verified"
    And I should remain on the login page

  @login @validation
  Scenario: Login fails with wrong username
    When I enter username "nonexistentuser"
    And I enter password "demo"
    And I click "Log In" button
    Then I should see an error message about invalid credentials
    And I should remain on the login page

  @login @validation
  Scenario: Login fails with empty username
    When I leave username empty
    And I enter password "demo"
    And I click "Log In" button
    Then I should see validation error or remain on login page

  @login @validation
  Scenario: Login fails with empty password
    When I enter username "john"
    And I leave password empty
    And I click "Log In" button
    Then I should see validation error or remain on login page

  @login @validation
  Scenario: Login form is displayed on home page
    Then I should see "Customer Login" section
    And I should see username input field
    And I should see password input field
    And I should see "Log In" button
    And I should see "Register" link