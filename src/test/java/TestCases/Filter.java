package TestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Objects.FilterObjects;
import Objects.LoginObjects;


public class Filter extends BaseTest{

	@BeforeMethod
	public void loginpage() {
		LoginObjects page = new LoginObjects(driver);
		page.username("standard_user");
		page.password("secret_sauce");
		page.btn_login();
			}

													
														
																						///---TEST CASE SCENARIO 5:---///
													/// ---Verifying the accuracy of the sort functionality in displaying results from A-Z order--//
	
	@Test()
	public void sortAtoZ() throws InterruptedException {
		// Store the original list of Products in arraylist
		List<WebElement> beforeFilter = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<String> bfilter = new ArrayList<String>();

		
		for (WebElement BF : beforeFilter) {

			bfilter.add(BF.getText());

		} 
			
		// Click Dropdown and select "Name (A-Z)"
		FilterObjects filter = new FilterObjects(driver);
		Select select = filter.Filter();
		select.selectByIndex(0);

		// Store the product after sorting
		List<WebElement> afterFilter = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<String> afilter = new ArrayList<String>();

		for (WebElement AF : afterFilter) {
				afilter.add(AF.getText());
			}

		// why do I sort a sorted List???????
		Collections.sort(bfilter);

		 //Verify that the product display is sorted in alphabetical order (A-Z).
		softAssert.assertEquals(bfilter, afilter, "Sort descending is NOT working!");
		softAssert.assertAll();
		
		Thread.sleep(2000);

	}
	
														///---Verifying the accuracy of the sort functionality in displaying results from Z-A order--//
	
	
			
	@Test()
	public void sortZtoA(){
		
		// Store the original list of Products in arraylist
		List<WebElement> beforeFilter = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<String> bfilter = new ArrayList<String>();
		
		
		 for (WebElement BF : beforeFilter) {
		  
		  bfilter.add(BF.getText());
		 }
	
		// // Click Dropdown and select "Name (Z-A)"
		FilterObjects filter = new FilterObjects(driver);
		Select select = filter.Filter();
		select.selectByIndex(1);
		
		
		// Store the product after sorting
		List<WebElement> afterFilter = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<String> afilter = new ArrayList<String>();
		
		
		  for (WebElement AF : afterFilter) {
		 
		  afilter.add(AF.getText());
		 
		  }
		
		
		Collections.sort(bfilter);
		Collections.reverse(bfilter);
		
		//Assert
		softAssert.assertEquals(bfilter, afilter, "Sort descending Price is NOT working!");
		softAssert.assertAll();
		
		}

				
														///---Verifying the accuracy of the sort functionality in displaying results from Price low to high order---///
		
		
		
	@Test()
	public void PriceLowtoHigh(){
		
		
		//Verify Succesful Logged In
		Assert.assertEquals(driver.getTitle(), "Swag Labs", "Product Page NOT loaded!");
		
		FilterObjects filter = new FilterObjects(driver);

		List<WebElement> beforeFilterPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

		// Remove Dollar sign and convert string to double
		List<Double> beforeFilterPricelist = new ArrayList<Double>();

		for (WebElement we : beforeFilterPrice) {
			beforeFilterPricelist.add(Double.valueOf(we.getText().replace("$", "")));
		}

		// Click Dropdown and select "Price (high to low)"
		Select select = filter.Filter();
		select.selectByIndex(2);

		// after filter
		List<WebElement> AfterFilterPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

		// remove dollar sign in the products
		List<Double> AfterFilterPricelist = new ArrayList<Double>();

		for (WebElement we : AfterFilterPrice) {
			AfterFilterPricelist.add(Double.valueOf(we.getText().replace("$", "")));
		}

		// Sort the Values
		Collections.sort(beforeFilterPricelist);
		softAssert.assertEquals(beforeFilterPricelist, AfterFilterPricelist, "Sort Ascending Price is NOT working!");
		softAssert.assertAll();

	}

	
	
														///---Verifying the accuracy of the sort functionality in displaying results from Price high to low order---///
	
	
	@Test()
	public void PriceHightoLow() throws InterruptedException {
	
		//Verify Succesful Logged In
		Assert.assertEquals(driver.getTitle(), "Swag Labs", "Product Page NOT loaded!");
		
		List<WebElement> beforeFilterPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		// Remove Dollar sign and convert string to double
		List<Double> beforeFilterPricelist = new ArrayList<Double>();
		
		for (WebElement we : beforeFilterPrice) {
			
			beforeFilterPricelist.add(Double.valueOf(we.getText().replace("$", "")));
		}
		
		// Click Dropdown and select "Price (high to low)"
		FilterObjects filter = new FilterObjects(driver);
		Select select = filter.Filter();
		select.selectByIndex(3);
		
		// after filter
		List<WebElement> AfterFilterPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		// remove dollar sign in the products
		List<Double> AfterFilterPricelist = new ArrayList<Double>();
		
		for (WebElement we : AfterFilterPrice) {
			
			AfterFilterPricelist.add(Double.valueOf(we.getText().replace("$", "")));
		
		}
		
		// Sort the Values
		Collections.sort(beforeFilterPricelist);
		Collections.reverse(beforeFilterPricelist);
		
		//Assert the values
		softAssert.assertEquals(beforeFilterPricelist, AfterFilterPricelist, "Sort descending Price is NOT working!");
		softAssert.assertAll();
		
		}

}
