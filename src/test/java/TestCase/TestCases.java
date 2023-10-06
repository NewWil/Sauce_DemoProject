package TestCase;
import org.testng.annotations.Test;
import Objects.LoginPage;


public class TestCases extends BaseTest{
	
	@Test
	public void loginpage() {
		LoginPage page = new LoginPage(driver);	
		page.username("standard_user");
		page.password("secret_sauce");
		page.btn_login();
	}
	
}
