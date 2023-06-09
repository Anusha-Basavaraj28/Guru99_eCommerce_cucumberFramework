package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase_007 {
    WebDriver driver;
	
	public TestCase_007(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	
	
	@FindBy(how=How.XPATH,using = "//div[@class='block-content']//li[4]")
	@CacheLookup
	WebElement myOrder;
	
	
	
	@FindBy(how=How.XPATH,using = "//td[@class='a-center view last']//span//a[normalize-space()='View Order']")
	@CacheLookup
	WebElement viewOrder;
	
	
	@FindBy(how=How.XPATH,using = "//div[@class='page-title title-buttons']//a[2]")
	@CacheLookup
	WebElement printOrder;
	
	/*
	 * Robot rb=new Robot(); rb.delay(2000);
	 * 
	 * // copy path to file and put in clipboard
	 * 
	 * StringSelection sc=new StringSelection("C:\\Resume\\Edit-resume-grey.docx");
	 * 
	 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
	 * 
	 * 
	 * //CTRL+V
	 * 
	 * rb.keyPress(KeyEvent.VK_CONTROL); rb.keyPress(KeyEvent.VK_V);
	 * 
	 * rb.keyRelease(KeyEvent.VK_CONTROL); rb.keyRelease(KeyEvent.VK_V);
	 * 
	 * //ENTER rb.keyPress(KeyEvent.VK_ENTER); rb.keyRelease(KeyEvent.VK_ENTER);
	 */
	
	
	public void clickViewOrder() {
		viewOrder.click();
	}
	
	public void clickMyOrder() {
		myOrder.click();
	}
	
	public void clickPrintOrder() {
		printOrder.click();
	}
	
	
	
	
	
	
	
	
	
	

}
