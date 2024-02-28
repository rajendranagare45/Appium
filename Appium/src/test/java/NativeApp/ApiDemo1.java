package NativeApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;

public class ApiDemo1 extends ApiDemos{
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void Before() throws MalformedURLException {
		driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(enabled = false)
	public void ts() {
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath("*//[@text='WiFi Settings']")).click();
		// another way of using text which you can follow easily is use the android UIAutomator to identify
		// an element it mean if this text is not working then you can use the android UIAutomator and you have
		// to use "UISelector" method for selecting the element.
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("rajendra");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	
	}
	@Test(enabled = false)
	public void notifi() {
		driver.openNotifications();
		driver.findElements(By.className("android.widget.ImageView")).get(3).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	@Test(enabled = false)
	public void view() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("WebView")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		
	} 
	
	// Gesture tap and touch 
	
	@Test(enabled = false)
	public void Gesture() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		TouchAction ta=new TouchAction(driver);
		AndroidElement fishname = driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
		ta.longPress(longPressOptions().withElement(element(fishname)).withDuration(ofSeconds(5))).release().perform();
			
	}
	@Test(enabled = false)
	public void Dragdrop() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		
		AndroidElement Element1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement Element2 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(Element1)).withDuration(ofSeconds(3))).moveTo(element(Element2)).release().perform();

	}
	
	@Test(enabled = false)
	public void SwitchTo() {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_enable_receiver")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("rajendra");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("io.appium.android.apis:id/sms_send_message")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.activateApp("com.google.android.apps.messaging");
		
		String text = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		
		System.out.println(text);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		
		

		
	}
	@Test(enabled = true)
	public void Clock() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		
		
		AndroidElement time1 = driver.findElement(MobileBy.AccessibilityId("12"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement time2 = driver.findElement(MobileBy.AccessibilityId("5"));		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		TouchAction clock = new TouchAction(driver);
		clock.longPress(longPressOptions().withElement(element(time1)).withDuration(ofSeconds(3))).moveTo(element(time2)).release().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		AndroidElement min1 = driver.findElement(MobileBy.AccessibilityId("0"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement min2 = driver.findElement(MobileBy.AccessibilityId("30"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		TouchAction time = new TouchAction(driver);
		time.longPress(longPressOptions().withElement(element(min1)).withDuration(ofSeconds(3))).moveTo(element(min2)).release().perform();

	}

}
