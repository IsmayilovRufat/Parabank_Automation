package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class LoginSteps {

    private HomePage homePage;

    private HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        getHomePage().enterUsername(username);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        getHomePage().enterPassword(password);
    }

    @And("I click \"Log In\" button")
    public void i_click_log_in_button() {
        getHomePage().clickLogin();
    }

    @Then("I should see \"Accounts Overview\" or \"Welcome\"")
    public void i_should_see_accounts_overview_or_welcome() {
        
    }

    @And("I should be on the customer account page")
    public void i_should_be_on_the_customer_account_page() {

    }
}
