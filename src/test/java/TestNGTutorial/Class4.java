package TestNGTutorial;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Class4 {
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@Test(groups= {"smoke"})
	public void webLoginHomeLoan() {
		System.out.println("Web Login Home Loan");
	}
	
	@Test
	public void mobileLoginHomeLoan() {
		System.out.println("Mobile Login Home Loan");
	}
	
	@Test
	public void apiLoginHomeLoan() {
		System.out.println("API Login Home Loan");
	}
}
