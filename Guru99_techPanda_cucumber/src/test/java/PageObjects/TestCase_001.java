package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestCase_001 {
	
	WebDriver driver;

	public TestCase_001(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.LINK_TEXT,using = "MOBILE")
	@CacheLookup
	WebElement mobile;
	
	
	@FindBy(how=How.XPATH,using = "(//select[@title='Sort By'])[1]")
	@CacheLookup
	WebElement sortBy;
	
	@FindBy(how=How.XPATH,using = "//li[@class='item last']")
	@CacheLookup
	List<WebElement> products;
	
	
	
	@FindBy(how=How.XPATH,using = "//li[@class='item last']//h2//a")
	@CacheLookup
	List<WebElement> productNames;
	
	
	
	
	@FindBy(how=How.XPATH,using = "//li[@class='item last']//span[@id='product-price-1']//span")
	@CacheLookup
	WebElement price;
	
	
	public void clickMobile() {
		mobile.click();
	}
	public void sortBy(String s) {
		Select op=new Select(sortBy);
		op.selectByVisibleText(s);
	}
	
	public List<WebElement> getProduct(){
		
		List<WebElement> proList=products;
		
		return proList;
	}
	
	
    public List<WebElement> getProductNames(){
		
		List<WebElement> proNames=productNames;
		
		return proNames;
	}
    
    
    public String getPrice() {
    	return price.getText();
    }

}
