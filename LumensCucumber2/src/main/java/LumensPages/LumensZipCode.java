package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class LumensZipCode {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensZipCode(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void zipcode(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
	}
	public void zipcodeapply(String Zipcode) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       
			  driver.findElement(By.xpath(prop.getProperty("cart"))).click();
			  driver.findElement(By.xpath(prop.getProperty("secure"))).click();
			  driver.findElement(By.xpath(prop.getProperty("manual"))).click();
			  driver.findElement(By.xpath(prop.getProperty("zip"))).sendKeys(Zipcode);
			  
			  
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 
	}

	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}


