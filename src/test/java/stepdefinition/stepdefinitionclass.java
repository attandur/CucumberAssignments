package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.hooksclass;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;  

public class stepdefinitionclass {
	
	WebDriver driver = hooksclass.driver;
	
	@Given("user navigates to Elearning portal")
	public void user_navigates_to_Elearning_portal() throws InterruptedException {
	   System.out.println("user is navigating to the Learning portal");
	   driver.get("http://elearningm1.upskills.in/index.php");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
	}
	
	@When("user clicks on  Sign up!")
	public void user_clicks_on_SignUp() {
		driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]")).click();
	   
	}

	@Then("validate Register page is displayed")
	public void Register_Page_Loaded() {
		Assert.assertEquals("Registration",driver.findElement(By.tagName("h2")).getText());
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
	}

	
	@When("user enters Registration details {string} FirstName {string} LastName {string} Email {string} UserName {string} Password {string} ConfirmPassword and submit form")
	public void user_enter_registration_details(String FirstName, String LastName, String Email, String UserName, String Password, String ConfirmPassword) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
	    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
	    driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
	    driver.findElement(By.id("username")).sendKeys(UserName);
	    driver.findElement(By.id("pass1")).sendKeys(Password);
	    driver.findElement(By.id("pass2")).sendKeys(ConfirmPassword);
	    driver.findElement(By.name("submit")).click();
	    
	}
	
	@Then("validate Registration complete message")
	public void validate_Register_Complete() {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//p[contains(text(),'Dear')]")).isDisplayed();
		driver.findElement(By.name("next")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(50000,TimeUnit.SECONDS) ;
	    driver.quit();
	}

	@When("user enters {string} UserName and {string} Password and Login")
	public void Login_with_credentials(String UserName, String Password) {
		driver.findElement(By.id("login")).sendKeys(UserName.trim());
		driver.findElement(By.id("password")).sendKeys(Password.trim());
		driver.findElement(By.name("submitAuth")).click();
	}
	
	@Then("validate that Profile is displayed")
	public void validate_Profile_Displayed() {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//ul[@role='menu']//a[contains(text(),'Profile')]")).isDisplayed();
		driver.findElement(By.xpath("//ul[@role='menu']//a[contains(text(),'Inbox')]")).isDisplayed();
	}
	
	@When("Click on Inbox and validate that Inbox page is opened")
	public void Click_and_Validate_InboxPage() {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//img[@title='Inbox']")).click();
		driver.findElement(By.xpath("//a/img[@title='Compose message']")).isDisplayed();
		driver.findElement(By.xpath("//a/img[@title='Outbox']")).isDisplayed();
	}
	
	@Then("Compose email and Send")
	public void Compose_Email_and_Send() throws InterruptedException {
		driver.findElement(By.xpath("//img[@title='Compose message']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Please select an option']")).sendKeys("Aat");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@role='treeitem'])[1]")).click();
		driver.findElement(By.name("title")).sendKeys("Sending Mail");
		driver.findElement(By.name("compose")).click();
	}

	@And("Validate Messgae has been sent to {string} FirstName and {string} LastName")
	public void Email_Success_Maessage(String FirstName, String LastName) {
		driver.findElement(By.xpath("//div[contains(text(),\"The message has been sent\")]")).getText().contains(FirstName);
		driver.findElement(By.xpath("//div[contains(text(),\"The message has been sent\")]")).getText().contains(LastName);
	    driver.quit();
	}
}
