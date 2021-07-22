package page_functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	
	WebDriver driver;
	
	public RediffLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By username = By.id("login1");
	By password = By.id("password");
	By gobtn = By.cssSelector("input[type=submit]");
	
	public WebElement EmailID() {
		return driver.findElement(username);
	}
	
	public WebElement Password() {
		return driver.findElement(password);
	}
	
	public WebElement GoButton() {
		return driver.findElement(gobtn);
	}

}
