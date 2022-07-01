/**
 * 
 */
package com.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * what is DropDown_BootsTrap_9?
 * it is a css framwork to develope  the responsive websites, 
 * this is used to represent the elements in a beautifull manner
 * this are similar to the dropdowns but the this may be button 
 * with the links or with the  tagname, etc
 *
 */
public class DropDown_BootsTrap_9 {

	/**
	 * indentify the drop down + click
	 * grap all the web elements using FindElements into a list
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div/a")).click();	
	
	List<WebElement> dropDownList = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));   // if "li" is there then it will not give the product list item by itemll not select the 
	
	System.out.println("No of Options " + dropDownList.size());    // li tag meanse list items
	
//	for (WebElement Ptype:dropDownList) {                 // this  loops is converted into the method
//		
//		if(Ptype.getText().equals("Accounts")) {
//			
//			Ptype.click();
//			break;
//		}
//		
//	}
	
	selectOptionFromDropDown(dropDownList, "Accounts");   // parameters  to pass is (list of webelemets variable, the element to find
	
	}

	
	public static void selectOptionFromDropDown(List<WebElement> dropDwn_Option, String value) {
		
		for (WebElement Ptype:dropDwn_Option) {                    // list os assigned to the Ptype var and is converted to a webelement
		
		if(Ptype.getText().equals(value)) {
			
			Ptype.click();
			break;
		}
		
	}
		
		
	}
	
	
	
	
	
	
	
	
}
