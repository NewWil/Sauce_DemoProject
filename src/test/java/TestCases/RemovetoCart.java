package TestCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Objects.AddtoCartObject;
import Objects.CheckOutObjects;
import Objects.LoginObjects;

public class RemovetoCart extends BaseTest{

		
		@BeforeMethod
		public void loginpage() {
			LoginObjects page = new LoginObjects(driver);	
			page.username("standard_user");
			page.password("secret_sauce");
			page.btn_login();
		}
		
		
		@Test()
		public void Remove() {
		
			//Verify Successful Logged In
			Assert.assertEquals(driver.getTitle(), "Swag Labs", "NOT FOUND!");
				
				List<WebElement> inventoryList = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));

				for (WebElement click : inventoryList) {

					click.click();
				}
			
			
			//List all the remove button
			List<WebElement> removebutton = driver.findElements(By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory ']"));
		
			// Check visibility for each remove button and Verify if "Remove" button is displaying once the "Add to Cart" button is clicked.
			for (WebElement remove : removebutton) {
				Assert.assertTrue(remove.isDisplayed(), "Not all remove buttons are visible.");
				
			}
			
			//Convert the string in the shopping cart icon	
			WebElement items = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
			
			 String addeditems = items.getText();
			 int Value = Integer.parseInt(addeditems);
			
			 //Get the list of the items added and compared it to the converted string of the badge
			 Assert.assertEquals(Value, removebutton.size(), "Not Match!");
			 
			 
			 AddtoCartObject object = new AddtoCartObject(driver);
			 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5).getSeconds(), TimeUnit.SECONDS);
			 
			 //click shopping cart Icon
			 object.ShoppingCart();
			 
			 
			 List<WebElement> removebutton2 = driver.findElements(By.xpath("//button[contains(text(), 'Remove')]"));
			 for(WebElement remove: removebutton2) {
				 
				 //verify if the remove buttons are displaying
				 Assert.assertTrue(remove.isDisplayed());
				 
				 //Click all the remove buttons
				 remove.click();
			 }
			 
			//13. Verify if the Removed product is not available in the "Your Cart" page.
			//Wait till all the product is reloaded in the lists
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5).getSeconds(), TimeUnit.SECONDS);
		    //List all the product added in the product page
			List<WebElement> removeditems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			Assert.assertTrue(removeditems.isEmpty(), "Products are still displaying");
				
	}
		//Validating Continue Shopping button Functionality in "Your Cart" Page
		@Test()
		public void ContinueShopping() {
			
			//erify Successful Logged In
			Assert.assertEquals(driver.getTitle(), "Swag Labs", "NOT FOUND!");
			
			//Click Cart Icon
			AddtoCartObject object = new AddtoCartObject(driver);
			object.ShoppingCart();
			
			//Click "Continue Shopping" button
			object.btnContinueShopping();
			
			//Verify that the "Continue Shopping" button redirects to its designated page.
			CheckOutObjects object2 = new  CheckOutObjects(driver);
			
			Assert.assertEquals(object2.ProductTitle(), "Products");
			
		}
		
		// Validating Continue Shopping button Functionality in "Your Cart" Page
		@Test
		public void Checkout() {

			// erify Successful Logged In
			Assert.assertEquals(driver.getTitle(), "Swag Labs", "NOT FOUND!");

			

			//clicck add to cart button
			List<WebElement> inventoryList = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));

			for (WebElement click : inventoryList) {

				click.click();
			}
			
			// Click Cart Icon
			AddtoCartObject object = new AddtoCartObject(driver);
			object.ShoppingCart();
			
			//Verify if the "Check Out" button is disabled when there are no available products to be checked out.
			List<WebElement> addeditems = driver.findElements(By.xpath("div[@class='inventory_item_name']"));
			
			if (addeditems.isEmpty()) {
				
				Assert.assertTrue(driver.findElement(By.id("checkout")).isEnabled());
				
			}
			else {
				Assert.assertFalse(driver.findElement(By.id("checkout")).isEnabled(), "Not Added Product to be Checked Out!");
			}
		
		}
				
}
