package DataSets;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class LoginDataSets {
	@DataProvider(name = "LoginDataset")
	public Object[][] dataset(Method m){
		
		
		Object[][] testdata= null;
			
			testdata = new Object[][]
			{
				{"standard_user", "secret_sauce"},
				{"standard_user", "invalid_pass"}, 
				{"invalid_User", "secret_sauce"},
				{"invalid_User", "Invalid_pass"}
		
			};
		return testdata;
	
	}
			
			
}
