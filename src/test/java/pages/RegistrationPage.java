package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage() {
        this.driver = DriverManager.getDriver();
    }

    private By firstName = By.name("customer.firstName");
    private By lastName = By.name("customer.lastName");
    private By address = By.name("customer.address.street");
    private By city = By.name("customer.address.city");
    private By state = By.name("customer.address.state");
    private By zipCode = By.name("customer.address.zipCode");
    private By phone = By.name("customer.phoneNumber");
    private By ssn = By.name("customer.ssn");
    private By username = By.name("customer.username");
    private By password = By.name("customer.password");
    private By confirm_password = By.name("repeatedPassword");
    private By registerButton = By.cssSelector("input[value='Register']");

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
