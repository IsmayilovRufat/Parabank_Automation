package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverManager;

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
        String title = getHomePage().getMainContentTitle();
        Assert.assertTrue(
                title.contains("Accounts Overview") || title.contains("Welcome"),
                "Expected 'Accounts Overview' or 'Welcome', but was: " + title
        );
    }

    @And("I should be on the customer account page")
    public void i_should_be_on_the_customer_account_page() {
        Assert.assertTrue(
                getHomePage().isOnCustomerAccountPage(),
                "Expected to be on customer account page (Log Out link visible)"
        );
    }

    @Then("I should see \"The username and password could not be verified\"")
    public void i_should_see_the_username_and_password_could_not_be_verified() {
        String error = getHomePage().getErrorMessage();
        Assert.assertTrue(
                error.contains("The username and password could not be verified"),
                "Expected 'The username and password could not be verified', but was: " + error
        );
    }

    @And("I should remain on the login page")
    public void i_should_remain_on_the_login_page() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertFalse(
                currentUrl.contains("overview"),
                "Expected to remain on login page, but navigated to: " + currentUrl
        );
    }

    @Then("I should see an error message about invalid credentials")
    public void i_should_see_an_error_message_about_invalid_credentials() {
        String error = getHomePage().getErrorMessage();
        Assert.assertTrue(
                error.contains("The username and password could not be verified"),
                "Expected error about invalid credentials, but was: " + error
        );
    }

    @When("I leave username empty")
    public void i_leave_username_empty() {
        getHomePage().clearUsername();
    }

    @When("I leave password empty")
    public void i_leave_password_empty() {
        getHomePage().clearPassword();
    }

    @Then("I should see validation error or remain on login page")
    public void i_should_see_validation_error_or_remain_on_login_page() {
        String emptyFieldError = getHomePage().getErrorMessage();
        Assert.assertTrue(
                emptyFieldError.contains("Please enter a username and password"),
                "Expected error about invalid credentials, but was: " + emptyFieldError
        );
    }

    @Then("I should see \"Customer Login\" section")
    public void i_should_see_customer_login_section() {

    }

    @And("I should see username input field")
    public void i_should_see_username_input_field() {
        getHomePage().isUsernameFieldDisplayed();
    }

    @And("I should see password input field")
    public void i_should_see_password_input_field() {
        getHomePage().isPasswordFieldDisplayed();
    }

    @And("I should see \"Log In\" button")
    public void i_should_see_log_in_button() {
        getHomePage().isLoginButtonDisplayed();
    }

    @And("I should see \"Register\" link")
    public void i_should_see_register_link() {
        getHomePage().isRegisterButtonDisplayed();
    }

}
