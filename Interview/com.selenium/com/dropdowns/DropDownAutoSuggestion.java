//step1> How to identify auto-duggestion dropdown list 
//step2> How to enter data into the filed
//step3> How to identify use Keyboard keys[enter, arrow up .... etc.,] to enter into the fiels


package com.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		// Creating the object of the webdriver
	 	d.get("https://makemytrip.com/");	//opening the website with the given link
		d.manage().window().maximize();	
	//method 1:
//		d.findElement(By.xpath("//*[@id=\"fromCity\"]")).click();
//		d.findElement(By.xpath("//*[@id=\"fromCity\"]")).sendKeys("Hyderabad");
//		d.findElement(By.xpath("//*[@id=\"fromCity\"]")).sendKeys(Keys.ARROW_DOWN);		// to highlight the first field
//		d.findElement(By.xpath("//*[@id=\"fromCity\"]")).sendKeys(Keys.ENTER);			// highlight the field is now selected
		
	//method 2: 
		 WebElement from_Field = d.findElement(By.xpath("//*[@id=\"fromCity\"]"));  // assign to a variable 
		 from_Field.click();
		 from_Field.sendKeys("Hyderabad");
		 Thread.sleep(2000);
		 from_Field.sendKeys(Keys.ARROW_DOWN);		// to highlight the first field.
		 Thread.sleep(2000);
		 from_Field.sendKeys(Keys.ENTER);			// highlight the field is now selected.
		 Thread.sleep(2000);
	
		
		 
		 
	}
	
	
	
	
}
