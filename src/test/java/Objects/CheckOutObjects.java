package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutObjects {
WebDriver driver;
	
public CheckOutObjects(WebDriver driver){
	this.driver = driver;
}

	
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
	By CheckoutTitle = By.xpath("//span[contains(text(), 'Your Cart')]");
	
	//Error Message
	By ErrorMessage = By.xpath("//div[@class='error-message-container error']");
	
	//Checkout Overview Title
	By CheckoutOverviewTitle = By.xpath("//span[contains(text(), 'Checkout: Overview')]");
	
	//Finish Checkout Page
	By msgChechoutComplete = By.xpath("//span[contains(text(), 'Checkout: Complete!')]");
	
	//Cancel Button in Checkout Info
	By btnCancel = By.id("cancel");
	
									
	
	public String CheckoutOverviewTitle() {
		return driver.findElement(CheckoutOverviewTitle).getText();
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
	
	public void btnCancel() {
		driver.findElement(By.id("cancel")).click();
	}
																			
	
	
											///--Checkout Overview objects--//
	
	//Id for Finish button in Checkout 
	By btnFinish = By.id("finish");
			
	//Product Page title 
	By ProductTitle = By.xpath("//span[contains(text(), 'Products')]");
		
	//Finish Button
	By btnBackHome = By.id("back-to-products");
		
	//Cancel button for Checkout Overview
	By btnOverviewCancel = By.id("cancel");
		
		
	
	public void btnFinish() {
		driver.findElement(btnFinish).click();
	}
	
	public String msgFinishCheckout() {
		return driver.findElement(msgChechoutComplete).getText(); 
	}
	 

	public String ProductTitle() {
		return driver.findElement(ProductTitle).getText();
	}
	
	public void btnBackHome() {
		driver.findElement(btnBackHome).click();
	}
	
	public void btnOverviewCancel() {
		driver.findElement(btnOverviewCancel).click();
	}
}
