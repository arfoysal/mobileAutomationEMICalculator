package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.PageDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Utilities;

public class P1_HomePage extends Utilities {

	public P1_HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(PageDriver.getCurrentDriver()), this);
	}

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/btnStart")
	public WebElement emiCalulatorBtnElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/btnCompare")
	public WebElement compareLoansBtnElement;

	public void clckEMICalculatorBtn() throws InterruptedException {
		System.out.println("Now Clicking EMI Calculator Button");
		emiCalulatorBtnElement.click();
		Thread.sleep(3000);

	}

	public void clckCompareLoanseBtn() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Now Clicking Compare Loans Button");
		compareLoansBtnElement.click();
		Thread.sleep(2000);
	}

}
