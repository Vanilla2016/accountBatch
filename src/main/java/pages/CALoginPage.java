package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import utils.ElementUtils;

@Component
@PropertySource("classpath:application.properties")
public class CALoginPage extends BasePage {

    @Value("${spring.application.ca_login}")
    private String caLogin;

    @Value("${spring.application.ca_login_button_ID}")
    private String caLoginButton;

    private String loginURL;

    @Value("${spring.application.propertiespath}")
    protected String propertiespath;

    @Value("${spring.application.ca_userid_boxid}")
    protected String userIdBox;

    @Value("${spring.application.ca_userid}")
    protected String userId;


    public CALoginPage() {

    }

    public CALoginPage(WebDriver driver) {
        System.out.println(this.getClass() +" contructor called!");
        this.driver = driver;
        loginURL = driver.getCurrentUrl();
    }

    @Override
    public void drive(){
        String driverUrl = (loginURL != null) ?
                loginURL : propertiespath.concat(caLogin);
        driver.get(driverUrl);
    }

    public String getUserId (){
        return userId;
    }

    public String getEnteredLogInId () {
        String userId  = "";
        userId = elementUtils.getText(By.id(userIdBox));
        return userId;
        //return driver.findElement(By.id(userIdBox)).getText();
    }
    public void enterUserId (){
        driver.findElement(By.id(userIdBox)).sendKeys(userId);
    }

    public CAPacPage clickLogOnOrRegister() {
        elementUtils.clickElement(By.id(caLoginButton));
        return new CAPacPage(driver.getCurrentUrl());
    }
}
