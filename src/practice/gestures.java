package practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;
public class gestures {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		File F = new File("src");
		File FS = new File(F, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SalahEmu");
		cap.setCapability(MobileCapabilityType.APP, FS.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);

		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		TouchAction t =new TouchAction(driver);
		WebElement expandList=	driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		t.tap(tapOptions().withElement(element(expandList))).perform();

		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		WebElement peopleList =	driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		t.longPress(longPressOptions().withElement(element(peopleList)).withDuration(ofSeconds(2))).release().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElementById("android:id/title").isDisplayed());


	}

}
