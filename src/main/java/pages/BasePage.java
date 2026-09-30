package pages;

import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class BasePage {

    protected WebDriver driver;
    protected ElementUtils elementUtils;
    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void setElementUtils(ElementUtils elementUtils) {
        this.elementUtils = elementUtils;
    }

}
