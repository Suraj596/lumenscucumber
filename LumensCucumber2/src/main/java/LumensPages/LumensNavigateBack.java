package LumensPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LumensNavigateBack {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensNavigateBack(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void navigate(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
	}
	public void navigateback() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       
	       driver.findElement(By.xpath(prop.getProperty("lighting"))).click();
	       driver.findElement(By.xpath(prop.getProperty("ceiling"))).click();
	       driver.navigate().to(prop.getProperty("url"));
	}

	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}


