package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private static long waitDuration = Long.valueOf(ConfigReader.getProperty("explicit_wait"));    // fetching timeout from config.properties

    // wait for one web element to be visible
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // wait for all the web elements having same locators to be visible
    public static List<WebElement> waitForAllElementToBeVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // wait for one web element to be click-able
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
