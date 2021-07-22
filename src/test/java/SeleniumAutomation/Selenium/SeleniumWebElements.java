package SeleniumAutomation.Selenium;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebElements {

	public static void main(String args[]) throws InterruptedException {

		String browser = "chrome";
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\BrowserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\BrowserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// handle static dropdown using Select class WebElement dropdown =
		WebElement dropdown = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
		Select staticDropdown = new Select(dropdown);
		staticDropdown.selectByValue("AED");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		staticDropdown.selectByVisibleText("USD");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		staticDropdown.selectByIndex(1);
		System.out.println(staticDropdown.getFirstSelectedOption().getText());

		// handle passengers dropdown

		String totalAdultBefore = driver.findElement(By.cssSelector("#divpaxinfo")).getText();
		System.out.println(totalAdultBefore);
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		String adultsCount = driver.findElement(By.cssSelector("#spanAudlt")).getText();
		System.out.println(adultsCount);
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		String totalAdultAfter = driver.findElement(By.cssSelector("#divpaxinfo")).getText();
		System.out.println(totalAdultAfter);

		// verify checkboxes
		Assert.assertFalse(driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).isSelected());

		List<WebElement> count = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(count.size());
		Assert.assertEquals(count.size(), 6);

		// Auto suggestive dropdown

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> counts = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

		for (WebElement count1 : counts) {
			if (count1.getText().equalsIgnoreCase("India")) {
				count1.click();
				break;
			}
		}

		// handle dynamic dropdowns of from and to
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		// driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		Thread.sleep(3000);
		// Parent child relationship
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		// driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();
		Thread.sleep(3000);
		String currentDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).getText();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(1000);
		// driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();
		// Thread.sleep(2000);
		// List<WebElement> futureDates =
		// driver.findElements(By.xpath("//div[@id='ui-datepicker-div']
		// //a[@class='ui-state-default']"));
		// System.out.println(futureDates.size());
		// convert currentdate in to int
		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));

		driver.quit();

	}

}
