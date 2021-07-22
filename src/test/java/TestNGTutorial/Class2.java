package TestNGTutorial;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class2 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class first of class 2");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class first of class 2");
	}
	
	@BeforeTest
	public void executeFirst() {
		System.out.println("I will execute first");
	}
	
	@Test(groups= {"smoke"})
	public void webLoginPersonalLoanMod1() {
		System.out.println("web Login Personal Loan Mod1");
	}
	
	@Test(dependsOnMethods= {"webLoginPersonalLoanMod1"},enabled=false)
	public void mobileLoginPersonalLoanMod1() {
		System.out.println("mobile Login Personal Loan Mod1");
	}


}
