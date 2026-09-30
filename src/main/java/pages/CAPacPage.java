package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import utils.ElementUtils;

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

    public void enterPacCode () {
        /* IS there a list of the same class doc elements? - like for PIN input */
        List<WebElement> docElemList = driver.findElements(By.className(pacInputId));
                //getDocElementsByClass(pacInputId);

    if (docElemList != null && docElemList.size() > 1) {
        String numArr [] = pacNo.length() > 1 ?
                                pacNo.split(",") : new String [] {pacNo};
        int count=0;
        for (WebElement docElem : docElemList) {
          //  if (!docElem.getDomAttribute("class").endsWith("character-grey-boxes"))
                docElem.sendKeys(numArr[count]);
            count++;
        }
    }/*else {
        try {
            driver.findElement(By.id(docElementId)).sendKeys(charString);
        }catch (NoSuchElementException nse){
            LOGGER.trace(nse.getStackTrace());
        }
     */
    }
}

