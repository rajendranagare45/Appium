package WebApps;

import java.awt.Desktop.Action;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Masai1 extends Masai {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void Before() throws MalformedURLException {
		driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void login() {
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Appium");
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		 List<AndroidElement> links = driver.findElements(By.tagName("a"));
		 links.size();
		 System.out.println(links.size());
//		 for(int i=0;i<links.size();i++) {
//			 System.out.println(links.get(i).getText());
//			 System.out.println(links.get(i).getAttribute("href"));
//		 }
		 act.sendKeys(Keys.PAGE_DOWN).build().perform();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 act.sendKeys(Keys.PAGE_DOWN).build().perform();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 WebElement element = driver.findElement(By.xpath("//div[@class='v7jaNc ynAwRc MBeuO q8U8x oewGkc LeUQr htnRc']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//	WebElement clickableElement = Wait
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView()", web);

		 
	}
	
}
