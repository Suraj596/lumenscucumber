package LumensStepDefintion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

import LumensDataFactory.LumensDataFactory;
import LumensDataProvider.LumensConfigReader;
import LumensPages.LumensAddandView;
import LumensPages.LumensCouponCode;
import LumensPages.LumensCreateAccount;
import LumensPages.LumensLivechat;
import LumensPages.LumensLivechatInvalid;
import LumensPages.LumensTabandFilter;
import LumensPages.LumensZipCode;
import LumensPages.LumensLoginAccount;
import LumensPages.LumensLogout;
import LumensPages.LumensNavigateBack;
import LumensPages.LumensProductandFilter;
import LumensPages.LumensQuantity;
import LumensPages.LumensRemoveCart;
import LumensPages.LumensScrollupdown;
import LumensPages.LumensSearch;
import LumensUtils.LumensExcelReader;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class LumensStepsTest {
	
	static WebDriver driver;
	
	LumensConfigReader configfile;
	Properties prop;
	LumensDataFactory DriverFactory;
	
    
    
	@Before(order = 0)
    public void getProperty() {
		configfile = new LumensConfigReader();
        prop = configfile.init_prop();
    }

 

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        DriverFactory = new LumensDataFactory();
        driver = DriverFactory.init_driver(browserName);
    
        
    }
    public static void popup() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,60);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ltkpopup-close-button']")));
       
        driver.findElement(By.xpath("//*[@id='ltkpopup-close-button']")).click();
        Thread.sleep(5000);
	}
   
    
	@Given("^user should open link$")
	public void user_should_open_link() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        
       
        driver.get(prop.getProperty("url"));
        popup();
        
	}
	
	
	@Then("^click on accountand enter credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void click_on_accountand_enter_credentials_and(String SheetName, int RowNumber) throws Throwable {
		driver.findElement(By.xpath(prop.getProperty("account"))).click();
		driver.findElement(By.xpath(prop.getProperty("myaccount"))).click();
		LumensExcelReader reader=new LumensExcelReader();
		LumensCreateAccount create=new LumensCreateAccount(driver);
		List<Map<String,String>> testData =reader.getData("C:\\Users\\hp\\eclipse-workspace\\LumensCucumber2\\ExcelTestdata\\Lumenslogin.xlsx", SheetName);
		String firstname =testData.get(RowNumber).get("firstname");
		String lastname =testData.get(RowNumber).get("lastname");
		String email =testData.get(RowNumber).get("email");
		String confirmemail =testData.get(RowNumber).get("confirmemail");
		String password =testData.get(RowNumber).get("password");
		String confirmpassword =testData.get(RowNumber).get("confirmpassword");
		
		
		create.fillCreateaccountForm(firstname, lastname, email, confirmemail, password, confirmpassword);
	}

	@And("^click on submit$")
	public void click_on_submit() throws Throwable {
	   LumensCreateAccount click=new LumensCreateAccount(driver);
	   click.ClickSubmit();
	}

	@Given("^User should nagivate to url$")
	public void user_should_nagivate_to_url() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        
       
       driver.get(prop.getProperty("url"));
       popup();
       
	}
	
	 
	 

	@Then("^User able to give credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_able_to_give_credentials_and(String SheetName, int RowNumber) throws Throwable {
		driver.findElement(By.xpath(prop.getProperty("account"))).click();
		driver.findElement(By.xpath(prop.getProperty("myaccount"))).click();
		LumensExcelReader reader=new LumensExcelReader();
		LumensLoginAccount login=new LumensLoginAccount(driver);
		List<Map<String,String>> testData =reader.getData("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\LumensCucumber2\\\\ExcelTestdata\\\\Lumenslogin.xlsx", SheetName);
		String email =testData.get(RowNumber).get("email");
		String password =testData.get(RowNumber).get("password");
		
		login.Enterlogindetails(email, password);
	    
	}

	@Then("^Click on login button$")
	public void click_on_login_button() throws Throwable {
		LumensLoginAccount loginbutton=new LumensLoginAccount(driver);
		loginbutton.ClickLogin();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     File dest = new File("screenshots/"+"verifytitle.screenshot"+ ".png");
     FileUtils.copyFile(scr, dest);
	}
		
	
	@Then("^Click on ceiling lights and select large chandeliers$")
	public void click_on_ceiling_lights_and_select_large_chandeliers() throws Throwable {
		
		LumensTabandFilter tab=new LumensTabandFilter(driver);
		tab.ceiling();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"largechandeliers.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}
	

	@Then("^Select the product by applying filter$")
	public void select_the_product_by_applying_filter() throws Throwable {
		LumensProductandFilter product=new LumensProductandFilter(driver);
		product.filter();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"filter.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}
	
	@Then("^Able to add the product and view the added product in cart$")
	public void able_to_add_the_product_and_view_the_added_product_in_cart() throws Throwable {
		LumensAddandView add=new LumensAddandView(driver);
		add.addview();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"addview.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}

	@Then("^Able to search the product \"([^\"]*)\" and \"([^\"]*)\"$")
	public void able_to_search_the_product_and(String SheetName, int RowNumber) throws Throwable {
		
		LumensExcelReader reader=new LumensExcelReader();
		LumensSearch search=new LumensSearch(driver);
		List<Map<String,String>> testData =reader.getData("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\LumensCucumber2\\\\ExcelTestdata\\\\Lumenslogin.xlsx", SheetName);
		String searchbar =testData.get(RowNumber).get("search");
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		
		search.searchproduct(searchbar);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"search.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}
	
	@Then("^User able to select livechat and give credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_able_to_select_livechat_and_give_credentials_and(String SheetName, int RowNumber) throws Throwable {
		driver.findElement(By.xpath(prop.getProperty("account"))).click();
		driver.findElement(By.xpath(prop.getProperty("myaccount"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LumensExcelReader reader=new LumensExcelReader();
		LumensLivechat live=new LumensLivechat(driver);
		List<Map<String,String>> testData =reader.getData("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\LumensCucumber2\\\\ExcelTestdata\\\\Lumenslogin.xlsx", SheetName);
		String name =testData.get(RowNumber).get("firstname");
		String emadd =testData.get(RowNumber).get("email");
		
		live.livechat(name, emadd);
	}
	
	@Then("^Click on submit button$")
	public void click_on_submit_button() throws Throwable {
		LumensLivechat submitbutton=new LumensLivechat(driver);
		submitbutton.ClickSubmit();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     File dest = new File("screenshots/"+"livechat.screenshot"+ ".png");
     FileUtils.copyFile(scr, dest);
	}
	
	@Then("^User able to select livechat and give invalid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_able_to_select_livechat_and_give_invalid_credentials_and(String SheetName, int RowNumber) throws Throwable {
		driver.findElement(By.xpath(prop.getProperty("account"))).click();
		driver.findElement(By.xpath(prop.getProperty("myaccount"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LumensExcelReader reader=new LumensExcelReader();
		LumensLivechatInvalid liveinvalid=new LumensLivechatInvalid(driver);
		List<Map<String,String>> testData =reader.getData("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\LumensCucumber2\\\\ExcelTestdata\\\\Lumenslogin.xlsx", SheetName);
		String name =testData.get(RowNumber).get("firstname");
		String emadd =testData.get(RowNumber).get("email");
		
		liveinvalid.livechatinvalid(name, emadd);
	}

	@Then("^Click on submit button invalid$")
	public void click_on_submit_button_invalid() throws Throwable {
		LumensLivechatInvalid submitbutton=new LumensLivechatInvalid(driver);
		submitbutton.ClickSubmit();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     File dest = new File("screenshots/"+"livechatinvalid.screenshot"+ ".png");
     FileUtils.copyFile(scr, dest);
	}
	
		
	@Then("^Able to remove product from cart$")
	public void able_to_remove_product_from_cart() throws Throwable {
		LumensRemoveCart remove=new LumensRemoveCart(driver);
		remove.removeproduct();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"remove.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}
	
	@Then("^Able to apply couponcode \"([^\"]*)\" and \"([^\"]*)\"$")
	public void able_to_apply_couponcode_and(String SheetName, int RowNumber) throws Throwable {
		LumensExcelReader reader=new LumensExcelReader();
		LumensCouponCode apply=new LumensCouponCode(driver);
		List<Map<String,String>> testData =reader.getData("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\LumensCucumber2\\\\ExcelTestdata\\\\Lumenslogin.xlsx", SheetName);
		String coupon =testData.get(RowNumber).get("Coupon");
		
		
		apply.couponcodeapply(coupon);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"coupon.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	     
	}
	
	@Then("^Able to scroll updown the page$")
	public void able_to_scroll_updown_the_page() throws Throwable {
		LumensScrollupdown scrolling=new LumensScrollupdown(driver);
		scrolling.scroll();
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"scroll.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}
	
	@Then("^Able to navigate back to home page$")
	public void able_to_navigate_back_to_home_page() throws Throwable {
		LumensNavigateBack navigate=new LumensNavigateBack(driver);
		navigate.navigateback();
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"navigate.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}
	
	@Then("^Able to logout$")
	public void able_to_logout() throws Throwable {
		LumensLogout logout=new LumensLogout(driver);
		logout.logoutaccount();
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"logout.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}
	
	@Then("^Able to increase the quantity \"([^\"]*)\" and \"([^\"]*)\"$")
	public void able_to_increase_the_quantity_and(String SheetName, int RowNumber) throws Throwable {
		LumensExcelReader reader=new LumensExcelReader();
		LumensQuantity quantityplus=new LumensQuantity(driver);
		List<Map<String,String>> testData =reader.getData("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\LumensCucumber2\\\\ExcelTestdata\\\\Lumenslogin.xlsx", SheetName);
		String quantity =testData.get(RowNumber).get("quant");
		
		
		quantityplus.quantityincrease(quantity);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshots/"+"quantity.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
	}
	


		@Then("^Able to apply zipcode \"([^\"]*)\" and \"([^\"]*)\"$")
		public void able_to_apply_zipcode_and(String SheetName, int RowNumber) throws Throwable {
			LumensExcelReader reader=new LumensExcelReader();
			LumensZipCode zipcode=new LumensZipCode(driver);
			List<Map<String,String>> testData =reader.getData("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\LumensCucumber2\\\\ExcelTestdata\\\\Lumenslogin.xlsx", SheetName);
			String zip =testData.get(RowNumber).get("Zipcode");
			
			
			zipcode.zipcodeapply(zip);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     File dest = new File("screenshots/"+"zipcode.screenshot"+ ".png");
		     FileUtils.copyFile(scr, dest);
		}
	
	
	


@After(order = 0)
public void quitBrowser() {
	driver.quit();
}

@After(order = 1)
public void embedScreenshot(Scenario scenario) throws Exception {
    if (scenario.isFailed()) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String testName = scenario.getName();
            scenario.embed(screenshot, "image/png");
            scenario.write(testName);
        } catch (WebDriverException wde) {
           System.err.println(wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();}
        }
    }
}


   

	
	




	
