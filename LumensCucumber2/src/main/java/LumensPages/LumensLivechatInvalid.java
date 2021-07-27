package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class LumensLivechatInvalid {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensLivechatInvalid(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	
	
	public void livechatinvalid(String firstname, String email) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       
	       driver.findElement(By.xpath(prop.getProperty("livechat"))).click();
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  driver.findElement(By.xpath(prop.getProperty("name"))).sendKeys(firstname);
			  driver.findElement(By.xpath(prop.getProperty("emadd"))).sendKeys(email);
			  //driver.findElement(By.xpath(prop.getProperty("submit"))).click();
	}
	

	public void ClickSubmit() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("submit"))).click();
		
	}
}


