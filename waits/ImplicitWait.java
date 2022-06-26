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
 * 
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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("hhtps://");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   // duration is the class, ofSeconds is the staic method
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.xpath("//h3[text() ='Selenium WebDriver']"));
		
		
		//WebDriverWait mywait = new WebDriverWait(driver,50);
		//WebElement element  = mywait.until(ExpectedCondition.visibilityOfElementLocated())
		
	}

}
