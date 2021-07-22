package SeleniumAutomation.Selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
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

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//count of links
		
		List<WebElement> countLinks = driver.findElements(By.tagName("a"));
		System.out.println(countLinks.size());
		
		WebElement footerColumnsLinks = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		System.out.println(footerColumnsLinks.findElements(By.tagName("a")).size());
		
		List<WebElement> links = footerColumnsLinks.findElements(By.tagName("a"));
		
		for(int i=1;i<links.size();i++) {
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).build().perform();
			Thread.sleep(2000);
			links.get(i).click();
			
		}
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		while(it.hasNext()) {
			String arr=it.next();
			Thread.sleep(2000);
			driver.switchTo().window(arr);
			System.out.println(driver.getTitle());
		}
		
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
	}

}
