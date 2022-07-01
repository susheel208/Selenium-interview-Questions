package com.ui;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWIndows {
	
	
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver();		// Creating the object of the webdriver
		 	d.get("https://www.salesforce.com/in/?ir=1");	//opening the website with the given link
			d.manage().window().maximize();
			d.findElement(By.xpath("//*[@id='main']/div[1]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div[1]/div/a")).click();
		
//			step 1 : to get the handles
			Set<String> windowHandles  = d.getWindowHandles();
			System.out.println("windowHandles");
//			step 2 :			
			 Iterator<String> iterator= windowHandles.iterator();
			 String parentWindow = iterator.next();					// first iteration
			 String childWindow = iterator.next();					// Second iteration
			
//			step 3 :		
			 d.switchTo().window(childWindow);
			 
//			step 4 :			 
			 
			 d.findElement(By.xpath("//*[@id='UserFirstName-PTPe']")).sendKeys("Susheel");
			
//			step 5 :	
			 d.switchTo().window(parentWindow);
			
	}
	

}

// To shift from one window to aother window in the browser, we need to know the windowhandles.

// Step 2:
//	      Iterators allow to caller or remove elements for the set/ collections.
//        as we stored the window handles in SET so we are appyling the iteration to the window handles.
 
//Step 3:
//        To switch to particlua window we need to have the te "handle name or varible stored the windhandle".

//  Note :  without step 2 and step 3 if we go for the step 4 : we will find "an error" .  
//          because the webelement in step 4 is in the next window which cant be identified by selenium


