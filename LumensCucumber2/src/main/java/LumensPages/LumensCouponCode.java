package LumensPages;
import org.openqa.selenium.WebDriver;

import LumensDataProvider.LumensConfigReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class LumensCouponCode {

   WebDriver driver;
   Properties prop;
   LumensConfigReader configfile;
   
  

	public LumensCouponCode(WebDriver driver) {
		this.driver=driver;
	}
	 
			
	public void coupon(String email, String password) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	   
		  driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
		  driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		  
	}
	public void couponcodeapply(String Coupon) {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
	       
			  driver.findElement(By.xpath(prop.getProperty("cart"))).click();
			  driver.findElement(By.xpath(prop.getProperty("coupon"))).sendKeys(Coupon);
			  
			  driver.findElement(By.xpath(prop.getProperty("apply"))).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 
	}

	public void ClickLogin() {
		configfile = new LumensConfigReader();
	       prop = configfile.init_prop();
		
		driver.findElement(By.xpath(prop.getProperty("clickLoginButton"))).click();
		
	}
}


