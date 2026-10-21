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
    @Value("${spring.application.propertiespath}")
    protected String propertiespath;

    public void drive(){
        driver.get(propertiespath.concat(caPac));
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getPacNo() { return pacNo; }

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

