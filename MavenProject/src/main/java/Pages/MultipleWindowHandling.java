package Pages;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class MultipleWindowHandling {
	static WebDriver driver;

	@Test
	public void test_CloseAllWindowsExceptMainWindow() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Workspace\\Clarion\\src\\test\\resources\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// It will open Naukri website with multiple windows
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		Reporter.log("Step 1: Redirecting to URL : http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		// To get the main window handle
		String windowTitle= getCurrentWindowTitle();
		Reporter.log("Step 2: Take Window title before closing other windows");
		driver.findElement(By.cssSelector("#button1")).click();
		String WindowBeforeClosing = getMainWindowHandle(driver);
		Thread.sleep(5000);
		Assert.assertTrue(closeAllOtherWindows(WindowBeforeClosing));		
		Reporter.log("step 3: All Windows closed");
		String windowTitle2 = getCurrentWindowTitle();
		Reporter.log("Step 4: Take Window title After closing other windows");
		//Thread.sleep(15000);
		System.out.println(windowTitle);
		Reporter.log("Step 5: Verifying title of window after closing all windows");
		Assert.assertTrue(windowTitle.contains("TOOLSQA | Demo Windows for practicing"));
		
		if(windowTitle2.equalsIgnoreCase(windowTitle))
		{
			System.out.println("Titles verified----> Success!!! Titles are matching"+ "\n" +"Title before Closing Windows: "+"windowTitle"+"\n" +"Title After Closing Windows:" +windowTitle2);
			Reporter.log("Titles verified----> Success!!! Titles are matching" + "\n" + "Title before Closing Windows: "+"windowTitle"+ "\n" +"Title After Closing Windows:" +windowTitle2);
		}
		else
		{
			System.out.println("Titles verified----> Fail!!! Titles are Not matching \n Title before Closing Windows: "+windowTitle+"\n Title After Closing Windows:" +windowTitle2);
			Reporter.log("Titles verified----> Fail!!!Titles are Not matching \n Title before Closing Windows: "+windowTitle+"\n Title After Closing Windows:" +windowTitle2);
		}
	}
		
	public String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	//To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				System.out.println("Window closed : "+ currentWindowHandle);
				driver.close();
			}
		}
		
		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
}
