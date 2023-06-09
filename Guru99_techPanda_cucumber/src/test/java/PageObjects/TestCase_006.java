package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestCase_006 {
WebDriver driver;
	
	public TestCase_006(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME,using = "login[username]")
	WebElement loginEmail;
	
	@FindBy(how=How.NAME,using = "login[password]")
	WebElement loginPwd;
	
	@FindBy(how=How.NAME,using = "send")
	WebElement loginBtn;
	
	
	@FindBy(how=How.XPATH,using = "//div[@class='block-content']//ul//li[8]//a")
	WebElement wishList;
	
	@FindBy(how=How.XPATH,using = "//button[@title='Add to Cart']")
	WebElement addToCart;
	
	
	@FindBy(how=How.XPATH,using = "//button[@title='Proceed to Checkout']")
	WebElement proceedToCheckOut;
	
	
	@FindBy(how=How.ID,using = "billing-address-select")
	WebElement newAddress;
	
	
    @FindBy(how=How.NAME,using = "billing[street][]")
	WebElement address;
	
    
    @FindBy(how=How.NAME,using = "billing[city]")
	WebElement city;
    
    @FindBy(how=How.NAME,using = "billing[region_id]")
	WebElement state;		
    
    
    
    @FindBy(how=How.NAME,using = "billing[telephone]")
	WebElement telePhone;
	
  
    @FindBy(how=How.XPATH,using = "//button[@title='Continue']")
	WebElement conBtn;
	
    
	
    @FindBy(how=How.XPATH,using = "(//button[@class='button'])[2]")
    WebElement con2Btn;
    
    
   @FindBy(how=How.XPATH,using = "(//button[@class='button'])[2]")
     WebElement con3Btn;
   
    @FindBy(how=How.ID,using = "p_method_checkmo")
    WebElement payInfo;
	
    @FindBy(how=How.XPATH,using = "//button[@title='Place Order']")
    WebElement placeOrder;
	
	
	@FindBy(how=How.XPATH,using = "//div[@class='col-main']//p[1]//a")
    WebElement orderId;
	
	
	@FindBy(how=How.XPATH,using = "//td[@class='a-center view last']//span//a[normalize-space()='Reorder']")
    WebElement reOrder;
	
	
	@FindBy(how=How.XPATH,using = "//input[@class='input-text qty']")
    WebElement qty;
	
	
	
	@FindBy(how=How.XPATH,using = "//button[@title='Update']")
    WebElement updateBtn;
	
	
	
	
	@FindBy(how=How.XPATH,using = "(//span[@class='cart-price']//span)[1]")
	WebElement price;	
	
	@FindBy(how=How.XPATH,using = "(//span[@class='cart-price']//span)[2]")
	WebElement totalPrice;	
			
	
	public void setEmail(String email) {
		loginEmail.sendKeys(email);
	}
	
	public void setPwd(String pwd) {
		loginPwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void clickWishList() {
		wishList.click();
	}
	
	public void clickAddCart() {
		addToCart.click();
	}
	
	public void clickProceedToCheckOut() {
		proceedToCheckOut.click();
	}
	
	public void setNewAddress(String st) {
		Select s=new Select(newAddress);
		s.selectByVisibleText(st);
    }
	
	public void setAddress(String add) {
		address.clear();
		address.sendKeys(add);
	}
	
	public void setCity(String City) {
		city.clear();
		city.sendKeys(City);
	}
	
	public void setState(String st) {
		Select s=new Select(state);
		s.selectByVisibleText(st);
    }
	
	public void setTelephone(String phone) {
		telePhone.clear();
		telePhone.sendKeys(phone);
	}
	
	public void clickContinue() {
		conBtn.click();
	}
	
	public void clickContinue2() {
		con2Btn.click();
	}
	public void clickContinue3() {
		con3Btn.click();
	}
	
	public void selectPaymentInfo() {
		payInfo.click();
	}
	
	public void clickPlaceOrder() {
		placeOrder.click();
	}
	
	
	public String getOrderId() {
		return orderId.getText();
	}
	
	public void clickREOrder() {
		reOrder.click();
	}
	
	public void setQTY() {
		qty.clear();
		qty.sendKeys("10");
	}
	
	public void clickUpdateBtn() {
		updateBtn.click();
	}
	
	public String getPrice() {
		return price.getText();
	}
	
	
	public String getTotalPrice() {
		return totalPrice.getText();
	}

}
