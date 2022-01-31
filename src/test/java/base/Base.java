package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Base {

	public static AndroidDriver<AndroidElement> driver;
	public static DesiredCapabilities cap;

	@BeforeTest
	public void android_Setup() throws MalformedURLException {
		// Letting which application to run
		// File f = new File("src");
		// File fs = new File(f, "ApiDemos-debug.apk");
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.continuum.emi.calculator");
		cap.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "local");
		// cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		// Running Server in the mentioned port
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageDriver.getInstance().setDriver(driver);
	}

	/*
	 * public static AndroidDriver<AndroidElement> capabilities() throws
	 * MalformedURLException { // Letting which application to run File f = new
	 * File("src"); File fs = new File(f, "ApiDemos-debug.apk");
	 * 
	 * // Openning Emulator DesiredCapabilities cap = new DesiredCapabilities();
	 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, "local");
	 * cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	 * 
	 * // Running Server in the mentioned port AndroidDriver<AndroidElement> driver
	 * = new AndroidDriver<AndroidElement>( new URL("http://127.0.0.1:4723/wd/hub"),
	 * cap);
	 * 
	 * // Adding wait driver.manage().timeouts().implicitlyWait(10,
	 * TimeUnit.SECONDS); return driver;
	 * 
	 * }
	 */
	@AfterTest
	public void tearDown() {
		PageDriver.getCurrentDriver().quit();
	}

}
