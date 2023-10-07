package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutObjects {

	WebDriver driver;
	
	By ShoppingCartContainer = By.id("shopping_cart_container");
	By btnCheckout = By.id("checkout");
	By FirstName = By.id("first-name");
	By LastName = By.id("last-name");
	By PostalCode = By.id("postal-code");
	By btnContinue = By.id("continue");
	
	//Assertion
	By CheckoutTitle = By.xpath("//span[contains(text(), 'Checkout: Overview')]");
	
	//Error Message
	By ErrorMessage = By.xpath("//div[@class='error-message-container error']");
	
	public CheckoutObjects(WebDriver driver){
		this.driver = driver;
	}
	
	public void ShoppingCart() {
		driver.findElement(ShoppingCartContainer).click();
	}
	
	public void btnCheckout() {
		driver.findElement(btnCheckout).click();
		
	}
	
	public void Firstname(String InputFirstName) {
		driver.findElement(FirstName).sendKeys(InputFirstName);
	}
	
	
	public void LastName(String InputLastName) {
		driver.findElement(LastName).sendKeys(InputLastName);
	}
	
	public void PostalCode(String InputPostalCode) {
		driver.findElement(PostalCode).sendKeys(InputPostalCode);
	}
	
	public void btnContinue() {
		driver.findElement(btnContinue).click();
	}
	
	
	public String CheckoutTitle() {
		return driver.findElement(CheckoutTitle).getText();
	}
	
	
	  public String ErrorMessage() {
		 return driver.findElement(ErrorMessage).getText(); 
	  }
	 
}
	

