package SeleniumAutomation.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class FilterWebTable {

	public static void main(String[] args) {

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

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");

		List<WebElement> vegFruitNames1 = driver.findElements(
				By.xpath("//table[@class='table table-bordered']/thead/following-sibling::tbody/tr/td[1]"));

		List<WebElement> listString = vegFruitNames1.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());
		//listString.forEach(s->s.contains("ri"));

		Assert.assertEquals(vegFruitNames1.size(), listString.size());


	}

}
