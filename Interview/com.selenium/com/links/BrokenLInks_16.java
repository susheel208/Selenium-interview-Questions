package com.links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*

What is Broken Link? How to check it?

Broken Link: is something which doesnt have  any target page in server. note even broken links have the anchor tag -a
how to find it: send the link through browser, and check the response code.and code>400 then it is a a broken link.

href  -> notdefined  --> url is empty
href -> link is defined but it is not naviagating to that url page    --> it is abroken link
 */

public class BrokenLInks_16 {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();									// Creating the webdriver instance
	 	driver.get("http://www.deadlinkcity.com/");								//opening the website with the given link
		driver.manage().window().maximize();
	
	//************** HOw to extract all Links****************
		List<WebElement> links = driver.findElements(By.tagName("a"));               //extracts all the links with the tag name -a
		System.out.println(links.size());
	int brokenLinks = 0;                                                         // to know the total broken lins
		// capturing the "href" attribute from the broken links
		
	for( WebElement element:links) {
			String urlOfElement = element.getAttribute("href");
	// 3 conditions are present 1) valid link 2) no link/ empty link3) broken link

	// check for no link
			if(urlOfElement == null || urlOfElement.isEmpty())
			{
				System.out.println("url is empty");
				continue;    // move to the next element
			}
			
			URL url_link = new URL(urlOfElement);                  // converting the urlOfElement --> from string to url format
			
			try {
				HttpURLConnection httpconn = (HttpURLConnection) url_link.openConnection();
				httpconn.connect();   // sends the request & opens the given url.
			
	// check form broken and valid link	
				if(httpconn.getResponseCode()>=400) {       // Response code > 400 then iot is a broken link
					
					System.out.println(httpconn.getResponseCode()+" " + url_link +" is" + " is a broken link" );
					brokenLinks++;    //
					
				}
				else {
					System.out.println(httpconn.getResponseCode()+" "  + url_link+" is" + " is a valid link" );
					
				}
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}  // 
			
			
			
		}
		System.out.println("No of broken links: "+ brokenLinks);
	
	}

}
