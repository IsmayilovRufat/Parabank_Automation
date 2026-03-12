package steps;

import utils.DriverManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    private static final String BASE_URL = "https://parabank.parasoft.com/parabank/";

    @Given("I am on the ParaBank home page")
    public void i_am_on_the_ParaBank_home_page() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(BASE_URL);
    }
}

