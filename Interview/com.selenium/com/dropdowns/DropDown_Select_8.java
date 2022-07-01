/**
 * 
 */
package com.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this program is used when we have the "select tag" fro that drop down
 *
 */
public class DropDown_Select_8 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static WebDriver driver;
	public static WebElement ele;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.opencart.com/index.php?route=account/register");
		ele = driver.findElement(By.id("input-country"));

		// Approach 1 USING SELECT CLASS

		// step1 find the webelement
		// create the object of the select class & pass the elemet as argument into the
		// select constructor
		// use selectByIndex, selectByValue, selectByVisibleText

		Select dropCountry = new Select(ele);
		dropCountry.selectByIndex(72); // finland // index starts from zero
		Thread.sleep(2000);
		dropCountry.selectByValue("4"); // Amereica // send the value of the value attribute
		Thread.sleep(2000);
		dropCountry.selectByVisibleText("India");

		SelectOptionFRmDRopDown(ele, "Cuba");

	}
//    ----- > generic method  <-------------
	// Select Class but using the above 3 methods
	
	// this method will be usefull if we are having multiple drop down also
	public static void SelectOptionFRmDRopDown(WebElement Element, String value) {
		Select drop = new Select(ele);
		;
		List<WebElement> allOptions = drop.getOptions(); // every option is an webElement

		for (WebElement Option : allOptions) {
			if (Option.getText().equals(value)) {
				Option.click();
				break; // to break the loop

			}
		}

	}

}
