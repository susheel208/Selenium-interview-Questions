package com.links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * How To Locate links in Selenium WebDriver?
What is the difference between LinkText() and PartialLinkText()?
How to capture all the links from Web Page?
What is Broken Link? How to check it?
 */

public class LInks_16 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		// Creating the webdriver instance
	 	driver.get("https://www.amazon.in/");								//opening the website with the given link
		driver.manage().window().maximize();

	// accessing the particuler link with LinkText and Partial LinkkText
		
	//	driver.findElement(By.linkText("Mobiles")).click();              // pass inner Text value;
//		driver.findElement(By.partialLinkText("Mob")).click();              // pass  inner Text value partially;  
		
	//************** HOw to extrract all Links****************
		List<WebElement> links = driver.findElements(By.tagName("a"));               //extracts all the links with the tag name -a
		
		// loop the list to get the inner text of all the links with inner text
		
		for(int i=0; i<=links.size();i++) {
			System.out.println(links.get(i).getText());                          // get inner text of the link, while print if the text is not there then it will give "null"
			System.out.println(links.get(i).getAttribute("href")); // get target link of that link, using the href attribute   /herf --> hiperlink reference.
		
		}
		
		
		
	}

}
