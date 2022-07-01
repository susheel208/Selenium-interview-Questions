package mouseandkeybord;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEvents {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 WebDriver d = new ChromeDriver();		        //Creating the object of the webdriver
	 	 d.get("https://extendsclass.com/text-compare.html");	//opening the website with the given link
		 d.manage().window().maximize(); 
	
//Step 1:  frames are exist in it so we have to shift our control to the frames first.
		 WebElement sourceTextframe = 	d.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]"));  // identify the frame
		 d.switchTo().frame(sourceTextframe);
		 Actions action = new Actions(d);
		 action.keyDown(sourceTextframe, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		 
		 WebElement pasteTextframe = 	d.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]"));
		 d.switchTo().frame(pasteTextframe);
		 action.keyDown(pasteTextframe, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		 		 
	
		  
	}

}

// KEYS --> is an Enum is a spl class in java, which has constants.
//for sending standard keys like ctrl, shift, enter, alt, etc we need to use --> Keys.CONTROL, keys.SHIFT...
//for sending keys like a,b,c,v ,d...---> sendKeys("a")
// to perform comple keyborad operations (ctrl+c, ctrl+v, shift+ctrl+del) we need to use "build() method".