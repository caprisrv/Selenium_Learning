package SeleniumAutomation.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicScript {
	
	public static void main(String args[]) throws InterruptedException {
		
		String browser="chrome";
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		/*
		 * driver.get("https://www.facebook.com/");
		 * driver.findElement(By.id("email")).sendKeys("email123");
		 * driver.findElement(By.name("pass")).sendKeys("Pass123");
		 * driver.findElement(By.linkText("पासवर्ड भूल गए?"));
		 */
		
		/*
		 * driver.get("https://login.salesforce.com/");
		 * //driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Test123");
		 * driver.findElement(By.cssSelector("input#username")).sendKeys("Test123");//
		 * tagname#id
		 * driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Test123");
		 * //driver.findElement(By.xpath("//*[@type='submit']")).click();
		 * driver.findElement(By.cssSelector("input[type='submit']")).click();//tagname[
		 * attribute=value]
		 * 
		 * Thread.sleep(5000); //String errorText =
		 * driver.findElement(By.xpath("//*[@id='error']")).getText(); //String
		 * errorText = driver.findElement(By.cssSelector("div#error")).getText(); String
		 * errorText =
		 * driver.findElement(By.cssSelector("div#error.loginError")).getText();//
		 * tagname#id.classname System.out.println(errorText);
		 */
		
		//tagname[contains(@attribute,'value')] - Xpath regular expression
		
		
		//label[@class='sr-only']/parent::div
		//label[@class='sr-only']/following-sibling::input
		//*[text()='Selenium']
		
		
		  driver.get("https://www.rediff.com/");
		  driver.findElement(By.cssSelector("a[title*='Sign in']")).click();//tagname[Attribute*='value'] = css selector regular expression Thread.sleep(5000);
		  driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("test123");
		  driver.findElement(By.cssSelector("input#password")).sendKeys("test");
		  System.out.println(driver.findElement(By.xpath("//input[contains(@title,'Sign in')]")).getAttribute("value"));
		  driver.findElement(By.xpath("//input[contains(@title,'Sign in')]")).click();
		 
		
		
		driver.quit();

		
	}

}
