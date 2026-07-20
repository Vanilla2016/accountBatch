package com.wds.accountBatch;

import static org.assertj.core.api.Assertions.assertThat;

import com.wds.accountBatch.drivers.CaterAllenDriverUtil;
import com.wds.accountBatch.drivers.WebDriverUtil;
import com.wds.accountBatch.extensions.BeforeAllExtension;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

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

	@Value("${spring.application.ca_welcome}")
	private String caWelcome;

	@Value("${spring.application.ca_login}")
	private String caLogin;

	@Value("${spring.application.ca_pac}")
	private String caPac;

	@Value("${spring.application.ca_pac_no}")
	private String caPacNo;


	String welcomePageURL = null;

	String loginFormURL = null;

	String caPacURL = null;

	@Test
	void contextLoads() {
	}

	@BeforeAll
	static void setupClass() {
		//driverUtil = new CaterAllenDriverUtil();
	}

	@AfterAll
	void teardown() {
		localDriver.quitChromeWebDriver();
	}

	@BeforeAll
	void setupTest() {
		welcomePageURL = propertiesPath.concat(caWelcome);
		loginFormURL = propertiesPath.concat(caLogin);
		caPacURL = propertiesPath.concat(caPac);
	}
	@Disabled
	@Test
	void testIsCaterAllen() {

	}

	/*Test navigate to welcome page, then navigate to login page */
	@Test
	void testLoadCAWelcomeAndNavigateToWelcome(){
		String title = null;
		localDriver.navigateSite(welcomePageURL);
		title = localDriver.getTitle();
		// Verify
		assertThat(title).contains("Trust, Pension & Personal Bank Accounts | Cater Allen");

		WebElement logonButton = localDriver.getLogonOrRegisterButton();
		logonButton.click();

		localDriver.navigateSite(loginFormURL);
		title = localDriver.getTitle();
		// Verify
		assertThat(title).contains("Welcome to Cater Allen Private Bank");
	}
	@Test
	public void testIdEntered(){
		localDriver.navigateSite(loginFormURL);
		localDriver.populateLoginField();
		String userId = localDriver.getUserId();
		String userIdBoxId = localDriver.getUserIdBoxId();
		assertThat(userId.equalsIgnoreCase(
					localDriver.getDocElement(
							userIdBoxId).getTagName()));
		WebElement continueButton = localDriver.getContinueButton();
		continueButton.submit();
	}
	@Test
	void testIsLoginSuccesful(){
		localDriver.navigateSite(loginFormURL);
		localDriver.logIntoSite();
		String title = localDriver.getTitle();
		assertThat(title).doesNotContain("Welcome to Cater Allen Private Bank");
	}

	@Test
	void TestPacEnteredSuccesfully(){
		String title = null;
		localDriver.navigateSite(caPacURL);
		title = localDriver.getTitle();
		assertThat(title.contains("Welcome to Cater Allen Private Bank"));

		localDriver.populatePacNos();

		/* Cycle through pacNo element array to check values equal to properties array*/
		String [] pacArray = caPacNo.split(",");
		List<String> pacNos = localDriver.getPacNos();

		for (String pacNo: pacNos){
			System.out.println(pacNo);
			int pacNoCount = 0;
			//assert pacNo != null;
			assertThat(pacNo).isEqualTo(pacArray[pacNoCount]);
			pacNoCount++;
		}
	}
}
