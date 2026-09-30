package tests;

import extensions.DriverManagementPostExtension;
import extensions.DriverManagementPreExtension;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import pages.CALoginPage;
import pages.CAWelcomePage;
import utils.ElementUtils;

import static utils.BrowserUtils.driver;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {CAWelcomePage.class, CALoginPage.class})
@ExtendWith({DriverManagementPreExtension.class,
                    DriverManagementPostExtension.class})
@TestPropertySource(locations = "classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(2)
public class CAEnterIDTest {

    @Autowired
    private CALoginPage loginPage;

    private ElementUtils elementUtils;

    @Value("${spring.application.ca_userid}")
    private String userId;

    @Disabled
    @Test
    public void testIdEntered(){
        loginPage.setWebDriver(driver);
        elementUtils = new ElementUtils(driver);
        loginPage.setElementUtils(elementUtils);
        loginPage.drive();
        loginPage.enterUserId();
        assertThat(loginPage.getEnteredLogInId().
                                equalsIgnoreCase(loginPage.getUserId()));
    }
}
