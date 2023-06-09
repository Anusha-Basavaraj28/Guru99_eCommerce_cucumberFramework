package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase_005 {
	
WebDriver driver;
	
	public TestCase_005(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.LINK_TEXT,using = "ACCOUNT")
	@CacheLookup
	WebElement accountBtn;
	
	
	
	@FindBy(how=How.XPATH,using = "//li[@class='first']")
	@CacheLookup
	WebElement myACC;
	
	
	@FindBy(how=How.XPATH,using = "//a[@title='Create an Account']")
	@CacheLookup
	WebElement createACC;
	
	
	@FindBy(how=How.ID,using = "firstname")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(how=How.ID,using = "lastname")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(how=How.ID,using = "email_address")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.ID,using = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.ID,using = "confirmation")
	@CacheLookup
	WebElement confirmation;
	
	
	
	@FindBy(how=How.XPATH,using = "//button[@title='Register']")
	@CacheLookup
	WebElement registerBtn;
	
	@FindBy(how=How.LINK_TEXT,using = "TV")
	@CacheLookup
	WebElement TV;
	
	
	@FindBy(how=How.XPATH,using = "//h2//a[@title='LG LCD']")
	@CacheLookup
	WebElement lgLcd;
	
	
	@FindBy(how=How.LINK_TEXT,using = "Add to Wishlist")
	@CacheLookup
	WebElement addToWishList;
	
	
	@FindBy(how=How.XPATH,using = "//button[@title='Share Wishlist']")
	@CacheLookup
	WebElement shareWL;
	
	
	@FindBy(how=How.XPATH,using = "//textarea[@id='email_address']")
	@CacheLookup
	WebElement emailAdd;
	
	
	@FindBy(how=How.XPATH,using = "//button[@title='Share Wishlist']")
	@CacheLookup
	WebElement shareEmail;
	
	public void clickAddAcc() {
		accountBtn.click();
	}
	public void clickMyAcc() {
		myACC.click();
	}
	public void clickCreateAcc() {
		createACC.click();
	}
	
	public void setFName(String name) {
		firstname.sendKeys(name);
	}
	
	public void setLName(String name) {
		lastname.sendKeys(name);
	}
	
	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setPwd(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setCinfirmPwd(String cPwd) {
		confirmation.sendKeys(cPwd);
	}
	
	
	public void clickReg() {
		registerBtn.click();
	}
	
	public void clickTV() {
		TV.click();
	}
	
	public void clickLgLcd() {
		lgLcd.click();
	}
	public void clickaddWish() {
		addToWishList.click();
	}
	public void clickShareWL() {
		shareWL.click();
	}
	public void setEmailAddress(String s) {
		emailAdd.sendKeys(s);
	}
	
	public void clickShareEmail() {
		shareEmail.click();
	}

}
