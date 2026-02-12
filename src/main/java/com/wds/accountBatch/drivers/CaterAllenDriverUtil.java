package com.wds.accountBatch.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaterAllenDriverUtil implements WebDriverUtil{

    @Value("${spring.application.ca_userid_boxid}")
    private String userIdBoxId;
    @Value("${spring.application.ca_userid}")
    private String userId;
    private WebDriver localChromedriver;

    public CaterAllenDriverUtil(){
        localChromedriver = new ChromeDriver();
    }

    @Override
    public void navigateSite(String siteURL){
      localChromedriver.get(siteURL);
    }
    @Override
    public void logIntoSite() {
      populateDocElement(getDocElement(userIdBoxId).getAccessibleName(), userId);
    }

    public String getTitle(){
     return localChromedriver.getTitle();
    }
    @Override
    public void initializeWebDriver() {

    }
    @Override
    public WebElement getDocElement(String elementName) {
        return localChromedriver.findElement(By.className(elementName));
    }
    @Override
    public List<WebElement> getDocElements(String elementName) {
         return null;
    }
   @Override
    public void logOutOfSite() {

    }
    @Override
    public void populateDocElement(String docElementName, String value) {

    }
}