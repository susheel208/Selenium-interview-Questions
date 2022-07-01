package mouseandkeybord;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
	 	d.get("https://jqueryui.com/droppable/");	//opening the website with the given link
		d.manage().window().maximize();
	
// Step 1:  frames are exist in it so we have to shift our control to the frames first.
		 WebElement element = 	d.findElement(By.xpath("//*[@id=\"content\"]/iframe"));  // identify the frame
		 d.switchTo().frame(element);
// step 2: identify drag and drop web elements in that paticular frame
		 
		 WebElement dragelement = 	d.findElement(By.xpath("//*[@id='draggable']"));
		 WebElement dropplement = 	d.findElement(By.id("droppable"));
		 
//step 3: Perfom the action on the drag and drop element variables.
		 Actions action = new Actions(d);
		 action.dragAndDrop(dragelement, dropplement).perform();
		 
	}

}
