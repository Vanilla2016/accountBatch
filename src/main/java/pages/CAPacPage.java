package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@PropertySource("classpath:application.properties")
public class CAPacPage extends BasePage {

    @Value("${spring.application.ca_pac}")
    private String caPac;
    @Value("${spring.application.ca_pac_no}")
    private String pacNo;
    @Value("${spring.application.ca_pac_input_id}")
    private String pacInputId;
    @Value("${spring.application.ca_pac_input_pword}")
    private String pacInputPword;
    @Value("${spring.application.ca_password}")
    private String pacPassword;
    @Value("${spring.application.ca_login_button_ID}")
    private String caLoginButton;
    @Value("${spring.application.propertiespath}")
    protected String propertiespath;
    private String caPacUrl;

    public CAPacPage() {
    }

    public CAPacPage(String caPacUrl) {
        this.caPacUrl = caPacUrl;
    }

    @Override
    public void drive(){
        String driverUrl = (caPacUrl != null) ?
                caPacUrl : propertiespath.concat(caPac);
        driver.get(driverUrl);
    }
    public String getPacNo() { return pacNo; }

    public String getPacPassword () {
        return pacPassword;
    }

    public void enterPacCode () {
        /* IS there a list of the same class doc elements? - like for PIN input */
        List<WebElement> docElemList = driver.findElements(
                                        By.cssSelector("[id*='"+pacInputId+"']"));

    if (docElemList != null && docElemList.size() > 1) {
        String numArr [] = pacNo.length() > 1 ?
                                pacNo.split(",") : new String [] {pacNo};
        int count=0;
        for (WebElement docElem : docElemList) {
                docElem.sendKeys(numArr[count]);
                count++;
        }
      }
    }

    public void enterPassword () {
        WebElement passwordField = driver.findElement(By.id(pacInputPword));
        passwordField.sendKeys(pacPassword);
    }

    public OTPPage clickLogOnOrRegister(){
        elementUtils.clickElement(By.cssSelector(caLoginButton));
        return new OTPPage();
    }

    public String getEnteredPassword() {
        WebElement passwordField = driver.findElement(By.id(pacInputPword));
        return passwordField.getText();
    }

    public String [] getEnteredPacCodes() {

        String [] enteredPacCodes = new String[6];
        List<WebElement> docElemList = driver.findElements(
                                By.cssSelector("[id*='"+pacInputId+"']"));
        int count = 0;
        if (docElemList != null && docElemList.size() > 1) {
             for(WebElement docElem : docElemList){
                 enteredPacCodes[count] = docElem.getText();
                 count++;
             }
        }
        return enteredPacCodes;
    }
}

