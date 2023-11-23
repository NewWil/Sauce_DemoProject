package Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddtoCartObject {
	
	WebDriver driver;
	
	
	public AddtoCartObject(WebDriver driver){
		this.driver = driver;
	}
	
	//Shopping cart Id
	By ShoppingCartContainer = By.id("shopping_cart_container");
	
	public void ShoppingCart() {
		driver.findElement(ShoppingCartContainer).click();
	}
	
	//Click Multiple Add to cart 
	
	By addtocart = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
	
	//Continue shopping button
	
	By btnContinueShopping = By.id("continue-shopping");
	public void btnContinueShopping() {
		driver.findElement(btnContinueShopping).click();
	}
	
	
}
