// identifing the check box
// spl case: we learn ablut the "Scroling the web page"
//


package com.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		// Creating the object of the webdriver
	 	d.get("https://makemytrip.com/");	//opening the website with the given link
		d.manage().window().maximize();	
	
	// Now the situation is our targeted check box is not visible so need to "scroll the webpage"	.
		
		//step 1: we will plan to scroll the page upto & by keeping a particular webelement as the target
        //		  in ths example we are taking  radio button as athe target upto which we have to scroll. so that the check box is visible.
		
//...................Code for scrolling action......................//
		
		 WebElement radio =	d.findElement(By.xpath("// input[@id='doi0']"));		// uni
		 Actions scroll =	new Actions(d);			// instead of using the mouse or keyboad we can use this action class for powerfull guestures.
		 scroll.moveToElement(radio);				// our targer is radio button.
		 scroll.perform();					// when ever the actions classs is used then we need to call the "perform"  method to to actually perform the actions.
//................... scrolling action end......................//		 
		 
		 
		 d.findElement(By.xpath("// input[@name='interest_sell_c']")).click();			// to check the box
		 System.out.println(d.findElement(By.xpath("// input[@name='interest_sell_c']")).isSelected());		// returs True/ false and tell weather the check box/ radio button is checked or not.
		 Thread.sleep(2000);
		 d.findElement(By.xpath("// input[@name='interest_sell_c']")).click();			// to UNcheck the box
		 Thread.sleep(2000);
		 
		 																			// to find total number of check boxex findelememts is used
	System.out.println(d.findElements(By.xpath("//input[@type='checkbox']")).size());
		 
	}

} 

//Note:

// if we want to total num of check boxes then we need to write the "xpath common to all"
// if particular is required then we Unique "Xpath is used"
//Actions is a class.
//isSelected() method is very impotant which tell the satus of the radion button/ check box.

