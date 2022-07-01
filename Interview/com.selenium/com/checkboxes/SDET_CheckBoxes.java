// identifing the check box
// spl case: we learn ablut the "Scroling the web page"
//


package com.checkboxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SDET_CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		// Creating the object of the webdriver
	 	driver.get("https://itera-qa.azurewebsites.net/home/automation");	//opening the website with the given link
		driver.manage().window().maximize();	
	
    //1 select  specific check boxes
		 driver.findElement(By.xpath("//input[@id = 'monday']")).click();			// to check the box
			
		 
	// 2 ) select all the check boxes	 
		List<WebElement> checkBoxes =  driver.findElements(By.xpath("//div[@class = 'form-check' ]//input[@type ='checkbox' ]"));		// finding multiple check boxes check the box
		System.out.println("Totla no check boxes" + checkBoxes.size());
		
	 // using for loop to click on all the check boxes	
/*	    for(int i = 0; i<checkBoxes.size();i++) {
			
			checkBoxes.get(i).click();                // geting the check box with the i value from the elist
		}
*/
		
		 // using for each loop to click on all the check boxes	
		
		for(WebElement cbox:checkBoxes) {    // every cbox is a check box
			cbox.click();
		}
		Thread.sleep(2000);
				
		// 2 ) select  check boxes	 based on the	our choice /  select the check boxes randpoml
	// 	task  --> select the monday and the friday check boxes
	
		for(WebElement chbox:checkBoxes) 
		{ 										   // every chbox is a check box
			String checkboxName = chbox.getAttribute("id");    // id attribut we require bec the monday and sunday ard the values of attribute
			
			if(checkboxName.equalsIgnoreCase("monday") || checkboxName.equalsIgnoreCase("Sunday"))  // using or operator insread of redefing it
			{
				chbox.click();
			}
			
					
		}	Thread.sleep(2000);
		
		// 3 ) select  Last 2 ccheck boxes
		// logic : to select the last 2 = total check boxex - 2 
		// if total =7 , we reqiure last 2 to be selected then,  7-2 = 5, it has to start selcting the check boxes from 5 to end
	// select last 2 cboxes	
		
		int totalcboxes= checkBoxes.size();
		for(int i=totalcboxes-2; i<=totalcboxes; i++)
		{
			checkBoxes.get(i).click();           // check boxes are stored in to the LIST so get(i) will get the check boxes based on the index value.
			
		}
		
		// select first 2 cboxes	
		
		
				for(int i=totalcboxes-2; i<totalcboxes; i++)
				{
					if(i<2) 
					{
							checkBoxes.get(i).click();           // check boxes are stored in to the LIST so get(i) will get the check boxes based on the index value.
					}
				}
		
		
			 
	}

} 

//Note:

// if we want to total num of check boxes then we need to write the "xpath common to all"
// if particular is required then we Unique "Xpath is used"
//Actions is a class.
//isSelected() method is very impotant which tell the satus of the radion button/ check box.

