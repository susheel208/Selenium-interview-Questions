/* what is SYnchronization problem?
 * Ans :  there is no balance between the automation script and the application.
 * explanation:  when our test case / test script gets exicuted step by step at that instance,  
 * the application / webelement availability of element  / response time more time at that 
 * time it will throw an exception.
 * 
 * basically the test script will run faster than the application
 * 
 * to solve this we use the wait.
 * 
 * Implicit wait  --> it is a global wait, it is appalicable for all the element in script.
 * 			syntax => driver.manage().timeouts().implicitlyWait(time);  -->  this can be used at the begining of the code after the driver is instaciated
 * 	 Advantages     : we need to add only once. in the entire test script.
 * 
 * explicit wait  --> specifically for that element, it will wait upto the condition satisfies
 * 
 * syntax/ code: 
 * WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element  = mywait.until(ExpectedConditions.visibilityOfElementLocated())
	Advantages: it is element specifc,
	 			works based on the certain condition	
	 disadvantages: it has to use multiple times to multiple webElements, itfeels a bit difficilty
 * 
 * 
 * Fluent Wait
 */


package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait_withGenicMethod {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("hhtps://");
	  // duration is the class, .ofSeconds is the staic method
		
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.xpath("//h3[text() ='Selenium WebDriver']")).click();
		
		By eleLocator = By.xpath("//h3[text() ='Selenium WebDriver']");
		
		waitForElementPresent( driver,eleLocator , 10).click() ;  // generic method , can be used for the multiple elements
		
			
		
		//visibilityOfElementLocated -> it wll check the condition the webElment located by xpath is visible or not.
		// it will return True --> it will return the element.  false---> returns the exception
		//WebElement element  = mywait.until(ExpectedConditions.visibilityOfElementLocated())
		
	}

	// Creating  Explicit wait Generic Method to be used for multiple WebElements
	
	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout) 
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));  // this is cut-off time it will exist as soon as the time is up
		mywait.until(ExpectedConditions.presenceOfElementLocated(locator));  // condition is true --> returns the webElement.
				
		return driver.findElement(locator);
		
	}
	
	
	
	
}
