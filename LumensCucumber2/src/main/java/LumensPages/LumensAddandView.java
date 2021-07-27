package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;

import org.openqa.selenium.By;

public class LumensAddandView {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensAddandView(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void lumensaddandfilter(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
		  
	}
	
	public void addview() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       
			  driver.findElement(By.xpath(prop.getProperty("addcart"))).click();
			  driver.findElement(By.xpath(prop.getProperty("checkout"))).click();
			  driver.findElement(By.xpath(prop.getProperty("viewcart"))).click();
	}
	
	
	
	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}
