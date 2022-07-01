package majorCodes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SslCertificate {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities dc = new DesiredCapabilities();
	//	dc.setAcceptInsecureCerts(true);							// this step can be replacd by below 2 steps
		
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions crmOptions = new ChromeOptions();
		crmOptions.merge(dc);
		
		WebDriver d = new ChromeDriver(crmOptions);
	 	d.get("https://www.expired.badssl.com/");	
		
	 	
	}

}


// Note:
// CapabilityType  --> is an Interface
// setCapability  --> is am mtehod
// ChromeOptions  --> Class to manage options specific to ChromeDriver.
// 