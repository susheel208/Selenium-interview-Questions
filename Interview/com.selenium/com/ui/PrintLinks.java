// to print all the links present in the webpage.
//step 1>  so to know the total num of the elements in the list we need size of the list.
//step 2>  as there are multiple links we need to use "for / foreach loop" to te list.
// note thsi code can be use full to print alll the attibute values or visibike test of the "dropdown list" <option>

package com.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintLinks {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();							// Creating the object of the webdriver
	 	d.get("https://www.sugarcrm.com/au/request-demo/");			//opening the website with the given link
		d.manage().window().maximize();		
						
		List<WebElement> links = d.findElements(By.tagName("a"));	// there are multiple links so we use the "findElememts", here links is the variable which stores the List of links availble in the webpage. 
		System.out.println("Total num of Tags are: " + links.size());		// to print the toltal num of links.
				
		for(int i=0; i<links.size();i++) {
		System.out.println(links.get(i).getAttribute("href"));		// href is the attribute, this will return the value of the attribute 
		System.out.println(links.get(i).getText());					// returns the visible text. fo that aparticular attribute.
	}																//'get' applied to the list will return the specific position of the element isn the list wrt index value.

}
}