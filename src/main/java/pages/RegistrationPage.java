package pages;

import utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

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

    private By welcomeMessage = By.cssSelector("div[id='rightPanel'] .title");
    private By successMessage = By.cssSelector("div[id='rightPanel'] p");
    private By usernameAlreadyExistsError = By.cssSelector("span[id='customer.username.errors']");

    private By firstNameFieldIsEmpty = By.cssSelector("span[id='customer.firstName.errors']");
    private By lastNameFieldIsEmpty = By.cssSelector("span[id='customer.lastName.errors']");
    private By addressFieldIsEmpty = By.cssSelector("span[id='customer.address.street.errors']");
    private By cityFieldIsEmpty =  By.cssSelector("span[id='customer.address.city.errors']");
    private By stateFieldIsEmpty = By.cssSelector("span[id='customer.address.state.errors']");
    private By zipFieldIsEmpty = By.cssSelector("span[id='customer.address.zipCode.errors']");
    private By ssnFieldIsEmpty = By.cssSelector("span[id='customer.ssn.errors']");
    private By usernameFieldIsEmpty = By.cssSelector("span[id='customer.username.errors']");
    private By passwordFieldIsEmpty = By.cssSelector("span[id='customer.password.errors']");
    private By confirmPasswordFieldIsEmpty = By.cssSelector("span[id='repeatedPassword.errors']");

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void fillRegistrationForm(Map<String, String> data) {
        driver.findElement(firstName).sendKeys(data.get("First Name"));
        driver.findElement(lastName).sendKeys(data.get("Last Name"));
        driver.findElement(address).sendKeys(data.get("Address"));
        driver.findElement(city).sendKeys(data.get("City"));
        driver.findElement(state).sendKeys(data.get("State"));
        driver.findElement(zipCode).sendKeys(data.get("Zip Code"));
        driver.findElement(phone).sendKeys(data.get("Phone"));
        driver.findElement(ssn).sendKeys(data.get("SSN"));
        driver.findElement(username).sendKeys(data.get("Username"));
        driver.findElement(password).sendKeys(data.get("Password"));
        driver.findElement(confirm_password).sendKeys(data.get("Confirm"));
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getUsernameAlreadyExistsError() {
        return driver.findElement(usernameAlreadyExistsError).getText();
    }

    public String getFirstNameFieldIsEmpty() {
        return driver.findElement(firstNameFieldIsEmpty).getText();
    }

    public String getLastNameFieldIsEmpty() {
        return driver.findElement(lastNameFieldIsEmpty).getText();
    }

    public String getAddressFieldIsEmpty() {
        return driver.findElement(addressFieldIsEmpty).getText();
    }

    public String getCityFieldIsEmpty() {
        return driver.findElement(cityFieldIsEmpty).getText();
    }

    public String getStateFieldIsEmpty() {
        return driver.findElement(stateFieldIsEmpty).getText();
    }

    public String getZipFieldIsEmpty() {
        return driver.findElement(zipFieldIsEmpty).getText();
    }

    public String getSsnFieldIsEmpty() {
        return driver.findElement(ssnFieldIsEmpty).getText();
    }

    public String getUsernameFieldIsEmpty() {
        return driver.findElement(usernameFieldIsEmpty).getText();
    }

    public String getPasswordFieldIsEmpty() {
        return driver.findElement(passwordFieldIsEmpty).getText();
    }

    public String getConfirmPasswordFieldIsEmpty() {
        return driver.findElement(confirmPasswordFieldIsEmpty).getText();
    }

    public String getPassword() {
        return driver.findElement(password).getText();
    }

    public String getConfirmPassword() {
        return driver.findElement(confirm_password).getText();
    }
}
