package com.ui;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MethodsOfInterface {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		// Creating the object of the webdriver
		
	    //.................... how to acess the website from the webdriver.......................//
		
		d.get("https://www.saucedemo.com/");	//opening the website with the given link
		d.manage().window().maximize();		    // maximizing the website
		
		String url = d.getCurrentUrl();		    // return string, the output is active url, so it can be stored in a varible of string data type
		System.out.println(url);
		
		String title = d.getTitle();
		System.out.println(title);
		
			
		//..................... login sucessfull	
		d.findElement(By.id("user-name")).sendKeys("standard_user");
		d.findElement(By.id("password")).sendKeys("secret_sauce");      // "By" is the class so to access the method "id" we need to use "By.id()"
		d.findElement(By.xpath("//input[@id='login-button,]")).click(); // there are 2 backets "before"-click() method any bracket is missed then wecannot access the click() method
					
		//......................how to access the web element after opening the webpage in the browser.............
	 	
		List<WebElement> web_ele = d.findElements(By.xpath("//div[@class='inventory_item']"));			// here xpath gives all the items list.
																										// those items are stored into the list "web_ele" variable
		
		d.navigate().to("https://www.youtube.com/");   // "to(url)" method is used to pass the url to aceess from  the history.
		
		d.getWindowHandle();
	
		
	}

}
