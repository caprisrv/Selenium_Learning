package SeleniumAutomation.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTripAssignment {

	public static void main(String[] args) throws InterruptedException {
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
		
		driver.get("https://www.cleartrip.com/");
		
		WebElement adultsDropdown = driver.findElement(By.xpath("//div[@class='col flex flex-middle']/div[1]/select"));
		WebElement childDropdown = driver.findElement(By.xpath("//div[@class='col flex flex-middle']/div[3]/select"));
		
		Select ad = new Select(adultsDropdown);
		ad.selectByVisibleText("2");
		
		Select cd = new Select(childDropdown);
		cd.selectByVisibleText("1");
		
		driver.findElement(By.xpath("//strong[@class='pr-1']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("indigo");
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[2]/button[1]")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='col-24']/div/span")).getText());
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
