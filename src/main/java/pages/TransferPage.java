package pages;

import org.openqa.selenium.By;

public class TransferPage {

    private By fromAccount = By.id("fromAccountId");
    private By toAccount = By.id("toAccountId");
    private By amount = By.id("amount");
    private By transferButton = By.cssSelector("input[value='Transfer']");
    private By transferCompleteMessage = By.cssSelector("div[id='showResult'] h1[class='title']");
}