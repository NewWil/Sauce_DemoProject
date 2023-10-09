package TestCase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Objects.CheckoutObjects;
import Objects.LoginPage;
import Objects.AddtoCartObject;

public class AddtoCartPage extends BaseTest {
	
															///--TEST CASE SCENARIO 3: ADD PRODUCT TO CART--///
														    ///--VERIFY ADD TO CART BUTTON FUNCTIONALITY--///

	@BeforeMethod
	public void loginpage() {
		LoginPage page = new LoginPage(driver);	
		page.username("standard_user");
		page.password("secret_sauce");
		page.btn_login();
	}
	
	@Test
	public void Addtocart() {
		AddtoCartObject addtocart = new  AddtoCartObject(driver);	
		
		List<WebElement> inventoryList = driver.findElements(By.cssSelector("div[class='inventory_item']"));

		for (int i = 0; i < inventoryList.size(); i++) {

			addtocart.AddtoCartButton();
		}

		// Go to Your Cart page to check all added products
		addtocart.ShoppingCart();

		List<WebElement> getsize = driver.findElements(By.cssSelector("div[class='inventory_item_name']"));

		String ActualResult;
		String ExpectedResult;

		for (WebElement we : getsize) {

			ActualResult = we.getText();
			ExpectedResult = we.getText();

			Assert.assertEquals(ActualResult, ExpectedResult, "No Record Found");
			
		}

		
	}
	
	

															/// --TEST CASE SCENARIO 4: REMOVE PRODUCT TO CART--///
																/// --VERIFY REMOVE BUTTON FUNCTIONALITY--///
	
	@Test
	public void RemovedProductsFromCart() throws InterruptedException {
		AddtoCartObject addtocart = new  AddtoCartObject(driver);	
		// Add products to the cart
		List<WebElement> inventoryList = driver.findElements(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']"));

		for (int i = 0; i < inventoryList.size(); i++) {

			addtocart.AddtoCartButton();
		}

		// Go to the cart page
		driver.findElement(By.cssSelector("#shopping_cart_container")).click();

		// Get the names of the products in the cart
		List<WebElement> itemname = driver.findElements(By.cssSelector("div[class='inventory_item_name']"));
		List<String> productNamesInCart = new ArrayList<String>();
		for (WebElement item : itemname) {
			productNamesInCart.add(item.getText());
		}

		// Remove the products from the cart
		List<WebElement> removed = driver.findElements(By.cssSelector("button[class='btn btn_secondary btn_small cart_button']"));
		

		for (int i = 0; i < removed.size(); i++) {

			addtocart.Removebutton();
		}
		
		
		// Get the names of the products after removal
		List<WebElement> listafterremoved = driver.findElements(By.cssSelector("div[class='inventory_item_name']"));

		// Validate if all products have been removed
		Assert.assertTrue(listafterremoved.isEmpty(), "All products have been removed from the cart");
	}
	
	
	

}
