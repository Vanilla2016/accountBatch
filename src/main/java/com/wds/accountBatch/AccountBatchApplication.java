package com.wds.accountBatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

@SpringBootApplication
public class AccountBatchApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccountBatchApplication.class, args);
	}


	private void setup(){
		System.out.println("Setting properties.");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome Beta\\Application");
	}
}
