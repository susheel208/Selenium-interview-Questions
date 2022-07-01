package com.ui;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreeenShot {

	public static void main(String[] args) throws IOException {
	//Step 1:  To create an Unique File name with the "Timestamps".
		Date currentDate = new Date();                // this will give the time and date  but we need to convert it into the string + requred format.
	    String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");   // this will chage into the string and it will change its Format.
													
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		                                //Creating the object of the webdriver
	 	d.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");	//opening the website with the given link
		d.manage().window().maximize();
	//Step 2:  To Take screenShot.
		File screenShotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);       // this will take the screen shot
	//Step 3:  To Take screenShot and save it into the new file .	
		FileUtils.copyFile(screenShotFile, new File(".///screenshot//" + screenShotFileName + ".png"));   //this will create the folder to store the screen shot
		
		
	}

}
