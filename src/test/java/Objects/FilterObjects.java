package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class FilterObjects {

WebDriver driver;
	
	public FilterObjects(WebDriver driver){
		this.driver = driver;
	}
	
	By Filter = By.xpath("//select[@class='product_sort_container']");
	
	// Methods to interact with the dropdown
    public Select Filter() {
        return new Select(driver.findElement(Filter));
    }
}
