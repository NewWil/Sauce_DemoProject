package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import DataSets.Dataset;
import Objects.LoginObjects;

@Test
public class PositiveLogin extends BaseTest {
		
	@Test(dataProvider = "PositiveLoginDataset", dataProviderClass = Dataset.class)
	public void PositiveLoginTest1(String username, String password ) { 
		
		LoginObjects pageobjects = new LoginObjects(driver);
		
		//Enter Correct username
		pageobjects.username(username);
		
		//Enter Correct Password
		pageobjects.password(password);
		
		//Click L
		pageobjects.btn_login();
		
		if(username.equals("standard_user")&& password.equals("secret_sauce")) {
			Assert.assertEquals(driver.getTitle(), "Swag Labs", "PAGE NOT FOUND!");
		}
		
		else if(username.equals("error_user")&& password.equals("secret_sauce")) {
			Assert.assertEquals(driver.getTitle(), "Swag Labs", "PAGE NOT FOUND!");
		}
		
		else if(username.equals("problem_user")&& password.equals("secret_sauce")) {
			Assert.assertEquals(driver.getTitle(), "Swag Labs", "PAGE NOT FOUND!");
		}
		
		else {
			Assert.assertEquals(driver.getTitle(), "Swag Labs", "PAGE NOT FOUND!");
		}
	}

	
	
}
