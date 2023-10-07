package TestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Objects.CheckoutObjects;
import Objects.LoginPage;

import DataSets.CheckoutDataSet;


public class CheckoutPage extends BaseTest {
	
	@BeforeMethod
	public void loginpage() {
		LoginPage page = new LoginPage(driver);	
		page.username("standard_user");
		page.password("secret_sauce");
		page.btn_login();
	}
	
	
	@Test(dataProvider = "dataset1", dataProviderClass = CheckoutDataSet.class)
	public void Checkout(String fname, String lname, String zipcode) throws InterruptedException {
		
		CheckoutObjects checkout = new  CheckoutObjects(driver);
		
		//click shopping cart
		checkout.ShoppingCart();
		
		//click check out button
		checkout.btnCheckout();
		
		//insert data on Firstname field
		checkout.Firstname(fname);
		
		//insert data on Lastname field
		checkout.LastName(lname);
		
		//insert data on PostalCode field
		checkout.PostalCode(zipcode);
		
		//Click Continue Button
		checkout.btnContinue();
		
		if (fname.equals("Wilbert") && lname.equals("Lacuesta") && zipcode.equals("2306")) {
		    String actualTitle = checkout.CheckoutTitle();
		    Assert.assertEquals(actualTitle, "Checkout: Overview", "Title is not as expected");
		}

		else if(fname.equals("") && lname.equals("Lacuesta") && zipcode.equals("2306")) {
			String ActualError = checkout.ErrorMessage();
			Assert.assertEquals(ActualError,"Error: First Name is required", "Not Found");
			
		}
		
		else if(fname.equals("Wilbert") && lname.equals("") && zipcode.equals("2306")) {
			String ActualError = checkout.ErrorMessage();
			Assert.assertEquals(ActualError,"Error: Last Name is required", "Not Found");	
		}
		
		else if(fname.equals("Wilbert") && lname.equals("Lacuesta") && zipcode.equals("")) {
			String ActualError = checkout.ErrorMessage();
			Assert.assertEquals(ActualError,"Error: Postal Code is required", "Not Found");	
		}
	
		else if(fname.equals("") && lname.equals("") && zipcode.equals("2306")) {
			String ActualError = checkout.ErrorMessage();
			Assert.assertEquals(ActualError,"Error: First Name is required", "Not Found");
		}
		
		else if(fname.equals("") && lname.equals("Lacuesta") && zipcode.equals("")) {
			String ActualError = checkout.ErrorMessage();
			Assert.assertEquals(ActualError,"Error: First Name is required", "Not Found");
		}
		
		else {
			String ActualError = checkout.ErrorMessage();
			Assert.assertEquals(ActualError,"Error: Last Name is required", "Not Found");
		}
		
	}

}
