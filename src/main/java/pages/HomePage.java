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
    private By mainContentTitle = By.cssSelector("#rightPanel .title");
    private By logOutLink = By.cssSelector("a[href='logout.htm']");
    private By errorMessage = By.cssSelector("p.error");
    private By registerLink = By.cssSelector("a[href='register.htm']");

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

    public String getMainContentTitle() {
        return driver.findElement(mainContentTitle).getText();
    }

    public boolean isOnCustomerAccountPage() {
        if (driver.findElements(logOutLink).isEmpty()) {
            return false;
        }
        return driver.findElement(logOutLink).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clearUsername() {
        driver.findElement(usernameInput).clear();
    }

    public void clearPassword() {
        driver.findElement(passwordInput).clear();
    }

    public boolean isUsernameFieldDisplayed() {
        return driver.findElement(usernameInput).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordInput).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public boolean isRegisterButtonDisplayed() {
        return driver.findElement(registerLink).isDisplayed();
    }
}
