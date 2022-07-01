package com.WindowHandles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/* 1) How To Handle Browser Windows in Selenium WebDriver?
2) What is the Difference between getWindowHandle() & getWindowHandles() methods?
3) How To Switch between Multiple Browser Windows?
4) What is the difference between close() and quite() methods?
5) How to close All browser Windows?
6) How To close Specific Browser Window by choice?

if we know browser window id then we can switch between the windows
  for that window id  --> we have  getWindowHandle() and getWindowHandles()
 */

public class Browserwindowhandles {
	public static WebDriver driver;
	static Set<String> Multi_windowIds;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		// Creating the webdriver instance
	 	driver.get("https://opensource-demo.orangehrmlive.com/");	//opening the website with the given link
		driver.manage().window().maximize();

		//getWindwoHAndle()  --> returns the window id in String format,
		// every time when we will get the different / dynamically window id value
		
		String windowId = driver.getWindowHandle();  
		System.out.println(windowId);            //CDwindow-0441B55D973F3EC2E2CC831F6FFCDBD8   --> this will be diffreent / unique  next time
												//CDwindow-68DF9522741AC89B57DA3F1F8EC26BE6   
		driver.findElement(By.xpath("//a[@target = '_blank']")).click();		// clicks on the OrangeHRM link, opens another browser window - it ic a child window.
	
//	 	method1 for calling parent and child using  list concept:
		
		
		 Set<String> Multi_windowIds = driver.getWindowHandles();      // returns id of multipke browser windows
	
		 List<String> Multi_windowIdsList = new ArrayList(Multi_windowIds);  // converting the Set  --> to List
	
		 /*
			String ParentID = Multi_windowIdsList.get(0);    // Parent Window ID,   call the value using "List Index concept"
			String ChidID = Multi_windowIdsList.get(1);		 // Child Window ID
			
			System.out.println( "parent window id "+ParentID);
			System.out.println("Child window id "+ChidID);
			
			// ************************* how to use Window ID to switch between the windows 
			 

			
					 driver.switchTo().window(ParentID);
					 System.out.println("parent window Title: " + driver.getTitle());
					 
					 driver.switchTo().window(ChidID);                                           // if we switch to child window only we can interact between the child window elements
					 System.out.println("Child window Title: " + driver.getTitle());
					
*/
		
/*		// for each loop: for getting of title the broser windor and closing --> highlited window.
		for (String windid: Multi_windowIdsList) {
			String title = driver.switchTo().window(windid).getTitle();     //  we are getting the tiltes of the browser window
			System.out.println(title);
		
		}
					 
    driver.close();   //closes the specific window the driver is pointing. 
    driver.quit();    // closes all the browser windows.
	    
	*/
		 
// closing the browser window based on the window title:
		 
    for (String windid: Multi_windowIdsList) {
		String title = driver.switchTo().window(windid).getTitle();     //  we are getting the tiltes of the browser window
	//	if(title.equals("OrangeHRM")||title.equals("another title"))           and the  or operator will is used to close multiple
			if(title.equals("OrangeHRM")) 									 // ---> closes the parent window 
		{
			driver.close();
		}
		
	}
					 
					 
					 
					 
					 
					 
					 
		 
	/*	 // creting object  to call methods:
		 Browserwindowhandles bwh = new Browserwindowhandles();
		 bwh.firstMethod();
		 bwh.SecondMethod();
		*/ 
		
	}
	
		
		// first method - iterator()
	 void firstMethod() {
		
		Iterator<String> it = Multi_windowIds.iterator();             //  same step as explaned in the collections
		String ParentID = it.next();
		String ChidID = it.next();
		
		System.out.println( "parent window id "+ParentID);
		System.out.println("Child window id "+ChidID);
		
	}
		
	// 2nd method using List
	
	 void SecondMethod() {
		List<String> Multi_windowIdsList = new ArrayList(Multi_windowIds);  // converting the Set  --> to List
		
		String ParentID = Multi_windowIdsList.get(0);    // Parent Window ID,   call the value using "List Index concept"
		String ChidID = Multi_windowIdsList.get(1);		 // Child Window ID
		
		System.out.println( "parent window id "+ParentID);
		System.out.println("Child window id "+ChidID);
		
		// ************************* how to use Window ID to switch between the windows 
		 
				 driver.switchTo().window(ParentID);
				 System.out.println("parent window Title: " + driver.getTitle());
				 
				 driver.switchTo().window(ChidID);                                           // if we switch to child window only we can interact between the child window elements
				 System.out.println("Child window Title: " + driver.getTitle());
				
		

}
}
