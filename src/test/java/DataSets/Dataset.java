package DataSets;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Dataset {
	
	@DataProvider(name = "PositiveLoginDataset")
	public Object[][] dataset(Method m){
		
		
		Object[][] testdata= null;
			
			testdata = new Object[][]
			{
				{"standard_user", "secret_sauce"},
				{"error_user", "secret_sauce"}, 
				{"problem_user", "secret_sauce"},
				{"visual_user", "secret_sauce"}
		
			};
		return testdata;
	}
	
	@DataProvider(name = "NegativeLoginDataset")
	public Object[][] dataset2(Method m){
		
		
		Object[][] testdata= null;
			
			testdata = new Object[][]
			{
				{"standard_user", "negative_password1"},
				{"negative_username", "secret_sauce"}, 
				{"negatice_username", "negative_password1"},

		
			};
		return testdata;
	}
	

	///--DATA SET FOR LOGIN FUNCTIONALTY TESTING--///
	@DataProvider(name = "CheckoutDataset")
	public Object[][] dataset3(Method m) {

		Object[][] testdata = null;
		
			testdata = new Object[][] { { "Wilbert", "Lacuesta", "2306" }, 
					{ "", "Lacuesta", "2306"},
					{ "Wilbert", "", "2306" },
					{ "Wilbert", "Lacuesta", "" }, 
					{ "", "", "2306" },
					{ "", "Lacuesta", "" }, 
					{ "Wilbert", "", "" },

			};
	
		return testdata;
	}
}