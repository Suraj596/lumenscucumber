package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;

import org.openqa.selenium.By;

public class LumensRemoveCart {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensRemoveCart(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void removecart(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
	}
	public void removeproduct() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       
			  driver.findElement(By.xpath(prop.getProperty("cart"))).click();
			  driver.findElement(By.xpath(prop.getProperty("remove"))).click();
			 
	}

	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}


