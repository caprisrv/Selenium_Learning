package SeleniumAutomation.Selenium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GreenKart {

	public static void main(String args[]) throws InterruptedException {

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

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		addItems(driver, itemsNeeded);
		
		//click on Cart image
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		String promoInfo = driver.findElement(By.cssSelector(".promoInfo")).getText();
		Assert.assertEquals(promoInfo,"Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement chooseCountry = driver.findElement(By.cssSelector("select[style='width: 200px;']"));
		Select dd = new Select(chooseCountry);
		dd.selectByVisibleText("India");
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();

		// driver.quit();

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		List<WebElement> vegCounts = driver.findElements(By.xpath("//h4[@class='product-name']"));
		List<WebElement> addToCarts = driver.findElements(By.xpath("//h4[@class='product-name']/following-sibling::p/following-sibling::div/following-sibling::div/button"));

		int j = 0;
		for (int i = 0; i < vegCounts.size(); i++) {
			List<String> al = Arrays.asList(itemsNeeded);
			String[] name = vegCounts.get(i).getText().split(" ");
			// String[] substrName=name.split(" ");
			System.out.println(name[0].trim());
			if (al.contains(name[0].trim())) {
				j++;
				addToCarts.get(i).click();

				if (j == itemsNeeded.length)
					break;
			}
		}
	}

}
