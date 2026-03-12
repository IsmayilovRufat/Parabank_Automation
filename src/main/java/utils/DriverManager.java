package utils;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver createDriver() {
        boolean headless = Boolean.parseBoolean(
                ConfigReader.getProperty("headless")
        );
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        return driver;
    }
}