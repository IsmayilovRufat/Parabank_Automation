package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.DriverManager;
import pages.HomePage;
import pages.RegistrationPage;
import java.util.HashMap;
import java.util.Map;

public class RegistrationSteps {

    private HomePage homePage;
    private RegistrationPage registrationPage;

    @And("I click \"Register\"")
    public void i_click_register() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        homePage.clickRegister();
    }

    @When("I fill in registration form with:")
    public void i_fill_in_registration_form_with(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        registrationPage = new RegistrationPage();
        registrationPage.fillRegistrationForm(data);
    }

    @And("I click \"Register\" button")
    public void i_click_register_button() {
        registrationPage = new RegistrationPage();
        registrationPage.clickRegisterButton();
    }

    @Then("I should see \"Your account was created successfully\"")
    public void i_should_see_success_message() {
        String actualMessage = registrationPage.getSuccessMessage();
        Assert.assertTrue(
            actualMessage.contains("Your account was created successfully"),
            "Expected success message to contain text, but was: " + actualMessage);
    }

    @And("I should be logged in as \"johndoe29\"")
    public void i_should_be_logged_in_as_johndoe29() {
        String welcomeMessage = registrationPage.getWelcomeMessage();
        Assert.assertTrue(
                welcomeMessage.contains("johndoe29"),
                "Expected welcome message to contain text, but was: " + welcomeMessage);
    }

    @When("I fill in registration form with existing username \"john\"")
    public void i_fill_in_registration_form_with_existing_username_john() {
        registrationPage = new RegistrationPage();

        Map<String, String> data = new HashMap<>();
        data.put("First Name", "John");
        data.put("Last Name", "Doe");
        data.put("Address", "123 Main St");
        data.put("City", "New York");
        data.put("State", "NY");
        data.put("Zip Code", "10001");
        data.put("Phone", "5551234567");
        data.put("SSN", "123456789");
        data.put("Username", "john");
        data.put("Password", "Test123!");
        data.put("Confirm", "Test123!");

        registrationPage.fillRegistrationForm(data);
    }

    @Then("I should see an error message about username already in use")
    public void i_should_see_an_error_message_about_username_already_in_use() {
        String error = registrationPage.getUsernameAlreadyExistsError();
        Assert.assertTrue(
                error.toLowerCase().contains("exist") || error.toLowerCase().contains("use"),
                "Expected username exists/in use error, but was: " + error
        );
    }

    @When("I leave required registration fields empty")
    public void i_leave_required_registration_fields_empty() {
        registrationPage = new RegistrationPage();
    }

    @Then("I should see validation error messages")
    public void i_should_see_validation_error_messages() {
        String firstNameError = registrationPage.getFirstNameFieldIsEmpty();
        String lastNameError = registrationPage.getLastNameFieldIsEmpty();
        String addressError = registrationPage.getAddressFieldIsEmpty();
        String cityError = registrationPage.getCityFieldIsEmpty();
        String stateError = registrationPage.getStateFieldIsEmpty();
        String zipError = registrationPage.getZipFieldIsEmpty();
        String ssnError = registrationPage.getSsnFieldIsEmpty();
        String usernameError = registrationPage.getUsernameFieldIsEmpty();
        String passwordError = registrationPage.getPasswordFieldIsEmpty();
        String confirmPasswordError = registrationPage.getConfirmPasswordFieldIsEmpty();

        System.out.println("First Name: " + firstNameError);
        System.out.println("Last Name: " + lastNameError);
        System.out.println("Address: " + addressError);
        System.out.println("City: " + cityError);
        System.out.println("State: " + stateError);
        System.out.println("Zip Code: " + zipError);
        System.out.println("SSN: " + ssnError);
        System.out.println("Username: " + usernameError);
        System.out.println("Password: " + passwordError);
        System.out.println("Confirm Password: " + confirmPasswordError);

        boolean anyErrorVisible =
                        !firstNameError.isBlank() ||
                        !lastNameError.isBlank() ||
                        !addressError.isBlank() ||
                        !cityError.isBlank() ||
                        !stateError.isBlank() ||
                        !zipError.isBlank() ||
                        !ssnError.isBlank() ||
                        !usernameError.isBlank() ||
                        !passwordError.isBlank() ||
                        !confirmPasswordError.isBlank();

        Assert.assertTrue(
                anyErrorVisible,
                "Expected at least one validation error message, but found none."
        );
    }

    @And("I should remain on the registration page")
    public void i_should_remain_on_the_registration_page() {
        Assert.assertEquals(
                DriverManager.getDriver().getCurrentUrl(),
                "https://parabank.parasoft.com/parabank/register.htm"
        );
    }

    @Then("I should see \"Passwords did not match\" or similar error")
    public void i_should_see_passwords_did_not_match_or_similar_error() {
        String error = registrationPage.getConfirmPasswordFieldIsEmpty();
        Assert.assertTrue(
            error.toLowerCase().contains("passwords did not match"),
            "Expected password mismatch message, but was: " + error
        );
    }

    @When("I fill in registration form with invalid SSN {string}")
    public void i_fill_in_registration_form_with_invalid_ssn(String invalidSsn) {
        registrationPage = new RegistrationPage();
        Map<String, String> data = new HashMap<>();
        data.put("First Name", "John");
        data.put("Last Name", "Doe");
        data.put("Address", "123 Main St");
        data.put("City", "New York");
        data.put("State", "NY");
        data.put("Zip Code", "10001");
        data.put("Phone", "5551234567");
        data.put("SSN", invalidSsn);
        data.put("Username", "john");
        data.put("Password", "Test123!");
        data.put("Confirm", "Test123!");
        registrationPage.fillRegistrationForm(data);
    }

    @Then("I should see SSN validation error")
    public void i_should_see_ssn_validation_error() {

    }
}
