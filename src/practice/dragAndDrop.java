package practice;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.MobileCapabilityType;

public class dragAndDrop {

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
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();

		//longpress(source)/move(destination)/release
		TouchAction t =new TouchAction(driver);
		WebElement first=	driver.findElementsByClassName("android.view.View").get(0);
		WebElement second =	driver.findElementsByClassName("android.view.View").get(1);
		t.longPress(longPressOptions().withElement(element(first))).moveTo(element(second)).release().perform();
		//another way for drag and drop because I don't have any other actions like with duration
		t.longPress(element(first)).moveTo(element(second)).release().perform();
	}

}
