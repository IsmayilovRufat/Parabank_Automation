package hooks;

import config.ConfigReader;
import utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void setup() {
        WebDriver driver = DriverManager.createDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
    }

    @After
    public void teardown() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
