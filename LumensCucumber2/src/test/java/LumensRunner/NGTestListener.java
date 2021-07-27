package LumensRunner;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;



public class NGTestListener implements ITestListener {
	
	

    @Override		
    public void onStart(ITestContext Result)					
    {		
    	 System.out.println("On test Start"); 		
    }		
    
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("on test success");					
    }		
    
    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    	 System.out.println("On test percentage"); 	
    }		
		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("on Test Failure");					
    }		

    	
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("on Test Skipped");					
    }		

    	
    @Override		
    public void onTestStart(ITestResult Result)					
    {		
    System.out.println("on start");					
    }		

    // When Test case get passed, this method is called.		
   
    
  @Override		
    public void onFinish(ITestContext Result) 					
    {		
	  System.out.println("on Finsh");	    		
    }		
  
  @Test
  public void takeScreenshotTest()
  {
	  Assert.assertEquals(false,true);

}	
}