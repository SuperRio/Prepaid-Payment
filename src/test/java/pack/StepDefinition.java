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

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
		// ======================================================================
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("139.7.95.172:8080");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities dc = new DesiredCapabilities();
		options.setCapability("proxy", proxy);
		//==============================================================
		String driverPath = "C:\\drive\\";
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
		drv = new ChromeDriver();	
	}
	
	
	
	@Given("^that I am CallYa Guest user$")
	public void that_I_am_CallYa_Guest_user() throws InterruptedException, AWTException{
		
		//drv.get("https://zuhauseplus.vodafone.de/kombi-pakete/");
		//drv.manage().window().maximize();
		//drv.manage().addCookie(new Cookie("simplicity-draft","feature-set-payment-provider",".vodafone.de","/",null));
		// ========================================================================
		 
		 //to go to the ST cookie switcher
		 drv.get("https://simplicity.wf-de.vodafone.com/simplicity/pages/helpers/subpages/cookie-switcher.html");
		 drv.manage().window().maximize();
		 //to go to SIT cookie switcher
		 //drv.get("https://www.vodafone.de/simplicity/pages/helpers/subpages/cookie-switcher.html");
		 drv.manage().window().maximize();		
		 JavascriptExecutor js = (JavascriptExecutor) drv;
		 WebElement element = drv.findElement(By.xpath("//select[@id='dropDownSwitcher']"));
		 js.executeScript("arguments[0].setAttribute('style', 'display: true;')",element);
		 Select ss = new Select(drv.findElement(By.xpath("//select[@id='dropDownSwitcher']")));
		 ss.selectByValue("feature-set-payment-provider");
		 WebElement development = drv.findElement(By.xpath("//a[@data-mode='dev']"));
		 development.click();
		// =======================================================================
	}

	@When("^I choose to top-up my/other person balance online$")
	public void i_choose_to_top_up_my_other_person_balance_online_vodafone_de()
			throws Throwable {
		// to go to topamount page in ST
		 drv.get("https://simplicity.wf-de.vodafone.com/meinvodafone/account/payment");
		
		// to go to topamount page in SIT
		//drv.get("https://www.vodafone.de/meinvodafone/account/payment/amount");
		
		//throw new PendingException();
	}

	@Then("^Choose Top-up Amount$")
	public void choose_Top_up_Amount() throws Throwable {
		// locate all elements on top-up page and choose amount
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement mydiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='topup0']")));
		mydiv.click();		
		drv.findElement(By.xpath("//*[@id='btn-zur-kasse']")).click();
		System.out.println("Test Case 1 Passed");
		//throw new PendingException();
	}
	
	
	@Then("^Choose Large amount to Top-up$")
	public void choose_Large_amount_to_Top_up() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement dim = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='topup0']")));
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
		System.out.println("Test Case 2 Passed");
		//throw new PendingException();
	}

	@And("^Choose to continue as a guest$")
	public void choose_to_continue_as_a_guest() throws Throwable {
		// user click on continue as a guest button
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement guestBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='guestButtonId']")));
		guestBtn.click();
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
		WebElement checkout_btn = drv.findElement(By.xpath("//button[@class='btn btn-em btn-sml']"));
		checkout_btn.click();
		//throw new PendingException();
	}

	@And("^complete Review step$")
	public void complete_Review_step() throws Throwable {
		// user review data and click on submit

		Thread.sleep(2000);
		WebElement checkout_btn1 = drv.findElement(By.xpath("//button[@class='btn btn-em btn-sml']"));
		checkout_btn1.click();
		Thread.sleep(2000);
		WebElement checkout_btn = drv.findElement(By.xpath("//button[@class='btn btn-sml']"));
		checkout_btn.click();
		// throw new PendingException();
	}

	@Then("^I shall view  Confirmation page$")
	public void i_shall_view_Confirmation_page() throws Throwable {
		// End of transaction
		System.out.println(" End of text :D ");
		//throw new PendingException();
	}



	@Then("^Choose VARIOUS amount to Top-up$")
	public void chooseVARIOUSAmountToTopUp() throws Throwable {
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement card0 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='topup0']")));
		WebElement card1 = drv.findElement(By.xpath("//a[@id='topup1']"));
		WebElement card2 = drv.findElement(By.xpath("//a[@id='topup2']"));
		WebElement card3 = drv.findElement(By.xpath("//a[@id='topup3']"));
		//WebElement total = drv.findElement(By.xpath("//div[@class='total-price']/following::div[@class='value']"));
		for(int i=0; i<100; i++)
		{
			card0.click();
			card1.click();
			card2.click();
			card3.click();
			//String total1 = total.getText();
			//System.out.println(total1);
			String clas = card3.getAttribute("class");
			if(clas.equals("card dimmed"))
				{
				System.out.println(clas);
				System.out.println("Max Reached");
				break;
				}
		}
		drv.findElement(By.xpath("//*[@id='btn-zur-kasse']")).click();
		System.out.println("Test Case 3 Passed");
		//throw new PendingException();
	}
	

	@Then("^addAndRemove amounts to Top-up$")
	public void addandremoveAmountsToTopUp() throws Throwable {
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement card0 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='topup0']")));
		WebElement card1 = drv.findElement(By.xpath("//a[@id='topup1']"));
		WebElement card2 = drv.findElement(By.xpath("//a[@id='topup2']"));
		WebElement card3 = drv.findElement(By.xpath("//a[@id='topup3']"));
		WebElement decrement0 = drv.findElement(By.xpath("//a[@id='decrement0']"));
		WebElement decrement1 = drv.findElement(By.xpath("//a[@id='decrement1']"));
		WebElement decrement2 = drv.findElement(By.xpath("//a[@id='decrement2']"));
		WebElement decrement3 = drv.findElement(By.xpath("//a[@id='decrement3']"));
			card0.click();
			card1.click();
			card2.click();
			card3.click();
			decrement0.click();
			decrement1.click();
			decrement2.click();
			decrement3.click();
			card3.click();
			card2.click();
			card1.click();
			card0.click();
			drv.findElement(By.xpath("//*[@id='btn-zur-kasse']")).click();
			System.out.println("Test Case 4 Passed");
	//	throw new PendingException();
	}



	@And("^Enter The Personal Data to disable PayPal$")
	public void enterThePersonalDataToDisablePayPal() throws Throwable {
		
		WebElement MSISDN_txtbox = drv.findElement(By.xpath("//input[@id='phoneField']"));
		MSISDN_txtbox.sendKeys("11111111");
		WebElement Email_txtbox = drv.findElement(By.xpath("//input[@id='emailField']"));
		Email_txtbox.sendKeys("mario.nady07@gmail.com");
		WebElement btn_submit1 = drv.findElement(By.xpath("//button[@class='btn btn-em btn-sml']"));
		btn_submit1.click();
		//throw new PendingException();
	}



	@And("^Check Paypal when being Disable$")
	public void checkPaypalWhenBeingDisable() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement Paypal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fm-data disabled']")));
		String xy = Paypal.getAttribute("class");
		if(xy.contains("disabled"))
		{
			System.out.println("Test Case 5 Passed Plus Paypal radio button is highlighted as it's disabled");
		}
		if (drv instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)drv).executeScript("arguments[0].style.border='3px solid red'", Paypal);
	    }
	    return;
		
		
		
		//throw new PendingException();
	}

	@And("^login with user has from (\\d+) to (\\d+) MSISDNs$")
	public void login_with_user_has_from_to_MSISDNs(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(drv, 10);

		WebElement lgnbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='LoginButtonId']")));
		lgnbtn.click();
		WebElement usernameBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtUsername']")));
		WebElement passwordBtn = drv.findElement(By.xpath("//input[@id='txtPassword']"));
		usernameBtn.sendKeys("PD.paul-8-with-default-out");
		passwordBtn.sendKeys("PD.paul-8-with-default-out");
		WebElement loginbtn = drv.findElement(By.xpath("//button[@class='btn login-btn']"));
		loginbtn.click();
	    //throw new PendingException();
	}

	
	@Then("^Check user's MSISDNs for different error messages$")
	public void check_user_s_MSISDNs_for_different_error_messages() throws Throwable {
	    // Check back end error messages
		JavascriptExecutor jse = (JavascriptExecutor)drv;
		//jse.executeScript("window.scrollBy(0,250)", "");
		WebDriverWait wait = new WebDriverWait(drv, 20);
		WebElement btnCloseMsisdn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='toggleBtn']")));
		jse.executeScript("arguments[0].scrollIntoView(true);",btnCloseMsisdn);
		Thread.sleep(2000);
		btnCloseMsisdn.click();
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebElement radio0 = drv.findElement(By.xpath("//label[@for='subscriptions0']"));
		radio0.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//jse.executeScript("window.scrollBy(0,250)", "");
		//WebElement btnsubmit = drv.findElement(By.xpath("//button[@type='submit']"));
		//btnsubmit.click();
		Thread.sleep(1000);
		String expectedMessage = "Ihr Auflade-Betrag ist höher als der Betrag, den Sie monatlich online auf diese Rufnummer aufladen können. Geben Sie einen kleineren Betrag an oder laden Sie anders auf, z. B. mit Guthabenkarte oder im Vodafone-Shop.";
		String txt = drv.findElement(By.xpath("//div[@class='alert-content no-head']")).getText();
		Assert.assertTrue("Your error message", txt.contains(expectedMessage));

		WebElement radio1 = drv.findElement(By.xpath("//label[@for='subscriptions1']"));
		radio1.click();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		String expectedMessage1 = "Diese CallYa-Rufnummer ist leider gesperrt.";
		String txt1 = drv.findElement(By.xpath("//div[@class='alert-content no-head']")).getText();
		Assert.assertTrue("Your error message", txt1.contains(expectedMessage1));
		
		WebElement radio2 = drv.findElement(By.xpath("//label[@for='subscriptions2']"));
		radio2.click();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		String expectedMessage11 = "Eine Aufladung dieser Rufnummer ist aktuell noch in Arbeit. Warten Sie bitte, bis der Vorgang abgeschlossen ist, oder laden Sie eine andere Rufnummer auf.";
		String txt2 = drv.findElement(By.xpath("//div[@class='alert-content no-head']")).getText();
		Assert.assertTrue("Your error message", txt2.contains(expectedMessage11));
		
		
	    //throw new PendingException();
		
	}



	@And("^Enter The Valid Personal Data$")
	public void enterTheValidPersonalData() throws Throwable {
		// Valid data for SIT environment
		WebElement MSISDN_txtbox = drv.findElement(By.xpath("//input[@id='phoneField']"));
		MSISDN_txtbox.sendKeys("015226175239");
		WebElement Email_txtbox = drv.findElement(By.xpath("//input[@id='emailField']"));
		Email_txtbox.sendKeys("mario-payer@gmail.com");
		Thread.sleep(2000);
		WebElement btn_submit1 = drv.findElement(By.xpath("//button[@class='btn btn-em btn-sml']"));
		btn_submit1.click();
		//throw new PendingException();
	}



	@And("^Choose PayPal Payment Method$")
	public void choosePayPalPaymentMethod() throws Throwable {
		// valid data for SIT environment
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(drv, 10);
		WebElement mydiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='1']")));
		mydiv.click();
		// throw new PendingException();
	}



	@And("^login with valid PayPal account and submit the transaction$")
	public void loginWithValidPayPalAccountAndSubmitTheTransaction() throws Throwable {
		// valid data for SIT environment
		WebDriverWait wait = new WebDriverWait(drv, 20);
		WebElement mydiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		mydiv.sendKeys("TEST@1234");
		drv.findElement(By.xpath("//button[@id='btnLogin']")).click();
		WebDriverWait wait1 = new WebDriverWait(drv, 20);
		WebElement mydiv1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Jetzt zahlen']")));
		mydiv1.click();
		//throw new PendingException();
	}

}
