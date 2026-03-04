package hooks;

import core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void setup() {
        WebDriver driver = DriverManager.createDriver(true);
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/");
    }

    @After
    public void teardown() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
