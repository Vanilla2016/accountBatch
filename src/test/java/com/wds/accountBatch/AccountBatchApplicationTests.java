package com.wds.accountBatch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
class AccountBatchApplicationTests {

	@Test
	void contextLoads() {
	}

	WebDriver driver;
	ChromeOptions options;

	@BeforeAll
	static void setupClass() {
			//WebDriverManager.chromedriver().setup();
		String targetVersion = "145.0.7632.26"; // Replace with your version
		WebDriverManager.chromedriver().clearDriverCache().browserVersion(targetVersion).setup();
		//	System.setProperty("webdriver.chrome.driver",
		//		"C:\\Users\\domin\\.cache\\selenium\\chromedriver\\win64\\chromedriver.exe");
	//	System.out.println(System.getProperty("webdriver.chrome.driver"));
	}

	@AfterEach
	void teardown() {
		driver.quit();
	}

	@BeforeEach
	void setupTest() {

		options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application");
		driver = new ChromeDriver(options);
	}

	@Test
	void test() {
		// Exercise
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		String title = driver.getTitle();

		// Verify
		assertThat(title).contains("Selenium WebDriver");
	}

}
