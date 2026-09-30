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

    @Value("${spring.application.propertiespath}")
    protected String propertiespath;

    @Value("${spring.application.ca_userid_boxid}")
    protected String userIdBox;

    @Value("${spring.application.ca_userid}")
    protected String userId;


    public CALoginPage() {

    }

    public void drive(){
        driver.get(propertiespath.concat(caLogin));
    }
    public String getTitle(){
        return driver.getTitle();
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
}
