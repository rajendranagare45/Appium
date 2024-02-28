package NativeApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Gmail1 extends Gmail {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void Before() throws MalformedURLException {
		driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void login() throws InterruptedException  {
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"GOT IT\")")).click();
	
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Add an email address\")")).click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Google\")")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("rajendranagare04@gmail.com");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Next\")")).click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys("Raj@0983");
//	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Next\")")).click();
//	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Yes, I’m in\"))");
//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Yes, I’m in\")")).click();
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     // driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Don’t turn on\")")).click();
      //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	Thread.sleep(2000);
	  	
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.activateApp("io.appium.android.apis");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AccessibilityId("Preference")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AccessibilityId("5. Preferences from code")).click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"List preference\")")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Alpha Option 01\")")).click();
        Thread.sleep(2000);
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.activateApp("com.google.android.gm");
	}
}
