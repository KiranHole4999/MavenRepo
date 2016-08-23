package Pages;
import Utility.Screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FacebookScreenshot {
	// Create Webdriver reference
	WebDriver driver;
	 
	@Test
	public void captureScreenshot() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Clarion\\src\\test\\resources\\BrowserDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("http://www.gmail.com");
	 
	   // Here we are forcefully passing wrong id so that it will fail our testcase
	   driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Learn Automation");
	}
	 
	 // It will execute after every test execution
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus())
		{
			try
			{  // Call Utility class method
				Screenshot.captureScreenshot(driver,"gmail");
			}
			
			catch (Exception e)
			{
	 
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
	 
		}
				// close application
		driver.quit();
	}
}
