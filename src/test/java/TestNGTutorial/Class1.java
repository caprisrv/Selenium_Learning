package TestNGTutorial;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class1 {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Execute before every method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Execute after every method");
	}
	
	@Parameters({"url"})
	@Test(groups= {"smoke"})
	public void webLoginPersonalLoan(String urlName) {
		System.out.println("Web login personal loan");
		System.out.println("URL Name is "+urlName);
	}
	
	@Test
	public void mobileLoginPersonalLoan() {
		System.out.println("Mobile login personal loan");
	}
	
	@AfterTest
	public void executeFirst() {
		System.out.println("I will execute at the end");
	}

}
