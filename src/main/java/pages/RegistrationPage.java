package pages;

import utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegistrationPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        String value;

        value = data.get("First Name");
        if (value != null) driver.findElement(firstName).sendKeys(value);

        value = data.get("Last Name");
        if (value != null) driver.findElement(lastName).sendKeys(value);

        value = data.get("Address");
        if (value != null) driver.findElement(address).sendKeys(value);

        value = data.get("City");
        if (value != null) driver.findElement(city).sendKeys(value);

        value = data.get("State");
        if (value != null) driver.findElement(state).sendKeys(value);

        value = data.get("Zip Code");
        if (value != null) driver.findElement(zipCode).sendKeys(value);

        value = data.get("Phone");
        if (value != null) driver.findElement(phone).sendKeys(value);

        value = data.get("SSN");
        if (value != null) driver.findElement(ssn).sendKeys(value);

        value = data.get("Username");
        if (value != null) driver.findElement(username).sendKeys(value);

        value = data.get("Password");
        if (value != null) driver.findElement(password).sendKeys(value);

        value = data.get("Confirm");
        if (value != null) driver.findElement(confirm_password).sendKeys(value);
    }

    public String getWelcomeMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(welcomeMessage)
        ).getText();
    }

    public String getSuccessMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).getText();
    }

    public String getUsernameAlreadyExistsError() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameAlreadyExistsError)
        ).getText();
    }

    public String getFirstNameFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameFieldIsEmpty)
        );
        return el.getText();
    }

    public String getLastNameFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastNameFieldIsEmpty)
        );
        return el.getText();
    }

    public String getAddressFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(addressFieldIsEmpty)
        );
        return el.getText();
    }

    public String getCityFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cityFieldIsEmpty)
        );
        return el.getText();
    }

    public String getStateFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(stateFieldIsEmpty)
        );
        return el.getText();
    }

    public String getZipFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(zipFieldIsEmpty)
        );
        return el.getText();
    }

    public String getSsnFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ssnFieldIsEmpty)
        );
        return el.getText();
    }

    public String getUsernameFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameFieldIsEmpty)
        );
        return el.getText();
    }

    public String getPasswordFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordFieldIsEmpty)
        );
        return el.getText();
    }

    public String getConfirmPasswordFieldIsEmpty() {
        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmPasswordFieldIsEmpty)
        );
        return el.getText();
    }

    public String getPassword() {
        return driver.findElement(password).getText();
    }

    public String getConfirmPassword() {
        return driver.findElement(confirm_password).getText();
    }
}
