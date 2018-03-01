package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	WebDriver drv = null;
	
	@Before public void setUp(){ 
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	      drv = new FirefoxDriver();
	      }
	
	
	@Given("^that I am CallYa Guest user$")
	public void that_I_am_CallYa_Guest_user() throws Throwable {
	    // to go to the meinvodafone site
		//drv.get();
		throw new PendingException();
	}
	
	

	@When("^I choose to top-up my/other person balance online$")
	public void i_choose_to_top_up_my_other_person_balance_online_vodafone_de() throws Throwable {
	    //  to go to topamount page
		//drv.get();
	    throw new PendingException();
	}

	@Then("^Choose Top-up Amount$")
	public void choose_Top_up_Amount() throws Throwable {
	    // locate all elements on top-up page and choose amount
		WebElement card1 = drv.findElement(By.id("card-1"));
		WebElement card2 = drv.findElement(By.id("card-2"));
		WebElement card3 = drv.findElement(By.id("card-3"));
		WebElement card4 = drv.findElement(By.id("card-4"));
		WebElement card1_addition = drv.findElement(By.id("card+"));
		WebElement card1_subtraction = drv.findElement(By.id("card-"));
		WebElement btn_next = drv.findElement(By.id("button-next"));
		card1.click();
		btn_next.click();
	    throw new PendingException();
	}
	@And("^Choose to continue as a guest$")
	public void choose_to_continue_as_a_guest() throws Throwable {
	    // user click on continue as a guest button
		WebElement guest_btn = drv.findElement(By.id("guest-btn"));
		guest_btn.click();
	    throw new PendingException();
	}
	
	@And("^Enter The Personal Data$")
	public void enter_The_Personal_Data() throws Throwable {
	    // user enters receiver MSISDN and his E-mail
		WebElement MSISDN_txtbox = drv.findElement(By.id("MSISDN-txt"));
		MSISDN_txtbox.sendKeys("01010101");
		WebElement Email_txtbox = drv.findElement(By.id("email-textbox"));
		Email_txtbox.sendKeys("mario.nady07@gmail.com");
	    throw new PendingException();
	}

	@And("^Choose Payment Method credit card$")
	public void choose_Payment_Method_credit_card() throws Throwable {
	    // user choose credit card payment method
		WebElement credit_radiobtn = drv.findElement(By.id("credit-radio"));
		credit_radiobtn.click();
		wait();
		WebElement creditno_txtbox = drv.findElement(By.id("credit-number"));
		creditno_txtbox.sendKeys("1111111111111111");
		WebElement expirydate_drpdown = drv.findElement(By.id("expiry-date"));
		expirydate_drpdown.click(); // choose month and year from drop down list
		WebElement CVC_txtbox = drv.findElement(By.id("CVC"));
		CVC_txtbox.sendKeys("1234");
		WebElement creditOwnerName_txtbox = drv.findElement(By.id("owner-name"));
		creditOwnerName_txtbox.sendKeys("Mario");
	    throw new PendingException();
	}

	@And("^complete Review step$")
	public void complete_Review_step() throws Throwable {
	    // user review data and click on submit
		WebElement checkout_btn = drv.findElement(By.id("checkout"));
		checkout_btn.click();
	    throw new PendingException();
	}

	@Then("^I shall view  Confirmation page$")
	public void i_shall_view_Confirmation_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
