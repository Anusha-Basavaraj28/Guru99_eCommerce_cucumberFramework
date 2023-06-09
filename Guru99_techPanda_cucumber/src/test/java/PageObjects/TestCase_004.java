package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase_004 {
	
WebDriver driver;
	
	public TestCase_004(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.XPATH,using = "(//ul[@class='add-to-links']//li[2])[1]")
	WebElement samsungAddToCmp;
	
	@FindBy(how=How.XPATH,using = "(//ul[@class='add-to-links']//li[2])[3]")
	WebElement IPhoneAddToCmp;
	
	
	@FindBy(how=How.XPATH,using = "(//ul[@class='add-to-links']//li[2])[2]")
	WebElement sonyXperiaAddToCmp;			
	
	@FindBy(how=How.XPATH,using = "//button[@title='Compare']")
	@CacheLookup
	WebElement compareButton;
	
	
	
	public void clickSamsungAddToCpm(){
		samsungAddToCmp.click();
		
	}
	
	public void clicIphoneAddToCpm(){
		IPhoneAddToCmp.click();
		
	}
	
	public void clicSonyXperiaAddToCpm(){
		sonyXperiaAddToCmp.click();
		
	}
	
	public void clickCmpButton(){
		compareButton.click();
		
	}
	
	
	
	
	
	
	
	
	
	

}
