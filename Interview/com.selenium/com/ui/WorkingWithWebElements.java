package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithWebElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();	
		d.get("https://www.sugarcrm.com/au/request-demo//");	//opening the website with the given link
		d.manage().window().maximize();	
		
		// ............... step 1>  find the web element "d.findElement(By.name("firstname"))".
		// ............... step 2>  then call the methods to interact with specific web element
		d.findElement(By.name("firstname")).sendKeys("hi Susheel");
		d.findElement(By.name("firstname")).clear();				// clear method clears the existing data in the field
		System.out.println(d.findElement(By.name("firstname")).getAttribute("class"));	// returns the value of the attrible
		System.out.println(d.findElement(By.xpath("//*[@id='field1']/div/input")).getCssValue("text-transform"));   // found it from the inspect > styles
		System.out.println(d.findElement(By.xpath("//*[@id='field1']/div/input")).getLocation());
		System.out.println(d.findElement(By.xpath("//*[@id='field1']/div/input")).getSize());
		System.out.println(d.findElement(By.xpath("//*[@id='field1']/div/input")).getTagName());
		System.out.println(d.findElement(By.xpath("//*[@id='field1']/div/input")).isDisplayed());
		System.out.println(d.findElement(By.xpath("//*[@id='field1']/div/input")).isEnabled());
		System.out.println(d.findElement(By.xpath("//*[@id='field1']/div/input")).isSelected());
	
	
	}

}
