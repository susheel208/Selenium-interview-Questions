package com.iframes;
import org.apache.commons.compress.archivers.sevenz.CLI;
/* Difference between Frames & iFrames?
 * Frames: which will divide the page into the patitions like hosizontal and vertically
 * 		but it is the part of the web page only. 
 * 		we can interact with these elements & perform the actions.
 * 
 * iFrame: is in which we store the contents which is coming from the another source but they are internally related. like video, text, element
 * 			we cannot interact with these elements & cannot perform the actions. --> it will throw "NoSuchElemntException" ,unable to locate the element
 * 			so we need to switch to that iframe and perform the action
 * 			we can identify through "iframe tag"
    
       //----------------> ways to switch to frame  <----------------
 * 
 * driver.switchTo().frame(name of the frame / id of the frame)
 * driver.switchTo().frame(WebElement)         --> send the frame as the webElement
 * driver.switchTo().frame(0)      --> send index value
 */
/* note :
 * we cannot switch between one frame to another frame directly   1 st frame  ---> 2 nd frame   switching not possible
 * solution:
 *  1st frame ---> mainPage ---> 2 nd frame  ----> 3rd frame
 *  
 *     ---------------->  how to swich  1st frame ---> mainPage
 *  driver.switchTo().defaultContent();           // swiches to mainpage
 * 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames_inside_Frames{                             // frame within a frame example
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();	// to get the multiple frme window
		
		// ouer frame
		WebElement outerframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));  // as there wan no id nor mne of the frame so we took ita s a webelement
		driver.switchTo().frame(outerframe);      // here we are passing the frame as the webElement
	
		// frame into the frame then we no need to use 
		//driver.switchTo().defaultContent();
		
		
		WebElement innerframe = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		
		driver.switchTo().frame(innerframe);                  // name of the frame
			
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("welcome");
		

	}

}
