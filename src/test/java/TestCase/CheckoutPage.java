package TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Objects.CheckoutObjects;
import Objects.LoginPage;
import DataSets.CheckoutDataSet;


public class CheckoutPage extends BaseTest {
																			///--TEST CASE SCENARIO 6: 
																   ///--VALIDATING INPUTS FROM CHECKOUT PAGE--///
	
	@BeforeMethod
	public void loginpage() {
		LoginPage page = new LoginPage(driver);	
		page.username("standard_user");
		page.password("secret_sauce");
		page.btn_login();
	}
	

	@Test(dataProvider = "CheckoutDataset", dataProviderClass = CheckoutDataSet.class)
	public void Checkout(String fname, String lname, String zipcode){
		
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
	
	
													/// --TEST CASE SCENARIO 7: FINISH BUTTON IN CHECK OUT PAGE--///
													/// --VERIFY FINISH BUTTON FUNCTIONALITY IN CHECKOUT PAGE--///
	
	
	
	@Test()
	public void FinishButton(){
		
		CheckoutObjects checkout = new  CheckoutObjects(driver);
		
		//click shopping cart
		checkout.ShoppingCart();
		
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
		
		//Click Finish Button
		checkout.btnFinish();
		
		//Verify Finish Button
		String actualTitle = checkout.msgFinishCheckout();
	    Assert.assertEquals(actualTitle, "Checkout: Complete!", "Title is not as expected");
	
	}
	
	
													/// --TEST CASE SCENARIO 8: CANCEL BUTTON--///
													/// --VERIFY CANCEL BUTTON FUNCTIONALITY IN CHECKOUT PAGE--///
	
	@Test
	public void CancelButton(){
		
		CheckoutObjects checkout = new  CheckoutObjects(driver);

		//click shopping cart
		checkout.ShoppingCart();
		
		//click check out button
		checkout.btnCheckout();
		
		//insert data on Firstname field
		checkout.Firstname("Wilbert");
		
		//insert data on Lastname field
		checkout.LastName("Legaspi");
		
		//insert data on PostalCode field
		checkout.PostalCode("Lacuesta");
		
		//Click Continue Button
		checkout.btnContinue();
		
		//Click Cancel
		checkout.btnCancel();
		
		//Verify Finish Button
		String actualTitle = checkout.ProductTitle();
	    Assert.assertEquals(actualTitle, "Products", "Title is not as expected");
	
	}
	
	

															/// -TEST CASE SCENARIO 9: BACK HOME BUTTON BUTTON--///
															/// --VERIFY BACKHOME BUTTON FUNCTIONALITY--///

	@Test()
	public void BackHome() {

		CheckoutObjects checkout = new  CheckoutObjects(driver);

		//click shopping cart
		checkout.ShoppingCart();
		
		//click check out button
		checkout.btnCheckout();
		
		//insert data on Firstname field
		checkout.Firstname("Wilbert");
		
		//insert data on Lastname field
		checkout.LastName("Legaspi");
		
		//insert data on PostalCode field
		checkout.PostalCode("Lacuesta");
		
		//Click Continue Button
		checkout.btnContinue();
		
		//CLick Finish Button
		checkout.btnFinish();

		// click backhome
		checkout.btnBackHome();

		String actualtitle = checkout.ProductTitle();
		String expectedtitle = "Products";

		Assert.assertEquals(actualtitle, expectedtitle, "Page NOT FOUND");

	}

}
