package com.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest{

		public static String browser = "chrome";
		public static WebDriver driver;
		
		public static void main(String[] args) {
			
		if (browser.equals("chrome")) {
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.get("https://www.saucedemo.com/");
		   
		}
//	else if (browser.equals("firefox")) {	
//			WebDriverManager.firefoxdriver().setup();
//	        driver = new FirefoxDriver();
	      
		//}

		
	     		
		}

}