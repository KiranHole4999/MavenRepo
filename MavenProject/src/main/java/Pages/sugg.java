package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class sugg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver = new FirefoxDriver();
driver.get("http://www.makemytrip.com/flights-hotels");

WebElement from =driver.findElement(By.cssSelector("#flightDeparture_1"));
from.sendKeys("Pune");


Thread.sleep(3000);

driver.findElement(By.cssSelector(".widget.append_bottom10")).click();

WebElement dest =driver.findElement(By.cssSelector("#flightDestination_1"));
dest.sendKeys("Mumbai");
Thread.sleep(3000);
driver.findElement(By.cssSelector(".widget.append_bottom10")).click();


Thread.sleep(3000);
driver.findElement(By.cssSelector(".btn.btn-lg.btn-block.btn-primary-red")).click();
	}

}
