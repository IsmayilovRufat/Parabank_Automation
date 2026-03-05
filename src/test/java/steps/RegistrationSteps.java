package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.Map;

public class RegistrationSteps {

    private HomePage homePage;
    private RegistrationPage registrationPage;

    @Given("I am on the ParaBank home page")
    public void i_am_on_the_ParaBank_home_page() {
        homePage = new HomePage();
    }

    @And("I click \"Register\"")
    public void i_click_register() {
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

    @And("I should be logged in as \"johndoe15\"")
    public void i_should_be_logged_in_as_johndoe15() {
        String welcomeMessage = registrationPage.getWelcomeMessage();
        Assert.assertTrue(
                welcomeMessage.contains("johndoe15"),
                "Expected welcome message to contain text, but was: " + welcomeMessage);
    }
}
