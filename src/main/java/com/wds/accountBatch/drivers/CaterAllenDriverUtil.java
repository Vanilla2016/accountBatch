package com.wds.accountBatch.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CaterAllenDriverUtil implements WebDriverUtil{

    @Value("${spring.application.ca_userid_boxid}")
    private String userIdBoxId;
    @Value("${spring.application.ca_userid}")
    private String userId;
    @Value("${spring.application.ca_login_button}")
    private String login_button;

    @Value("${spring.application.ca_pac_no}")
    private String caPacNo;

    private WebDriver localChromedriver;

    public CaterAllenDriverUtil(){
        localChromedriver = new ChromeDriver();
    }

    public String getUserId(){
        return userId;
    }

    public String getUserIdBoxId(){
        return userIdBoxId;
    }
    @Override
    public void     navigateSite(String siteURL){
      localChromedriver.get(siteURL);
    }

    public void populateLoginField(){
        populateDocElement(getDocElement(userIdBoxId), userId);
    }

    public void logIntoSite() {
        localChromedriver.findElement(By.id(login_button)).submit();
    }

    public String getTitle(){
     return localChromedriver.getTitle();
    }
    @Override
    public void initializeWebDriver() {

    }

    public WebElement getLogonOrRegisterButton(){
        return  localChromedriver.findElement(By.cssSelector("a[class='btn btn--inverse btn--login']"));
    }

    public WebElement getContinueButton(){
        return  localChromedriver.findElement(By.id("LOGIN"));
    }
    @Override
    public WebElement getDocElement(String elementName) {
        return localChromedriver.findElement(By.cssSelector("#"+elementName));
    }
    @Override
    public List<WebElement> getDocElements(String elementName) {
         return null;
    }
   @Override
    public void logOutOfSite() {

    }
    @Override
    public void populateDocElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public List<String> getPacNos(){
        List<String> pacCodes;
        List<WebElement> pacCodeElems = localChromedriver.findElements(By.name("userPac"));
        pacCodes = pacCodeElems.stream()
                .map(pacCodeElem -> new String(pacCodeElem.getText()))
                        .collect(Collectors.toList());
        return pacCodes;
    }
    public void populatePacNos() {
        String pacCode = caPacNo;
        int pacArrcount=1;
        char [] pacArray = pacCode.toCharArray();
        for (char pacDigit : pacArray){
            populateDocElement(localChromedriver.findElement(
                                        By.name("userPac"+pacArrcount)),
                                              String.valueOf(pacDigit));
            pacArrcount++;
        }
    }

    @Override
    public void quitChromeWebDriver() {
        localChromedriver.quit();
    }
}