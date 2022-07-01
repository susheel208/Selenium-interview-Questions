// this process is for the DropDown with Select as the <tagname>

package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		// Creating the object of the webdriver
	 	d.get("https://www.sugarcrm.com/au/request-demo/");	//opening the website with the given link
		d.manage().window().maximize();		
						
		//........... handlening the drop-downs with the "select" as Tagname, and Options below it

//	Step 1 > We need to use "select class" and create an object.
		
		WebElement ddown = d.findElement(By.name("employees_c"));
		Select ele = new Select(ddown);  // it is the consrtuctor we need to pass the attribute webelement
		
		ele.selectByIndex(5);		// index starts from 0
		Thread.sleep(2000);			// to provide wait
		
		ele.selectByValue("level1");
		Thread.sleep(2000);			// to provide wait
		
		ele.selectByVisibleText("501 - 1,000 employees");
	
	}

}
