package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
	private WebDriver driver;
	
	@When("I click on the register button")
	public void i_click_on_the_register_button() throws InterruptedException {
		System.out.println("step0 browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/log-in");
		driver.manage().window().maximize();
		
		WebElement loginButton = driver.findElement(By.name("register"));
		loginButton.click();
		Thread.sleep(2000);   
	}

	@Then("I should be redirected to the register page")
	public void i_should_be_redirected_to_the_register_page() throws InterruptedException {
	    driver.navigate().to("http://localhost:4200/register");
		Thread.sleep(2000);
	}

	@When("I enter valid registration details")
	public void i_enter_valid_registration_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should be redirected to the login page")
	public void i_should_be_redirected_to_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see a success message")
	public void i_should_see_a_success_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("I am on the registration page")
	public void i_am_on_the_registration_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter incomplete registration details")
	public void i_enter_incomplete_registration_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see error messages for the missing information")
	public void i_should_see_error_messages_for_the_missing_information() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should remain on the registration page")
	public void i_should_remain_on_the_registration_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
