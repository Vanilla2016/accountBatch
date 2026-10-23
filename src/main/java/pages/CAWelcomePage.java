package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import utils.ElementUtils;

@Component
@PropertySource("classpath:application.properties")
public class CAWelcomePage extends BasePage{

    @Value("${spring.application.ca_welcome}")
    private String caWelcome;

    @Value("${spring.application.ca_homepage}")
    private String caHomePage;

    @Value("${spring.application.ca_login_button}")
    private String loginButton;

    @Value("${spring.application.propertiespath}")
    protected String propertiespath;

    public CAWelcomePage () {

    }

    public CAWelcomePage (String url) {

    }
    @Override
    public void drive(){
        driver.get(propertiespath.concat(caWelcome));
    }

    public CALoginPage clickLogOnOrRegister() {
        elementUtils.clickElement(By.cssSelector(loginButton));
        return new CALoginPage(driver);
    }
}