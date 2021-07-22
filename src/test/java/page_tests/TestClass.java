package page_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_functions.RediffLoginPage;
import page_functions.RediffLoginPagePF;

public class TestClass {

	@Test
	public void pageTest() {

		String browser = "chrome";
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		RediffLoginPagePF rp = new RediffLoginPagePF(driver);
		
		rp.EmailID().sendKeys("test123");
		rp.Password().sendKeys("pass123");
		rp.GoButton().click();
		
		driver.quit();
	}

}
