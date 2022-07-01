package waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicitwaits {


	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
	 	d.get("https://www.salesforce.com/in/?ir=1");	//opening the website with the given link
		d.manage().window().maximize();
//	step 1:	
		 WebElement mainelement = 	d.findElement(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/a"));	 // target element Elctronics
		 Actions action = new Actions(d);
		 action.moveToElement(mainelement).perform();		//mouse houver to the Electronics tab in ebay .

// step 2: Explicit wait applying to the specific elemet with locator.
		
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));			//
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a"))).click();  // element locator to be passed
		
		 
	
	} 

}

//Explict waits : in the web page there will be few web elements which will take more time to load so 
//                in that case we can use the explicit wait to for that particular element.
//*** NoSuchElementException is thrown by "obj.findElement(By by)
//WebdriverWait is a class, WebDriverWait(d, Duration.ofSeconds(10)) --> which will take the driver object as reference (d) and duriation time 
// 
