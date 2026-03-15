Feature: Transfer Funds
  As a logged-in customer
  I want to transfer money between my accounts
  So that I can manage my funds

  Background:
    Given I am on the ParaBank home page
    And I log in with username "john" and password "demo"

  @transfer @smoke
  Scenario: Successful transfer between accounts
    When I click "Transfer Funds"
    And I select "From Account" with available balance
    And I select "To Account" different from from account
    And I enter amount "100"
    And I enter description "Test transfer"
    And I click "Transfer" button
    Then I should see "Transfer Complete!"
    And the amount should be deducted from source account
    And the amount should be added to destination account

  @transfer
  Scenario: Transfer form displays user accounts in dropdowns
    When I click "Transfer Funds"
    Then I should see "Transfer Between Accounts" or "Transfer Funds" form
    And I should see "From Account" dropdown
    And I should see "To Account" dropdown
    And I should see "Amount" input field
    And I should see "Transfer" button

  @transfer @validation
  Scenario: Transfer fails when amount exceeds balance
    When I click "Transfer Funds"
    And I select "From Account" with balance 50
    And I select "To Account"
    And I enter amount "500"
    And I click "Transfer" button
    Then I should see an error message about insufficient funds
    And transfer should not complete

  @transfer @validation
  Scenario: Transfer fails with zero amount
    When I click "Transfer Funds"
    And I select "From Account" and "To Account"
    And I enter amount "0"
    And I click "Transfer" button
    Then I should see validation error

  @transfer @validation
  Scenario: Transfer fails with negative amount
    When I click "Transfer Funds"
    And I enter amount "-100"
    And I click "Transfer" button
    Then I should see validation error

  @transfer @validation
  Scenario: Transfer fails when from and to account are the same
    When I click "Transfer Funds"
    And I select the same account for "From Account" and "To Account"
    And I enter amount "100"
    And I click "Transfer" button
    Then I should see an error or validation message