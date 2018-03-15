package pack;

import net.masterthought.cucumber.json.Element;

import org.apache.velocity.runtime.directive.Break;
import org.openqa.selenium.Proxy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;		







import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	WebDriver drv = null;
	
	@Before
	public void setUp() {
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("139.7.95.172:8080");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities dc = new DesiredCapabilities();
		options.setCapability("proxy", proxy);
		String driverPath = "C:\\drive\\";
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
		drv = new ChromeDriver();	
	}

	@Given("^that I am CallYa Guest user$")
	public void that_I_am_CallYa_Guest_user() throws InterruptedException, AWTException{
		// to go to the ST cookie switcher
		drv.get("https://simplicity.wf-de.vodafone.com/simplicity/pages/helpers/subpages/cookie-switcher.html");
		// to go to SIT cookie switcher
		//drv.get("https://eweb8.vfd2-testnet.de/simplicity/pages/helpers/subpages/cookie-switcher.html");
	
		drv.manage().window().maximize();		
		JavascriptExecutor js = (JavascriptExecutor) drv;
		WebElement element = drv.findElement(By.xpath("//select[@style='display: none;']"));
		js.executeScript("arguments[0].setAttribute('style', 'display: true;')",element);
		Select ss = new Select(drv.findElement(By.xpath("//select[@id='dropDownSwitcher']")));
		ss.selectByValue("feature-set-payment-provider");
		WebElement development = drv.findElement(By.xpath("//a[@data-mode='dev']"));
		development.click();		
	}

	@When("^I choose to top-up my/other person balance online$")
	public void i_choose_to_top_up_my_other_person_balance_online_vodafone_de()
			throws Throwable {
		// to go to topamount page
		drv.get("https://simplicity.wf-de.vodafone.com/meinvodafone/account/payment");
		//throw new PendingException();
	}

	@Then("^Choose Top-up Amount$")
	public void choose_Top_up_Amount() throws Throwable {
		// locate all elements on top-up page and choose amount
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement mydiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='topup0']")));
		mydiv.click();		
		drv.findElement(By.xpath("//*[@id='btn-zur-kasse']")).click();
		//throw new PendingException();
	}
	
	
	@Then("^Choose Large amount to Top-up$")
	public void choose_Large_amount_to_Top_up() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement dim = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='topup0']")));
		for(int i=0; i<100; i++)
		{
			dim.click();
			String clas = dim.getAttribute("class");
			if(clas.equals("card dimmed"))
				{
				System.out.println("Max Reached");
				break;
				}
		}
		drv.findElement(By.xpath("//*[@id='btn-zur-kasse']")).click();
		//throw new PendingException();
	}

	@And("^Choose to continue as a guest$")
	public void choose_to_continue_as_a_guest() throws Throwable {
		// user click on continue as a guest button
		drv.findElement(By.id("guestButtonId")).click();
		//throw new PendingException();
	}

	@And("^Enter The Personal Data$")
	public void enter_The_Personal_Data() throws Throwable {
		// user enters receiver MSISDN and his E-mail
		WebElement MSISDN_txtbox = drv.findElement(By.xpath("//input[@id='phoneField']"));
		MSISDN_txtbox.sendKeys("66666666");
		WebElement Email_txtbox = drv.findElement(By.xpath("//input[@id='emailField']"));
		Email_txtbox.sendKeys("mario.nady07@gmail.com");
		WebElement btn_submit1 = drv.findElement(By.xpath("//button[@class='btn btn-em btn-sml']"));
		btn_submit1.click();
		//throw new PendingException();
	}

	@And("^Choose Payment Method credit card$")
	public void choose_Payment_Method_credit_card() throws Throwable {
		// user choose credit card payment method
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement mydiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='0']")));
		mydiv.click();
		WebElement crdt_no = drv.findElement(By.id("cardNumber"));
		crdt_no.sendKeys("1234567812345678");
		Select ss = new Select(drv.findElement(By.xpath("//select[@id='month-chooser']")));
		ss.selectByValue("4");
		Select sss = new Select(drv.findElement(By.xpath("//select[@id='years-chooser']")));
		sss.selectByValue("2024");
		WebElement crdt_CVC = drv.findElement(By.xpath("//input[@id='cvc']"));
		crdt_CVC.sendKeys("1234");
		WebElement crdt_name = drv.findElement(By.xpath("//input[@id='name']"));
		crdt_name.sendKeys("MARIO");
		JavascriptExecutor js = (JavascriptExecutor) drv;
		js.executeScript("alert('Waiting @AliAbdallah to finish Review step');");
		 
		//credit_radiobtn.click();
		//throw new PendingException();
	}

	@And("^complete Review step$")
	public void complete_Review_step() throws Throwable {
		// user review data and click on submit
		//WebElement checkout_btn = drv.findElement(By.id("checkout"));
		//checkout_btn.click();
		throw new PendingException();
	}

	@Then("^I shall view  Confirmation page$")
	public void i_shall_view_Confirmation_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
