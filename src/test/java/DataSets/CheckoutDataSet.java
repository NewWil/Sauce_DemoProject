package DataSets;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class CheckoutDataSet {

	
	///--DATA SET FOR LOGIN FUNCTIONALTY TESTING--///
	@DataProvider(name = "dataset1")
	public Object[][] dataset(Method m) {

		Object[][] testdata = null;

		if (m.getName().equals("Checkout")) {
			testdata = new Object[][] { { "Wilbert", "Lacuesta", "2306" }, 
					{ "", "Lacuesta", "2306"},
					{ "Wilbert", "", "2306" },
					{ "Wilbert", "Lacuesta", "" }, 
					{ "", "", "2306" },
					{ "", "Lacuesta", "" }, 
					{ "Wilbert", "", "" },

			};
		}
		return testdata;
	}
}