package extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class DriverManagementPostExtension implements AfterEachCallback {

    protected WebDriver driver;
    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {

         driver = (WebDriver) extensionContext
                .getRoot()
                        .getStore(ExtensionContext.Namespace.GLOBAL)
                                .get("browserDriver");

        driver.quit();
    }
}
