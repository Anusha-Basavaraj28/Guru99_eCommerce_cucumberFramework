package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase_003 {
	
	WebDriver driver;
	
	public TestCase_003(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using = "//button[@title='Add to Cart']")
	@CacheLookup
	WebElement addTocart;
	
	
	@FindBy(how=How.XPATH,using = "(//button[@title='Add to Cart'])[2]")
	@CacheLookup
	WebElement sonyXAddTocart;		
			
	
	@FindBy(how=How.XPATH,using = "//input[@class='input-text qty']")  
	@CacheLookup
	WebElement qty;
	
	
	@FindBy(how=How.XPATH,using = "//button[@title='Update']")
	@CacheLookup
	WebElement updateButton;
	
	
	
	@FindBy(how=How.XPATH,using = "//p[@class='item-msg error']")
	@CacheLookup
	WebElement errorMsg;
	
	@FindBy(how=How.ID,using = "empty_cart_button")
	@CacheLookup
	WebElement emptyCart;
	
	
	public void addToCart() {
		addTocart.click();
	}
	
	public void sonyXAddToCart() {
		sonyXAddTocart.click();
	}
	
	public void editQuantity(String num) {
		qty.clear();
		qty.sendKeys(num);
	}
	
	public void update() {
		updateButton.click();
	}
	
	public String getError() {
		return errorMsg.getText();
	}
	
	public void emptyCart() {
		emptyCart.click();
	}
			

}
