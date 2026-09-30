package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
    protected WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWebElement(By locator) {
        WebElement webElement = WaitUtils.waitForElementToBeVisible(driver, locator);
        return webElement;
    }

    public List<WebElement> getAllWebElements(By locator) {
        List<WebElement> allWebElements = WaitUtils.waitForAllElementToBeVisible(driver, locator);
        return allWebElements;
    }

    public void clickElement(By locator) {
        WebElement webElement = WaitUtils.waitForElementToBeClickable(driver, locator);
        webElement.click();
    }

    public void enterText(By locator, String text) {
        WebElement webElement = WaitUtils.waitForElementToBeVisible(driver, locator);
        webElement.click();
        webElement.sendKeys(text);
    }

    public String getText(By locator) {
        WebElement webElement = WaitUtils.waitForElementToBeVisible(driver, locator);
        return webElement.getText();
    }

    public void goToPreviousPage() {
        driver.navigate().back();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }


}
