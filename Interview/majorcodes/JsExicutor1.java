package majorCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsExicutor1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
	 	d.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");	//opening the website with the given link
		d.manage().window().maximize();

// Step 1 : creating a reference 
		JavascriptExecutor js	=(JavascriptExecutor) d;		// casting the driver Object
		
//Print the Tile of the page
		String script = "return document.title;" ;			// Step a
		String title = (String) js.executeScript(script);
		System.out.println(title);
		
//Click Button which is in another frame:
		d.switchTo().frame("iframeResult");
		js.executeScript("myFunction()");			//this will exicute the click opertaion
		Thread.sleep(2000);
		d.switchTo().alert().accept();				// this will do click operation in the alert box.
		

// Highlite the button:
		WebElement tryButton = d.findElement(By.xpath("/html/body/button"));
		js.executeScript("arguments[0].style.border = '5px solid green'", tryButton);
		
//Scroll the web page
		d.navigate().to("https://w3schools.com/");								// navigating to another page.
		WebElement W3SchoolShopButton = d.findElement(By.xpath("//*[@id=\"main\"]/footer/div[3]/a"));
		js.executeScript("arguments[0].schrollIntoView[true];", W3SchoolShopButton);
				
		
		
	}

}

// step a :
//			we can check the document.title in " inspect > console"
// always Js code will end with the "semicolon";"" and the statement will be inside the double quotes -->" "

// Click Button which is in another frame:
// |---> this will click the button "without its Xpath or id". -->  instead of that will use the fuction in the script