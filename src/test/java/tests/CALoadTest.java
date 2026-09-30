package tests;

import extensions.DriverManagementPreExtension;
import extensions.DriverManagementPostExtension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import pages.CALoginPage;
import pages.CAPacPage;
import pages.CAWelcomePage;
import utils.ElementUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.BrowserUtils.driver;
@SpringBootTest(classes = {CAWelcomePage.class, CALoginPage.class, CAPacPage.class})
@ExtendWith({DriverManagementPreExtension.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class CALoadTest {

    @Autowired
    private CAWelcomePage welcomePage;

    @Autowired
    private CALoginPage loginPage;

    @Autowired
    private CAPacPage cAPacPage;

    private ElementUtils elementUtils;

    /*Test navigate to welcome page, then navigate to login page.
     * Took a lot of configuring. Mainly due to dependancy of CAPage.
     * Have to set the driver as an object. Cannot be Autowired as is jarred class. */
    @Test
    void testLoadCAWelcomeAndNavigateToWelcome() {

        String title;
        welcomePage.setWebDriver(driver);
        elementUtils = new ElementUtils(driver);
        welcomePage.setElementUtils(elementUtils);
        welcomePage.drive();
        title = welcomePage.getTitle();
        assertThat(title).contains("Trust, Pension & Personal Bank Accounts | Cater Allen");
        /* Maybe put condition that no Exception thrown */
       // welcomePage.clickLogOnOrRegister();
    }

    @Test
    void testIsLoginSuccesful() {
        loginPage.setWebDriver(driver);
        String title = loginPage.getTitle();
        assertThat(title.equalsIgnoreCase("Welcome to Cater Allen Private Bank"));
    }

    @Test
    public void testIdEntered() {
        loginPage.setWebDriver(driver);
        elementUtils = new ElementUtils(driver);
        loginPage.setElementUtils(elementUtils);
        loginPage.drive();
        loginPage.enterUserId();
        assertThat(loginPage.getEnteredLogInId().
                equalsIgnoreCase(loginPage.getUserId()));
    }


    @Test
    void TestPacEnteredSuccesfully() {
        String title;
        cAPacPage.setWebDriver(driver);
        elementUtils = new ElementUtils(driver);
        cAPacPage.setElementUtils(elementUtils);
        cAPacPage.drive();
        title = cAPacPage.getTitle();
        assertThat(title.contains("Welcome to Cater Allen Private Bank"));

        cAPacPage.enterPacCode();

        /*
        String [] pacArray = caPacNo.split(",");
        List<String> pacNos = localDriver.getPacNos();

        for (String pacNo: pacNos){
            System.out.println(pacNo);
            int pacNoCount = 0;
            //assert pacNo != null;
            assertThat(pacNo).isEqualTo(pacArray[pacNoCount]);
            pacNoCount++;
        }
         */
    }
}
