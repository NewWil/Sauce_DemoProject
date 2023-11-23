package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataSets.Dataset;
import Objects.AddtoCartObject;
import Objects.CheckOutObjects;
import Objects.LoginObjects;


public class CheckoutInfo extends BaseTest {
	
																				///--TEST CASE SCENARIO 6: 
																		///--VALIDATING INPUTS FROM CHECKOUT PAGE--///

	@BeforeMethod
	public void loginpage() {
		LoginObjects page = new LoginObjects(driver);	
		page.username("standard_user");
		page.password("secret_sauce");
		page.btn_login();
	}
	
	
	@Test(dataProvider = "CheckoutDataset", dataProviderClass = Dataset.class)
	public void Checkout(String fname, String lname, String zipcode){
		
		CheckOutObjects checkout = new  CheckOutObjects(driver);
		AddtoCartObject addtocartfunc = new AddtoCartObject(driver);
		
		//click shopping cart
		addtocartfunc.ShoppingCart();
		
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
	
			Assert.assertEquals(checkout.CheckoutOverviewTitle(), "Checkout: Overview", "Title is not as expected");
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
	
										
															/// TESTCASE SCENARIO 7:  
												//--VERIFY CANCEL BUTTON FUNCTIONALITY IN CHECKOUT PAGE--///
	
	
	@Test()
	public void CancelButton() throws InterruptedException{
	
	CheckOutObjects checkout = new  CheckOutObjects(driver);
	AddtoCartObject addtocartfunc = new AddtoCartObject(driver);
	
	//click shopping cart
	addtocartfunc.ShoppingCart();
	
	//click check out button
	checkout.btnCheckout();
	
	//insert data on Firstname field
	checkout.Firstname("Wilbert");
	
	//insert data on Lastname field
	checkout.LastName("Legaspi");
	
	//insert data on PostalCode field
	checkout.PostalCode("Lacuesta");
	//Click Cancel
	checkout.btnCancel();

	  //Verify Finish Button String actualTitle = checkout.ProductTitle();
	Assert.assertEquals(checkout.CheckoutTitle(), "Your Cart", "Title is not as expected");
	 
	}
}
