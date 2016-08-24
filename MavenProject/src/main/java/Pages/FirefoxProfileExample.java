package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class FirefoxProfileExample {
	WebDriver driver;

	@Test
	public void testExamples(){
	/*FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("browser.startup.homepage","http://www.google.com");
	driver = new FirefoxDriver(profile);
	WebElement element = driver.findElement(By.name("btnK"));
	element.click();*/
		ProfilesIni profile = new ProfilesIni();
FirefoxProfile myprofile = profile.getProfile("KiranProfile");
//myprofile.setPreference("browser.startup.homepage","http://www.google.com");
WebDriver driver = new FirefoxDriver(myprofile);
driver.navigate().to("https://www.google.co.in");


}
}