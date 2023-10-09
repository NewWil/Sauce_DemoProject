package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddtoCartObject {
	WebDriver driver;
	
	//Add to cart Button
	By AddtoCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
	
	//Shopping Cart
	By ShoppingCart = By.id("shopping_cart_container");
	
	//List of Item added on the cart
	//By ListItem = By.xpath("//div[@class='inventory_item_name']");
	
	//Remove Button
	By RemoveButton = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");
	
	public AddtoCartObject(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void AddtoCartButton() {
		driver.findElement(AddtoCartButton).click();
	}
	
	public void ShoppingCart() {
		driver.findElement(ShoppingCart).click();
	}
	
	
	public void Removebutton() {
		driver.findElement(RemoveButton).click();
	}
	
	/*public String ListItem() {
		return driver.findElement(ListItem).getText();
*/	//}
}
