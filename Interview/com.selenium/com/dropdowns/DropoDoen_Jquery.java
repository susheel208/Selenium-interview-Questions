package com.dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropoDoen_Jquery {

	/*
	 * in JQuer Drop Down: we can select the single and multiple options in
	 * drop-down
	 * 
	 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("justAnInputBox")).click();

//		SelectChoiceValues(driver,"choice1");                    
//		SelectChoiceValues(driver,"choice1","choice2","choice3");                 // our purpose is to select the single, multiple and all options based on our require  on            
//		SelectChoiceValues(driver", "all");
//		

	}

	public static void SelectChoiceValues(WebDriver driver, String... value) // String... value --> value is the value
																				// which can save the single, multiple
																				// values in it
	{

		List<WebElement> choiceList = driver.findElements(By.xpath("//sapn[@class='comboTreeItemTitle']"));

		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement item : choiceList) // looping a list to a webelement called "item"
			{
				String text = item.getText(); // geting the "inner-text" of that webElemengt using getText() method

				for (String val : value) // loopging the user defined options
				{ 
					if (text.equals(val)) // check the "inner-text" of the user defined option and the WebElementText
					{ // if cond is true then click
						item.click();
						break;
					}
				}

			}
		} else {            // to select all the options
			try 
			{  // this wsas ging the exceptiom so kept his code in the try catch bloc.
				for (WebElement val : choiceList) 
				{
					val.click();   // looping all the webELements and clicking it.

				} 
				
			}catch(Exception e) {
				
			}
			
			
			
		}

	}
}