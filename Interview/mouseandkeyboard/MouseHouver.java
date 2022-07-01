package mouseandkeybord;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHouver {


		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
		 	d.get("https://www.salesforce.com/in/?ir=1");	//opening the website with the given link
			d.manage().window().maximize();
			
			 WebElement element = 	d.findElement(By.xpath("//*[@id='support-service_menu_item']/button)"));  // target element which has to be identified 

			 Actions action = new Actions(d);
			 action.moveToElement(element).perform();
	}

}


//note:
//   Use "Actions class"  used to perform the Keyboard or Mouse Operations. 
//   Implements the builder pattern: Builds a Composite Action containing all actions specified by the method calls. 
// ***  Call perform() at the end of the method chain to actually perform the actions.***
