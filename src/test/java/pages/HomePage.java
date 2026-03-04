package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = DriverManager.getDriver();
    }

    private By register = By.cssSelector("a[href='register.htm']");
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.cssSelector("input[type='submit']");

    public void clickRegister() {
        driver.findElement(register).click();
    }
}
