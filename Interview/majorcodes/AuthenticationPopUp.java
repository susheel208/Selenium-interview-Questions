package majorCodes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUp {

	
	public static String username = "admin";  // consider that data collected from csv, excel
	public static String password = "admin";
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
	    d.get("https://the-internet.herokuapp.com/basic_auth");
	
//		direct step: but hard-coded
	    d.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	    
//		direct step: but flexible-coded
	    d.get("https://" + username +":" + password +"@the-internet.herokuapp.com/basic_auth");
	}

}
