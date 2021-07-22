package SeleniumAutomation.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassDemo {

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

		driver.get("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement signIn = driver.findElement(By.cssSelector("#nav-link-accountList"));
		WebElement textBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		Actions a = new Actions(driver);
		
		a.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		a.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(signIn).build().perform();
		a.moveToElement(signIn).contextClick().build().perform();
		
		

	}

}
