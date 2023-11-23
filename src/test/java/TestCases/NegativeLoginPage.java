package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataSets.Dataset;
import Objects.LoginObjects;

public class NegativeLoginPage extends BaseTest {
	
	@Test(dataProvider = "NegativeLoginDataset", dataProviderClass = Dataset.class)
	public void PositiveLoginTest1(String username, String password ) { 
		
		LoginObjects pageobjects = new LoginObjects(driver);
		
		//Enter Correct username
		pageobjects.username(username);
		
		//Enter Correct Password
		pageobjects.password(password);
		
		//Click Login Button
		pageobjects.btn_login();
		
		if(username.equals("standard_user")&& password.equals("negative_password1")) {
			Assert.assertEquals(pageobjects.LoginErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "PAGE NOT FOUND!");
		}
		
		else if(username.equals("negative_username")&& password.equals("secret_sauce")) {
			Assert.assertEquals(pageobjects.LoginErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "PAGE NOT FOUND!");
		}
		
		else {
			Assert.assertEquals(pageobjects.LoginErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "PAGE NOT FOUND!");
		}
	}
}
