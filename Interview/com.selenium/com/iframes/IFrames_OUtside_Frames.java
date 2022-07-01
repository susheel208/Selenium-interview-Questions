package com.iframes;
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
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames_OUtside_Frames{
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
	// 1 st frame	
		driver.switchTo().frame("packageListFrame");                  // name of the frame
																		// Now we can interact with the webWElement s inside the frame
		
		driver.findElement(By.xpath("//a[text()=\"org.openqa.selenium\"]")).click();
		driver.switchTo().defaultContent();          //1st frame ---> mainPage
		
/* note :
 * we cannot switch between one frame to another frame directly   1 st frame  ---> 2 nd frame   switching not possible
 * solution:
 *  1st frame ---> mainPage ---> 2 nd frame  ----> 3rd frame
 *  
 *     ---------------->  how to swich  1st frame ---> mainPage
 *  driver.switchTo().defaultContent();           // swiches to mainpage
 * 
 */
		
		// 2nd frame                                            // mainPage ---> 2 nd frame
		driver.switchTo().frame("packageFrame");                  // name of the frame
			
		driver.findElement(By.xpath("//a[@href='Alert.html']")).click();
		

	}

}
