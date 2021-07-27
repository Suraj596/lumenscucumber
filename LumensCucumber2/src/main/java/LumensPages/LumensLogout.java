package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;

import org.openqa.selenium.By;

public class LumensLogout {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensLogout(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void Logout(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
	}
	public void logoutaccount() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
	       driver.findElement(By.xpath(prop.getProperty("account"))).click();
	       
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
	}

	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}


