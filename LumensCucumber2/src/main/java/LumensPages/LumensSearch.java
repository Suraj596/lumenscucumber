package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;

import org.openqa.selenium.By;

public class LumensSearch {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensSearch(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void Search(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
	}
	
	public void searchproduct(String search) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       
			  driver.findElement(By.xpath(prop.getProperty("searchbar"))).sendKeys(search);
			  driver.findElement(By.xpath(prop.getProperty("Search"))).click();
			 
	}

	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}


	


	


	
}


