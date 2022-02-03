package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.PageDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Utilities;

public class P2_EMI_CalculatorPage extends Utilities {

	public P2_EMI_CalculatorPage() {
		PageFactory.initElements(new AppiumFieldDecorator(PageDriver.getCurrentDriver()), this);
	}

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/rbEMI")
	public WebElement emiRadioBtnElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/etLoanAmount")
	public WebElement amountElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/etInterest")
	public WebElement interestElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/etYears")
	public WebElement yearsElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/etMonths")
	public WebElement monthsElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/etFee")
	public WebElement processingFeePercentageElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/btnCalculate")
	public WebElement calcutateBtnElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/btnReset")
	public WebElement resetBtnElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/btnDetail")
	public WebElement detailBtnElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/monthly_emi_result")
	public WebElement monthlyEMIElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/total_interest_result")
	public WebElement totalInterestElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/processing_fee_result")
	public WebElement totalProcessingFeeElement;

	@AndroidFindBy(id = "com.continuum.emi.calculator:id/total_payment_result")
	public WebElement totalPaymentElement;

	public void calculateEMI(long amount, double interestRate, int years, double processongFee)
			throws InterruptedException {
		emiRadioBtnElement.click();
		amountElement.sendKeys(Long.toString(amount));
		interestElement.sendKeys(Double.toString(interestRate));
		yearsElement.sendKeys(Integer.toString(years));
		processingFeePercentageElement.sendKeys(Double.toString(processongFee));
		calcutateBtnElement.click();
		Thread.sleep(3000);
	}

	public long[] getActualResults() throws InterruptedException {
		long monthlyEMIValue = texttoRoundInteger(monthlyEMIElement.getText());
		long totalInterestValue = texttoRoundInteger(totalInterestElement.getText());
		long processingFeeValue = texttoRoundInteger(totalProcessingFeeElement.getText());
		long totalPaymentValue = texttoRoundInteger(totalPaymentElement.getText());
		long[] actualValue = { monthlyEMIValue, totalInterestValue, processingFeeValue, totalPaymentValue };
		Thread.sleep(3000);
		return actualValue;
	}

	public void clickOnReset() throws InterruptedException {
		resetBtnElement.click();
		Thread.sleep(3000);

	}

	public void clickOnDetails() throws InterruptedException {
		detailBtnElement.click();
		Thread.sleep(3000);

	}

}
