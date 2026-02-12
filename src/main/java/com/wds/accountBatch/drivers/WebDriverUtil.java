package com.wds.accountBatch.drivers;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface WebDriverUtil {

    public void logIntoSite();
    public void initializeWebDriver();

    public WebElement getDocElement(String elementName);

    public List<WebElement> getDocElements(String elementName);

    public void logOutOfSite();

    public void populateDocElement(String docElementName, String value);

    void navigateSite(String caLogin);
}
