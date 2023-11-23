package TestCases;

import java.time.Duration;
import java.util.ArrayList;
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

public class CheckoutOverview extends BaseTest {

	
													/// --TEST CASE SCENARIO 8: Validating the Checkout Overview Functionalities--///
											
	@BeforeMethod
	public void loginpage() {
		LoginObjects page = new LoginObjects(driver);	
		page.username("standard_user");
		page.password("secret_sauce");
		page.btn_login();
	}
	
	@Test()
	public void CheckoutOverviewTest() throws InterruptedException{
		
	CheckOutObjects checkout = new  CheckOutObjects(driver);
	AddtoCartObject addtocartfunc = new AddtoCartObject(driver);
	

	List<WebElement> addproduct = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));

	//add multiple product
	for (WebElement click : addproduct) {
		
		click.click();
	}
	

	//click shopping cart
	addtocartfunc.ShoppingCart();
	
	//click check out button
	checkout.btnCheckout();
	
	//insert data on Firstname field
	checkout.Firstname("Wilbert");
	
	//insert data on Lastname field
	checkout.LastName("Lacuesta");
	
	//insert data on PostalCode field
	checkout.PostalCode("2306");
	
	//Click Continue Button
	checkout.btnContinue();
	
	//Wait till all the product is reloaded in the lists
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5).getSeconds(), TimeUnit.SECONDS);

	//List in Your cart Page
	List<WebElement> inventoryList1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
	
	//List in Checkout Overview
	List<WebElement> inventoryList2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
	
        // Iterate through the elements in both lists and compare them
        for (int i = 0; i < inventoryList1.size(); i++) {
            WebElement element1 = inventoryList1.get(i);
            WebElement element2 = inventoryList2.get(i);
            
            Assert.assertEquals(element1.getText(), element2.getText(), "Text content is not equal.");   
    }
        
        				
        		//--Verify the Total price of the Products
        
        List<WebElement> itemprice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        // Remove Dollar sign and convert string to double
        List<Double> itempricelist = new ArrayList<Double>();

        for (WebElement we : itemprice) {
            itempricelist.add(Double.valueOf(we.getText().replace("$", "")));
        }

        // Get and remove the element and the tax value
        WebElement tax = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));

        // Get the tax value
        double collectedtax = Double.valueOf(tax.getText().replace("Tax: $", ""));

        // Calculate the total item price including tax
        double total = 0.0;

        for (Double price : itempricelist) {
            total += price;
        }

        // Add the tax to the total
        total += collectedtax;

       //Get the elements of total summary
        WebElement actualprice = driver.findElement(By.xpath("//div[@class= 'summary_info_label summary_total_label']"));
        
        //remove the text and just include the total value
        double actualtotalprice = Double.valueOf(actualprice.getText().replace("Total: $", ""));
    
        //Assert
        Assert.assertEquals(actualtotalprice, total, "Not Calculated");
	
       
	//Click Finish Button
	checkout.btnFinish();
	
	//Verify Finish Button
	String actualTitle = checkout.msgFinishCheckout();
	Assert.assertEquals(actualTitle, "Checkout: Complete!", "Title is not as expected");
	
	//click Back home button
	checkout.btnBackHome();
	
	//Verify that it is back to the "Product Page"
	Assert.assertEquals(checkout.ProductTitle(),"Products", "Product page NOT FOUND!");
	
	}
				
	
																		/// TESTCASE SCENARIO 7:
																///--Validating the Checkout Overview "Cancel" button Functionalities--///
	@Test()
	public void btnCancelOverview() {
		CheckOutObjects checkout = new  CheckOutObjects(driver);
		AddtoCartObject addtocartfunc = new AddtoCartObject(driver);
		
		//click shopping cart
		addtocartfunc.ShoppingCart();
		
		//Click Checkout
		checkout.btnCheckout();
		
		//insert data on Firstname field
		checkout.Firstname("Wilbert");
		
		//insert data on Lastname field
		checkout.LastName("Lacuesta");
		
		//insert data on PostalCode field
		checkout.PostalCode("2306");
		
		//click Continue
		checkout.btnContinue();
		
		//Click Cancel
		checkout.btnOverviewCancel();
		
		//Assert
		Assert.assertEquals(checkout.ProductTitle(), "Products", "NOT Found!");
	}

}
