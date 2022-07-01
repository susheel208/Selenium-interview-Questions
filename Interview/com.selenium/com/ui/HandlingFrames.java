// to handle "<iframes>" we use toswitch() 
// Before finding and performing an operaoin on the webelement in the other frame. 
// step 1> swithch to the frame where the web element is loated.  this step is impotant other wise we will get an error.
// step 2> find the element( id, xpath, name etc.)and perform the opertion.   


package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();											// Creating the object of the webdriver
	 	d.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");	//opening the website with the given link
		d.manage().window().maximize();

	//  .....................Handeling Frames.............................//
		
//		step 1 :
//		d.switchTo().frame(1);		// by using the frame index
		WebElement frameObj = d.findElement(By.id("frameElement")); // identifing element and assing to the variable.
		
		d.switchTo().frame("frameObj");   						    // by using the frame element

		// 		step 2 : 
		d.findElement(By.xpath("/html/body/button")).click();       // finding the button and performing the click operation.
		
		
	}

}


//what is iFrame?  -->  inline Frame is used to embed another document within the current HTML Doc.
//how to find that the web appln has frames or not?   ---> we need to check for the "<iframe> tag " in the HTML code.
// switchTo().frame(index) -->   it will be chsnging the frame as per the index num and index starts from 0

// switchTo()  ---> returns the "TargetLocator" Interface it os webdriver.targetlocator Intreface.