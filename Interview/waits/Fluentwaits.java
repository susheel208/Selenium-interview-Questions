package waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluentwaits {


	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
	 	d.get("https://www.ebay.com/");	//opening the website with the given link
		d.manage().window().maximize();
//	step 1:	
		 WebElement mainelement = 	d.findElement(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/a"));	 // target element Elctronics
		 Actions action = new Actions(d);
		 action.moveToElement(mainelement).perform();		//mouse houver to the Electronics tab in ebay .

// step 2: Fluent wait applying to the specific elemet with locator.
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(d)
								.withTimeout(Duration.ofSeconds(10))		// total duration 
								.pollingEvery(Duration.ofSeconds(2))		//
								.withMessage("Its a Fluent Wait")
								.ignoring(NoSuchElementException.class);
								
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a"))).click();  // element locator to be passed
		
		 
	
	} 

}

//Fluent waits :it is a class which is an implmentation of the Wait interface, which have the timing interval and pooling 
// Wait : is an interface for waiting until a condition is true or not null.

/*
 *  WebDriver is a remote control interface that enables introspection and
 * control of user agents (browsers). The methods in this interface fall into
 * three categories:
 *					 1)Control of the browser itself, 2) Selection of WebElements, 3) Debugging aids.
 */

