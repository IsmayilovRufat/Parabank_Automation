package pages;

import utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = DriverManager.getDriver();
    }

    private By register = By.cssSelector("a[href='register.htm']");
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("input[type='submit']");
    
    public void clickRegister() {
        driver.findElement(register).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
