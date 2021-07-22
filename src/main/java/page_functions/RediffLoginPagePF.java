package page_functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RediffLoginPagePF {
	
	WebDriver driver;
	
	public RediffLoginPagePF(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="login1")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css="input[type=submit]")
	WebElement gobtn;
	
	public WebElement EmailID() {
		return username;
	}
	
	public WebElement Password() {
		return password;
	}
	
	public WebElement GoButton() {
		return gobtn;
	}

}
