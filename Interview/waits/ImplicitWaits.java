package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaits {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
	 	d.get("https://www.ebay.com/");	//opening the website with the given link
		d.manage().window().maximize();
//	step 1:	
		 WebElement mainelement = 	d.findElement(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/a"));	 // target element Elctronics
		 Actions action = new Actions(d);
		 action.moveToElement(mainelement).perform();		//mouse houver to the Electronics tab in ebay .

// step 2:
		
		 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;		// --> what will happen if the wait is in step 1 and step 2
		 WebElement subelement = d.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")); 
		 subelement.click();
	
	
   }
		

	

}

// timeouts --> returns an interface
// TimeUnit --> is a class.
//*** NoSuchElementException is thrown by "obj.findElement(By by)