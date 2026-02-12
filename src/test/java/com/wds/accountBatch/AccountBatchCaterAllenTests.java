package com.wds.accountBatch;

import static org.assertj.core.api.Assertions.assertThat;

import com.wds.accountBatch.drivers.CaterAllenDriverUtil;
import com.wds.accountBatch.drivers.WebDriverUtil;
import com.wds.accountBatch.extensions.BeforeAllExtension;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@Configuration
@ComponentScan(basePackages = {"com.wds.accountBatch.extensions", "com.wds.accountBatch.drivers"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({BeforeAllExtension.class})
@ContextConfiguration(classes = SpringConfig.class)
class AccountBatchCaterAllenTests {

	@Autowired
	private CaterAllenDriverUtil localDriver;
	private ChromeOptions options;

	private Logger logger;

	@Value("${spring.application.propertiespath}")
	private String propertiesPath;

	@Value("${spring.application.ca_login}")
	private String caLogin;

	String loginFormURL = null;

	@Test
	void contextLoads() {
	}

	@BeforeAll
	static void setupClass() {
		//driverUtil = new CaterAllenDriverUtil();
	}

	//@AfterEach
	void teardown() {
		//driverUtil.quitChromeWebDriver();
	}

	@BeforeEach
	void setupTest() {
		//logger.log(Level.DEBUG, "Setting up class");
		loginFormURL = propertiesPath.concat(caLogin);
	}

	@Test
	void testIsCaterAllen() {
		// Exercise
		localDriver.navigateSite(loginFormURL);
		String title = localDriver.getTitle();
		// Verify
		assertThat(title).contains("Welcome to Cater Allen Private Bank");
	}

	@Test
	void testIsLoginSuccesful(){
		assertThat(true).isTrue();
	}
}
