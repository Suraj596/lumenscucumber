package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;

import org.openqa.selenium.By;

public class LumensQuantity {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensQuantity(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void lumensproductandfilter(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
		  
	}
	
	public void filter() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	      
			  driver.findElement(By.xpath(prop.getProperty("filter"))).click();
			  driver.findElement(By.xpath(prop.getProperty("product"))).click();
		
	}
	
	public void quantityincrease(String quant) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	      
			  driver.findElement(By.xpath(prop.getProperty("quantity"))).click();
			  driver.findElement(By.xpath(prop.getProperty("quantity"))).clear();
			  driver.findElement(By.xpath(prop.getProperty("quantity"))).sendKeys(quant);
			  
		
	}
	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}
