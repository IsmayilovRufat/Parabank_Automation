package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;

public class RegistrationSteps {

    private HomePage homePage;

    @Given("I am on the ParaBank home page")
    public void i_am_on_the_ParaBank_home_page() {
        homePage = new HomePage();
    }

    @And("I click \"Register\"")
    public void i_click_register() {
        homePage.clickRegister();
    }
}
