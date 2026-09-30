package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.junit.jupiter.api.extension.Extension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class BrowserUtils {

    private static String browser = "chrome";

    private String injectBrowser;

    public static WebDriver driver;

    public static ElementUtils elementUtils;
    //Inject browser
    @Value("${spring.application.browser}")
    public void setBrowserProperty(String value){
        injectBrowser = value;
        BrowserUtils.browser = injectBrowser;
    }
    public static WebDriver getDriver() {

        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }
        }
        return driver;
    }

    public static ElementUtils getElementUtils(WebDriver driver){
        elementUtils = new ElementUtils(driver);
        return elementUtils;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
