package com.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
	 	d.get("https://www.techlistic.com/p/demo-selenium-practice.html");	//opening the website with the given link
		d.manage().window().maximize();
//		step 1:	Switch to the frame which ahs the particular table ... if fraem is not there skip this step.
										//   d.switchTo().frame(1);
//		step 2:	Get num of Rows.
//		step 3:	Get num of Columns.
//		step 4:	Iterate Rows and Col. to print the text 
		
		 WebElement TableElement = 	d.findElement(By.xpath("//*[@id=\"customers\"]/tbody"));	 // as there are mukltiplr ows we are using he findelements.
		 List<WebElement> rowElement = 	d.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));
		 Thread.sleep(2000);
		 int rows = rowElement.size();
		 System.out.println("no of rows: "+ rows);
		 
		 List<WebElement> columnElement = 	d.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td"));
		 int colomns = columnElement.size();
		 System.out.println("no of colomns: "+ colomns);
			
		 for(int i=1; i<rows; i++) {				// i represents rows, j represents col.
			 for(int j=1; j<rows; j++) {
		 System.out.print(((WebElement) d.findElements(															// for printing in same line
				 By.xpath("//*[@id='customers']/tbody/tr["+ i +"]/td["+ j +"]")))
				 .getText()+ " ");
				 
	}
			 System.out.println();
			 
}

}
}