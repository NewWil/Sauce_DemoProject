package TestCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Objects.AddtoCartObject;
import Objects.LoginObjects;



public class AddtoCart extends BaseTest{
		
	@BeforeMethod
	public void loginpage() {
		LoginObjects page = new LoginObjects(driver);	
		page.username("standard_user");
		page.password("secret_sauce");
		page.btn_login();
	}
	
	@Test
	public void AddtoCartTest() {
		
		
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
		 
		 //click shopping cart Icon
		 object.ShoppingCart();
		 
		 //Verify the added products in "Your Cart" page 
		
		//Wait till all the product is reloaded in the lists
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5).getSeconds(), TimeUnit.SECONDS);

		  //List all the product added in the product page
		    List<WebElement> inventoryList1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

		    //List in Checkout Overview
		    List<WebElement> inventoryList2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

		    // Iterate through the elements in both lists and compare them
		    for (int i = 0; i < inventoryList1.size(); i++) {
		        WebElement element1 = inventoryList1.get(i);
		        WebElement element2 = inventoryList2.get(i);

		        Assert.assertEquals(element1.getText(), element2.getText(), "Text content is not equal.");
		    }

		
	}
}