package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		// Creating the object of the webdriver
	 	d.get("https://makemytrip.com/");	//opening the website with the given link
		d.manage().window().maximize();	
	

		
//...................Code for scrolling action......................//
		WebElement radio1 =	d.findElement(By.xpath("// input[@id='doi0']"));		// uni
		 Actions scroll =	new Actions(d);			// instead of using the mouse or keyboad we can use this action class for powerfull guestures.
		 scroll.moveToElement(radio1);				// our targer is radio button.
		 scroll.perform();					// when ever the actions classs is used then we need to call the "perform"  method to to actually perform the actions.
//................... scrolling action end......................//		 
		 
		 
		 radio1.click();
		 WebElement radio2  =  d.findElement(By.xpath("//*[@id='doi1']"));
		
		 System.out.println(radio1.isSelected());		// returns true or false.
		 System.out.println(radio2.isSelected());
		 
		 System.out.println(d.findElements(By.xpath("//*[@type='radio']")).size());
		 

	}

}
