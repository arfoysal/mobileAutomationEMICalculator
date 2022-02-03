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
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.continuum.emi.calculator");
		cap.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");

		// Running Server in the mentioned port
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageDriver.getInstance().setDriver(driver);
	}

	@AfterTest
	public void tearDown() {
		PageDriver.getCurrentDriver().quit();
	}

}
