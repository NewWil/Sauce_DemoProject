package TestCases;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
public class BaseTest {

	WebDriver driver;
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		
}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	 
}
