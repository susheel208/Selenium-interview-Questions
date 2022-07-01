package mouseandkeybord;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeWidget {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
	 	 d.get("https://jqueryui.com/resizable/");	//opening the website with the given link
		 d.manage().window().maximize(); 
	
// Step 1:  frames are exist in it so we have to shift our control to the frames first.
		 WebElement frame = 	d.findElement(By.xpath("//*[@id='content'/iframe"));  // identify the frame
		 d.switchTo().frame(frame);
		 
		 WebElement widget = d.findElement(By.xpath("//*[@id=\"resizable\"]"));
		 
		 Actions action = new Actions(d);    // ACtions construtor takesobject as the argument 
		 action.dragAndDropBy(widget, 300,100);
		 
		 
// ---------------------perform Mouse Right click ---------------------------
		 
//		 need to write all the steps of step 1
		 action.contextClick().perform();				// context click means right click.
		 
		 
		 
	}

}
