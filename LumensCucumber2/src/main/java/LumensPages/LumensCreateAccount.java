package LumensPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LumensCreateAccount {
	
   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensCreateAccount(WebDriver driver) {
		this.driver=driver;
	}
	
	
			
	public void fillCreateaccountForm(String firstname, String lastname,String email, String confirmemail, String password, String confirmpassword
) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("firstname"))).sendKeys(firstname);
		  driver.findElement(By.xpath(prop.getProperty("lastname"))).sendKeys(lastname);
		  driver.findElement(By.xpath(prop.getProperty("emailadd"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("confirmemailadd"))).sendKeys(confirmemail);
		  driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(password);
		  driver.findElement(By.xpath(prop.getProperty("confirmpass"))).sendKeys(confirmpassword);
	}
	

	public void ClickSubmit() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		//driver.findElement(By.xpath(prop.getProperty("No_Radiobutton_xpath"))).click();
	       driver.findElement(By.xpath(prop.getProperty("ClickCreateaccountbutton"))).click();
	}
}



