package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;

import org.openqa.selenium.By;

public class LumensTabandFilter {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensTabandFilter(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void lumenstabandfilter(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
		  
	}
	
	public void ceiling() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       driver.findElement(By.xpath(prop.getProperty("lighting"))).click();
	       driver.findElement(By.xpath(prop.getProperty("ceiling"))).click();
			  driver.findElement(By.xpath(prop.getProperty("chandeliers"))).click();
			  driver.findElement(By.xpath(prop.getProperty("largechandeliers"))).click();
		
	}
	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}
