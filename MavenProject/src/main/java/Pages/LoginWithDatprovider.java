package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDatprovider {

	WebDriver driver;
	
/*	@FindBy(xpath = ".//*[@name='txtLogin']")
	WebElement username;*/
	
	@BeforeTest
	public void Setup() 
	{
	  System.setProperty("webdriver.chrome.driver","D:\\Workspace\\Clarion\\src\\test\\resources\\BrowserDrivers\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://182.74.123.180/clarion_projects/index.php?fuse=home");
	}
	
	@Test(dataProvider="GetLoginData")
	public void LoginVerify(String uname, String pass) throws InterruptedException
	{
		WebElement username=driver.findElement(By.xpath(".//*[@name='txtLogin']"));
		WebElement password= driver.findElement(By.xpath(".//*[@name='txtPassword']"));
		
		WebElement submit = driver.findElement(By.xpath(".//*[@name='butLogin']"));
		
		String Welcometxt = driver.findElement(By.xpath("//*[@class='user' and contains(text(),'Welcome')]")).getText();
		WebElement logout= driver.findElement(By.cssSelector(".logout>a>img"));
	   
		username.sendKeys(uname);
		password.sendKeys(pass);
		submit.click();
		Thread.sleep(5000);
	
		 if (Welcometxt.contains("Welcome"))
		    {
		    	System.out.println("User logged in successfully");
		    	logout.click();
		    	Thread.sleep(5000);
		    }
		    else
		    {
		    	System.out.println("Unsuccessful Login");
		    }
		 
	}
	
	
	@DataProvider(name="GetLoginData")
	public Object[][] TestDataFeed()
	{
		Object LoginTestData[][] = new Object[3][2];
		
		LoginTestData[0][0]="kiran.hole@clariontechnologies.co.in";
		LoginTestData[0][1]="clarion";
		
		LoginTestData[1][0]	="sanjeetk@clariontechnologies.co.in"	;
		LoginTestData[1][1]="clarion";
		
		LoginTestData[2][0]	="aditi.sonone@clariontechnologies.co.in"	;
		LoginTestData[2][1]="clarion";
		
		return LoginTestData;
	}
}
