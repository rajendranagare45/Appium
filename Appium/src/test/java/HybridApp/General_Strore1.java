package HybridApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class General_Strore1 extends General_Strore{
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void Before() throws MalformedURLException {
		driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(enabled = false)
	public void General() {
		System.out.println("Welcome To General Store");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))");
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Austria\")")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rajendra");
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String text = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$160.97\")")).getText();
		System.out.println("Air Jordan 4 Retro: "+text);
		String text1 = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$120.0\")")).getText();
		System.out.println("Air Jordan 1 Mid SE: "+text1);
		String text2 = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$ 280.97\")")).getText();
		System.out.println("Total Purchase Amount: "+text2);
		
		String prod=text.substring(1);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		System.out.println(prod);
		String prod1=text1.substring(1);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		System.out.println(prod1);
		String prod2=text2.substring(1);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		System.out.println(prod2);
		
		Double first = Double.parseDouble(prod);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		Double	second=Double.parseDouble(prod1);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		Double	total=Double.parseDouble(prod2);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Double finalPrice = first+ second;
		System.out.println(first);
		System.out.println(second);
		System.out.println(total);
		
		if (total.equals(finalPrice)) {
			System.out.println("Prices are Matching");
		} else {
			System.out.println("Prices are not Matching");
		}
		
	}
	@Test(enabled = true)
	public void New() {
		System.out.println("Welcome To General Store");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))");
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Austria\")")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rajendra");
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(1).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String text = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$55.0\")")).getText();
		
		String prod=text.substring(1);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Double first = Double.parseDouble(prod);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println(first);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Visit to the website to complete purchase\")")).click();

	}
}
