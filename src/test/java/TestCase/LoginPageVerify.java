package TestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Objects.LoginPage;
import DataSets.LoginDataSets;

public class LoginPageVerify extends BaseTest{
														///--TEST CASE SCENARIO 2: VALIDATING LOGIN FUNCTIONALITY--///
																	///--VERIFY LOGIN FUNCTIONALITY--///
	
	@Test(dataProvider = "LoginDataset", dataProviderClass = LoginDataSets.class)
	public void LoginVerify(String username, String password) {
		
		LoginPage page = new LoginPage(driver);	
		
		page.username(username);
		page.password(password);
		page.btn_login();
		

		if (username.equals("standard_user") && password.equals("secret_sauce")) {
			Assert.assertEquals(driver.getTitle(), "Swag Labs", "Not Found");
		}
		
		else if (username.equals("standard_user") && password.equals("invalid_pass")) {
			String ActualMessage = page.LoginErrorMessage();
			Assert.assertEquals(ActualMessage, "Epic sadface: Username and password do not match any user in this service", "Not Found");
		}
		
		else if (username.equals("invalid_User") && password.equals("secret_sauce")) {
			String ActualMessage = page.LoginErrorMessage();
			Assert.assertEquals(ActualMessage, "Epic sadface: Username and password do not match any user in this service", "Not Found");
		}
		
		else {
			String ActualMessage = page.LoginErrorMessage();
			Assert.assertEquals(ActualMessage, "Epic sadface: Username and password do not match any user in this service", "Not Found");
		}
		
	}
	
}
