package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.TestCase_001;
import PageObjects.TestCase_003;
import PageObjects.TestCase_004;
import PageObjects.TestCase_005;
import PageObjects.TestCase_006;
import PageObjects.TestCase_007;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;

public class stepDefinitions {

	WebDriver driver;

	TestCase_001 tc1;
	TestCase_003 tc3;
	TestCase_004 tc4;
	TestCase_005 tc5;
	TestCase_006 tc6;
	TestCase_007 tc7;

	List<WebElement> productList;
	List<String> sortedList = new ArrayList<String>();
	List<String> originalList = new ArrayList<String>();

	String detailPageCost;
	String listPageCost;
	String mainHandle;
	String email;

	@Before
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	}

	// TestCase_001 steps*****************************

	@Given("User opens the application {string} in the browser")
	public void user_opens_the_application_in_the_browser(String URL) throws InterruptedException {
		tc1 = new TestCase_001(driver);
		tc3 = new TestCase_003(driver);
		tc4 = new TestCase_004(driver);

		driver.get(URL);
		Thread.sleep(3000);

	}

	@Then("Title of the page should be {string}")
	public void title_of_the_page_should_be(String title) {

		Assert.assertTrue(driver.getTitle().equals(title));

	}

	@When("User clicks on the mobile menu")
	public void user_clicks_on_the_mobile_menu() throws InterruptedException {
		tc1.clickMobile();
		Thread.sleep(3000);

	}

	@Then("Tile of the page should be {string}")
	public void tile_of_the_page_should_be(String title) {

		Assert.assertTrue(driver.getTitle().equals(title));
	}

	@When("User selects sort by drope down as name")
	public void user_selects_sort_by_drope_down_as_name() throws InterruptedException {
		tc1.sortBy("Name");
		Thread.sleep(3000);
	}

	@Then("all the products should be sorted by name.")
	public void all_the_products_should_be_sorted_by_name() {

		productList = tc1.getProductNames();
		for (WebElement ele : productList) {
			sortedList.add(ele.getText());

		}

		originalList = sortedList;
		System.out.println("********List Bofore Sorting********" + originalList);
		Collections.sort(sortedList);
		System.out.println("********List After Sorting********" + sortedList);

		Assert.assertEquals(sortedList, originalList);

	}

	// TestCase_002 steps*****************************

	@And("In the list of all products read the cost of {string} and note the cost")
	public void in_the_list_of_all_products_read_the_cost_of_and_note_the_cost(String mobileName)
			throws InterruptedException {

		listPageCost = driver.findElement(By.xpath("//span[@class='regular-price']//span")).getText();

	}

	@When("User clicks on SONY XPERIA mobile")
	public void user_clicks_on_sony_xperia_mobile() throws InterruptedException {
		driver.findElement(By.xpath("(//h2[@class='product-name']//a)[2]")).click();
		Thread.sleep(3000);
	}

	@And("user reads the cost of SONY XPERIA mobile in detail page")
	public void user_reads_the_cost_of_sony_xperia_mobile_in_detail_page() {
		detailPageCost = driver.findElement(By.xpath("//span[@class='regular-price']//span")).getText();
	}

	@Then("cost from list page and detail page should be same.")
	public void cost_from_list_page_and_detail_page_should_be_same() {

		Assert.assertEquals(listPageCost, detailPageCost);
	}

	// TestCase_003 steps*****************************

	@And("User clicks on SONY XPERIA add to cart button")
	public void user_clicks_on_sony_xperia_add_to_cart_button() throws InterruptedException {
		tc3.sonyXAddToCart();
		Thread.sleep(3000);
	}

	@And("change QTY value to {string} and clicks UPDATE button")
	public void change_qty_value_to_and_clicks_update_button(String qty) {

		tc3.editQuantity(qty);
		tc3.update();
	}

	@Then("user should get the error message.")
	public void user_should_get_the_error_message() {
		String errorMsg = tc3.getError();
		Assert.assertTrue(errorMsg.equals("* The maximum quantity allowed for purchase is 500."));
	}

	@When("User clicks on Empty Cart link in the footer of list of all mobiles")
	public void user_clicks_on_empty_cart_link_in_the_footer_of_list_of_all_mobiles() {
		tc3.emptyCart();
	}

	@Then("Cart should be Empty")
	public void cart_should_be_empty() {
		Assert.assertTrue(driver.getPageSource().contains("Shopping Cart is Empty"));
	}

	// TestCase_004 steps*****************************

	@And("user clicks on Add to compare link for {int} mobiles Sony Xperia and IPhone")
	public void user_clicks_on_add_to_compare_link_for_mobiles_sony_xperia_and_i_phone(Integer int1) throws InterruptedException {
		tc4.clicIphoneAddToCpm();
		Thread.sleep(3000);
		tc4.clicSonyXperiaAddToCpm();
		
	}

	@And("click on compare button")
	public void click_on_compare_button() {
		tc4.clickCmpButton();
		
	}

	@Then("pop up window should open and details of {int} products should be there.")
	public void pop_up_window_should_open_and_details_of_products_should_be_there(Integer int1) {
		
		mainHandle=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		List<String> handleList=new ArrayList<String>(handles);
		
		driver.switchTo().window(handleList.get(handleList.size()-1));
		Assert.assertTrue(driver.getPageSource().contains("Compare Products"));
		Assert.assertTrue(driver.getPageSource().contains("Sony Xperia")&& driver.getPageSource().contains("IPhone"));
		
	}

	@And("close the po up window")
	public void close_the_po_up_window() {
		driver.findElement(By.xpath("//button[@title='Close Window']")).click();
		driver.switchTo().window(mainHandle);
	}
	
	// TestCase_005 steps*****************************
	
	@When("user clicks on my account link")
	public void user_clicks_on_my_account_link() {
		tc5=new TestCase_005(driver);
		tc5.clickAddAcc();
		tc5.clickMyAcc();
	    
	}
	@And("clicks create account link and fill user information")
	public void clicks_create_account_link_and_fill_user_information() {
	    tc5.clickCreateAcc();
	    tc5.setFName("");
	    tc5.setFName("AAA");
	    tc5.setLName("BBB");
	    email=randomEmail()+"@gmail.com";
		System.out.println(email);
		tc5.setEmail(email);
		
		tc5.setPwd("abAB@123");
		tc5.setCinfirmPwd("abAB@123");
		
		
	}
	private String randomEmail() {
		
		return RandomString.make(8);
	}

	@And("user clicks on register button")
	public void user_clicks_on_register_button() {
		tc5.clickReg();
	   
	}
	@Then("user Registration should be done")
	public void user_registration_should_be_done() {
		Assert.assertTrue(driver.getPageSource().contains("Thank you for registering with Main Website Store."));
	}
	@When("user clicks on TV menu")
	public void user_clicks_on_tv_menu() {
		tc5.clickTV();
	}
	@And("user adds LG LCD to wishlist")
	public void user_adds_lg_lcd_to_wishlist() {
		tc5.clickLgLcd();
		tc5.clickaddWish();
	}
	@And("user clicks on share wishlist link")
	public void user_clicks_on_share_wishlist_link() {
		tc5.clickShareWL();
	}
	@And("enters email and message and clicks on share wishlist")
	public void enters_email_and_message_and_clicks_on_share_wishlist() {
		tc5.setEmailAddress("anusha.basavaraj28@gmail.com");
		tc5.clickShareEmail();
	}
	@Then("wish list should be shared")
	public void wish_list_should_be_shared() {
		Assert.assertTrue(driver.getPageSource().contains("Your Wishlist has been shared."));
	}
	
	//TestCase_006 steps*****************************
	
	@When("login with email {string} and password {string}")
	public void login_with_email_and_password(String email, String pwd) {
		tc6=new TestCase_006(driver);
		tc6.setEmail(email);
		tc6.setPwd(pwd);
		tc6.clickLogin();
	    
	}
	@When("user clicks on my wishlist link")
	public void user_clicks_on_my_wishlist_link() {
		tc6.clickWishList();
	    
	}
	@When("in the next page clicks ADD to cart link")
	public void in_the_next_page_clicks_add_to_cart_link() {
		tc6.clickAddCart();
	    
	}
	@When("clicks on Proceed to checkout")
	public void clicks_on_proceed_to_checkout() {
	   tc6.clickProceedToCheckOut();
	}
	@When("enters shipping informaion")
	public void enters_shipping_informaion() {
		tc6.setNewAddress("New Address");
		tc6.setAddress("ABC");
		tc6.setCity("NEW YORK");
		tc6.setState("New York");
		tc6.setTelephone("1234567890");
		
	}
	@When("clicks continue")
	public void clicks_continue() {
		tc6.clickContinue();
	    
	}
	@Then("shipping cost should be generTED")
	public void shipping_cost_should_be_gener_ted() {
		String actualShippingCost=driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']//span")).getText();
		String expectedShippingCost="$5.00";
		Assert.assertEquals(expectedShippingCost, actualShippingCost);
	    
	}
	@Then("clicks continue2")
	public void clicks_continue2() {
		tc6.clickContinue2();
	   
	}
	@Then("in payment information select check\\/money order radio button and click continue")
	public void in_payment_information_select_check_money_order_radio_button_and_click_continue() {
		tc6.selectPaymentInfo();
		tc6.clickContinue3();
	   
	}
	@Then("in the total amount shipping cost sholud be added")
	public void in_the_total_amount_shipping_cost_sholud_be_added() {
		String expectedTotalCOst="$620.00";
		String actualTotalCost=driver.findElement(By.xpath("//tr[@class='last']//span")).getText();
		Assert.assertEquals(expectedTotalCOst, actualTotalCost);
	    
	}
	@When("user clicks on place order button")
	public void user_clicks_on_place_order_button() throws InterruptedException {
		tc6.clickPlaceOrder();
		Thread.sleep(3000);
	    
	}
	@Then("order should be placed and orderId should be generated")
	public void order_should_be_placed_and_order_id_should_be_generated() {
	    Assert.assertTrue(driver.getPageSource().contains("Your order has been received."));
	    String orderId=tc6.getOrderId();
	    System.out.println(orderId);
	}


	//TestCase_007 steps*****************************
	
	@Then("user should able to see all the RECENT ORDERS in table and status is pending")
	public void user_should_able_to_see_all_the_recent_orders_in_table_and_status_is_pending() {
	    Assert.assertTrue(driver.getPageSource().contains("Recent Orders"));
	    String status=driver.findElement(By.xpath("//td[@class='status']//em")).getText();
	    Assert.assertTrue(status.equals("Pending"));
	}
	@When("user clicks on Print Order link")
	public void user_clicks_on_print_order_link() {
		tc7=new TestCase_007(driver);
		tc7.clickViewOrder();
		tc7.clickPrintOrder();
	    
	}
	@Then("order should be saved as pdf file.")
	public void order_should_be_saved_as_pdf_file() throws AWTException, InterruptedException {
		
		String mainHandle=driver.getWindowHandle();
		
		Set<String> handles=driver.getWindowHandles();
		List<String> handleList=new ArrayList<String>(handles);
		
		
		
		Robot rb=new Robot();
		rb.delay(3000);
		
		// 5 times tab
				 rb.keyPress(KeyEvent.VK_TAB); 
				 rb.keyRelease(KeyEvent.VK_TAB);
				 rb.delay(2000);
				 rb.keyPress(KeyEvent.VK_TAB); 
				 rb.keyRelease(KeyEvent.VK_TAB);
				 rb.delay(2000);
				 rb.keyPress(KeyEvent.VK_TAB); 
				 rb.keyRelease(KeyEvent.VK_TAB);
				 rb.delay(2000);
				 rb.keyPress(KeyEvent.VK_TAB); 
				 rb.keyRelease(KeyEvent.VK_TAB);
				 rb.delay(2000);
				 rb.keyPress(KeyEvent.VK_TAB); 
				 rb.keyRelease(KeyEvent.VK_TAB);
				 rb.delay(2000);
				 
				 
				 
				 
				// Enter
				rb.keyPress(KeyEvent.VK_ENTER); 
				rb.keyRelease(KeyEvent.VK_ENTER);
				
				rb.delay(2000);
				//Page down
				rb.keyPress(KeyEvent.VK_DOWN); 
				 rb.keyRelease(KeyEvent.VK_DOWN);
				 
				// Enter
					rb.keyPress(KeyEvent.VK_ENTER); 
					rb.keyRelease(KeyEvent.VK_ENTER);
					
					 rb.keyPress(KeyEvent.VK_TAB); 
					 rb.keyRelease(KeyEvent.VK_TAB);
					 rb.delay(2000);
					 
					 rb.keyPress(KeyEvent.VK_TAB); 
					 rb.keyRelease(KeyEvent.VK_TAB);
					 rb.delay(2000);
					 
					 rb.keyPress(KeyEvent.VK_TAB); 
					 rb.keyRelease(KeyEvent.VK_TAB);
					 rb.delay(2000);
					
				 
					 rb.keyPress(KeyEvent.VK_TAB); 
					 rb.keyRelease(KeyEvent.VK_TAB);
					 rb.delay(2000);
				
				
					 rb.keyPress(KeyEvent.VK_TAB); 
					 rb.keyRelease(KeyEvent.VK_TAB);
					 rb.delay(2000);
					 
					 
					// Enter
					    rb.keyPress(KeyEvent.VK_ENTER); 
						rb.keyRelease(KeyEvent.VK_ENTER);
						rb.delay(2000);
						
						// Enter
					    rb.keyPress(KeyEvent.VK_ENTER); 
						rb.keyRelease(KeyEvent.VK_ENTER);
						
						driver.switchTo().window(handleList.get(handleList.size()-1));
						Thread.sleep(3000);
						
						driver.findElement(By.xpath("//button[@title='Close Window']")).click();	
						//Thread.sleep(3000);
						
						driver.switchTo().window(mainHandle);
		
	    
	}
	
	//TestCase_008 steps*****************************
	
	@When("user clicks on Reorder and change QTY to {string} and click update")
	public void user_clicks_on_reorder_and_change_qty_to_and_click_update(String string) {
		
		tc6.clickREOrder();
		tc6.setQTY();
		tc6.clickUpdateBtn();
	    
	}
	@Then("Grand total should be changed.")
	public void grand_total_should_be_changed() {
		
		String expectedGrandTotal="$6,150.00";
		String actualGrandTotal=tc6.getTotalPrice();
		
		Assert.assertEquals(expectedGrandTotal, actualGrandTotal);
	    
	}
	@When("user completes billing and shipping information")
	public void user_completes_billing_and_shipping_information() throws InterruptedException {
		
		tc6.clickProceedToCheckOut();
		tc6.setNewAddress("New Address");
		tc6.setAddress("ABC");
		tc6.setCity("NEW YORK");
		tc6.setState("New York");
		tc6.setTelephone("1234567890");
		tc6.clickContinue();
		tc6.clickContinue2();
		tc6.selectPaymentInfo();
		tc6.clickContinue3();
		tc6.clickPlaceOrder();
		
	    Thread.sleep(3000);
	}
	

	@After
	public void tearDown() {
		driver.close();
	}

}
