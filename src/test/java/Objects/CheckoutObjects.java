package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutObjects {

	WebDriver driver;
	
	//Shopping cart Id
	By ShoppingCartContainer = By.id("shopping_cart_container");
	
	//Checkout button ID
	By btnCheckout = By.id("checkout");
	
	//INput Field Firstname ID
	By FirstName = By.id("first-name");
	
	//Input field Lastname ID
	By LastName = By.id("last-name");
	
	//Input field Zipcode/postal ID
	By PostalCode = By.id("postal-code");
	
	//Button Continue ID
	By btnContinue = By.id("continue");
	
	//Assertion
	By CheckoutTitle = By.xpath("//span[contains(text(), 'Checkout: Overview')]");
	
	//Error Message
	By ErrorMessage = By.xpath("//div[@class='error-message-container error']");
	
	//Id for Finish button in Checkout overview
	By btnFinish = By.id("finish");
	
	//Finish Checkout Page
	By msgChechoutComplete = By.xpath("//span[contains(text(), 'Checkout: Complete!')]");
	
	//Cancel Button in Checkout Overview
	By btnCancel = By.id("cancel");
	
	//Product Page title
	By ProductTitle = By.xpath("//span[contains(text(), 'Products')]");
	
	//Finish Button
	By btnBackHome = By.id("back-to-products");
	
	
	
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
	
	public void btnFinish() {
		driver.findElement(btnFinish).click();
	}
	
	public String msgFinishCheckout() {
		return driver.findElement(msgChechoutComplete).getText(); 
	}
	 
	public void btnCancel() {
		driver.findElement(btnCancel).click();
	}
	
	public String ProductTitle() {
		return driver.findElement(ProductTitle).getText();
	}
	
	public void btnBackHome() {
		driver.findElement(btnBackHome).click();
	}
	

	
}
	

