package extensions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.ElementUtils;

import java.time.Duration;

//In Test context this must be used rather than standard PropertySource
@TestPropertySource("classpath:application.properties")
public class DriverManagementPreExtension implements BeforeEachCallback {
    private boolean initialized = false;
    protected WebDriver driver;
    protected ElementUtils elementUtils;

    @Value("${spring.application.propertiespath}")
    protected String propertiesPathTest;

    @Override
    public void beforeEach (ExtensionContext extensionContext) throws Exception {
        if (!initialized) {
                initialized = true;

                driver = BrowserUtils.getDriver();
                elementUtils =  new ElementUtils(driver);
                Long implicit_wait_duration = Long.valueOf(ConfigReader.getProperty("implicit_wait"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit_wait_duration));
                driver.manage().window().maximize();

                extensionContext
                        .getRoot()
                        .getStore(ExtensionContext.Namespace.GLOBAL)
                        .put("browserDriver", driver);
        }
    }
}
