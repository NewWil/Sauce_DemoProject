package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By username = By.id("user-name");
	By password = By.id("password");
	By btn_login = By.id("login-button");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void username(String input_username) {
		driver.findElement(username).sendKeys(input_username);
		
	}
	
	public void password(String input_password) {
		driver.findElement(password).sendKeys(input_password);
	}
	
	public void btn_login() {
		driver.findElement(btn_login).click();
	}



}
