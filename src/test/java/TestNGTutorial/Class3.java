package TestNGTutorial;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class3 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@Parameters({"url"})
	@Test(timeOut=4000)
	public void webLoginCarLoan(String urlName) {
		System.out.println("Web Login Car Loan");
		System.out.println("URL Name is "+urlName);
	}
	
	@Test(groups= {"smoke"},dataProvider="getData")
	public void mobileLoginCarLoan(String uName, String pWd) {
		System.out.println("Mobile Login Car Loan");
		System.out.println("User name is "+uName);
		System.out.println("Password is "+pWd);
	}
	
	@Test
	public void apiLoginCarLoan() {
		System.out.println("API Login Car Loan");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data= new Object[3][2];
		
		//1st set
		data[0][0]="firstusername";
		data[0][1]="firstpassword";
		
		//2nd set
		data[1][0]="secondusername";
		data[1][1]="secondpassword";
				
		//3rd set
		data[2][0]="thirdusername";
		data[2][1]="thirdpassword";
		
		return data;
	}

}
