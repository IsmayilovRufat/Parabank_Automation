package steps;

import config.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverManager;

public class CommonSteps {

    @Given("I am on the ParaBank home page")
    public void i_am_on_the_ParaBank_home_page() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(ConfigReader.getProperty("url"));
    }

    @And("I log in with username \"john\" and password \"demo\"")
    public void i_log_in_with_username_and_password(String username, String password) {
        HomePage homePage = new HomePage();
        homePage.enterUsername(username);
        homePage.enterPassword(password);
        homePage.clickLogin();
    }
}

