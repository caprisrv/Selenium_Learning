package SeleniumAutomation.Selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// span[contains(text(),'Veg/fruit name')]
		//table[@class='table table-bordered']/thead/following-sibling::tbody/tr/td[1]

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
		
		Thread.sleep(2000);
		
		//Sorting Verification
		
		driver.findElement(By.xpath("//span[contains(text(),'Veg/fruit name')]")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> vegFruitNames1 = driver.findElements(By.xpath("//table[@class='table table-bordered']/thead/following-sibling::tbody/tr/td[1]"));
		
		List<String> listString = vegFruitNames1.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = listString.stream().sorted().collect(Collectors.toList());
		
		if(listString.equals(sortedList)) {
			System.out.println("Sorted");
		}
		else {
			System.out.println("Not Sorted");
		}
		
		List<String> vegPrice;
		//Get the price of Rice Vegetable
		do {
			List<WebElement> vegFruitNames = driver.findElements(By.xpath("//table[@class='table table-bordered']/thead/following-sibling::tbody/tr/td[1]"));
			vegPrice=vegFruitNames.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
			vegPrice.forEach(s->System.out.println(s));
			
			if(vegPrice.size()<1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		}
		while(vegPrice.size()<1);
		
		
		
	
	}

	private static String getPriceVeggie(WebElement s) {
		
		String vegText=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return vegText;
	}

}
