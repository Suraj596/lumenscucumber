package LumensPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LumensScrollupdown {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensScrollupdown(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void scrollupdown(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
	}
	public void scroll() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       
	       Actions action=new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions action1=new Actions(driver);
			action1.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}


