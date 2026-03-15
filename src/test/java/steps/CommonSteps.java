package steps;

import config.ConfigReader;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class CommonSteps {

    @Given("I am on the ParaBank home page")
    public void i_am_on_the_ParaBank_home_page() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(ConfigReader.getProperty("url"));
    }
}

