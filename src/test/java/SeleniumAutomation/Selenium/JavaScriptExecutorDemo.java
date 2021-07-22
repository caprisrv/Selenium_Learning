package SeleniumAutomation.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		String browser = "chrome";
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,200)");
		
		List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		
		int sum=0;
		for(int i=0;i<amounts.size();i++) {
			sum = sum + Integer.parseInt(amounts.get(i).getText());
		}
		
		System.out.println(sum);
		String sumString = String.valueOf(sum);
		
		String text = driver.findElement(By.cssSelector(".totalAmount")).getText();
		String textString = text.split(":")[1].trim();
		//String totalAmount = textString[1].trim();
		
		//System.out.println(totalAmount);
		
		Assert.assertEquals(textString, sumString);

		//div[@class='left-align']/fieldset/table/tbody/tr
		//div[@class='left-align']/fieldset/table/tbody/tr[1]/th
		//div[@class='left-align']/fieldset/table/tbody/tr[3]
		//div[@class='left-align']/fieldset/table/tbody/tr[3]/td
	}

}
