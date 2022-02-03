package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.Base;
import pageObjects.P2_EMI_CalculatorPage;
import utilities.DataSet;

public class TC_02_EMICalculatorTest extends Base {

	@Test(dataProvider = "data", dataProviderClass = DataSet.class)
	public void emiCalculate(long loan, double interest, int periodYears, double pFee, long mEMI, long tInterest,
			long tpFee, long tPayment) throws InterruptedException {
		P2_EMI_CalculatorPage calculatorPage = new P2_EMI_CalculatorPage();

		calculatorPage.calculateEMI(loan, interest, periodYears, pFee);
		long[] actualValues = calculatorPage.getActualResults();
		assertEquals(actualValues[0], mEMI);
		assertEquals(actualValues[1], tInterest);
		assertEquals(actualValues[2], tpFee);
		assertEquals(actualValues[3], tPayment);
		calculatorPage.clickOnReset();
	}

}
