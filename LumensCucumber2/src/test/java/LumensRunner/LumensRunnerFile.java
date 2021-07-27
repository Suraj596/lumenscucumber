package LumensRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.junit.runner.RunWith;

 
@RunWith(Cucumber.class)
@CucumberOptions(
       
		features="src/test/resources/LumensFeature",
		
		
		glue = {"LumensStepDefintion"} ,		
                	
              plugin = { "pretty","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html","html:test-output"},
              //tags = {"@createaccount, @loginandtitle, @tabandfilter, @addandview, @search, @livechatvalid, @livechatinvalid, @removecart, @couponcode, @scrollupdown, @navigateback, @zipcode, @quantity, @logout"},
              tags= {"@createaccount, @loginandtitle, @tabandfilter, @logout"},
              
             monochrome=true,
                dryRun=false
                    )


public class LumensRunnerFile extends AbstractTestNGCucumberTests {

}
