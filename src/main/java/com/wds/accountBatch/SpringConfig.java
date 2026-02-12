package com.wds.accountBatch;

import com.wds.accountBatch.drivers.CaterAllenDriverUtil;
import com.wds.accountBatch.drivers.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.wds.accountBatch.drivers","com.wds.accountBatch.drivers"})
@PropertySource({"classpath:application.properties"})
public class SpringConfig {

    @Autowired
    Environment env;

    @Bean
    static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public String testBrowser(){
        return new String();
    }

    @Bean
    public WebDriverUtil localDriver() {
       if (env.getProperty("browser").equalsIgnoreCase("chrome")) {
           System.out.println("Nstantiating CD");
            //System.setProperty("webdriver.chrome.driver", "src/main/java/com/labs/abc/Libs/chromedriver.exe");
            return new CaterAllenDriverUtil();
        }
        return null;
    }
}
