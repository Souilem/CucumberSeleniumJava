package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
	private WebDriver driver;

	/* STEP: User Login */
	/* log-in */
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		System.out.println("step0 browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/log-in");
		driver.manage().window().maximize();
	}

	@When("I enter my username {string} and password {string}")
	public void i_enter_my_username_and_password(String username, String password) throws InterruptedException {
		WebElement usernameInput = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
		usernameInput.sendKeys(username);
		WebElement passwordInput = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		passwordInput.sendKeys(password);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		Thread.sleep(2000);
	}

	@Then("I should be redirected to the home page")
	public void i_should_be_redirected_to_the_home_page() throws InterruptedException {
		driver.navigate().to("http://localhost:4200/products");
		Thread.sleep(2000);
	}

	@Then("I should see a welcome message with the username {string}")
	public void i_should_see_a_welcome_message_with_the_username(String username) throws InterruptedException {
		WebElement welcomeMessage = driver.findElement(By.name("username"));
		String actualUsername = welcomeMessage.getText().trim();
		Assert.assertEquals(username, actualUsername);
		Thread.sleep(2000);
	}

	@When("I click on the logout button")
	public void i_click_on_the_logout_button() throws InterruptedException {
		WebElement logoutButton = driver.findElement(By.name("logout"));
		logoutButton.click();
		Thread.sleep(2000);
	}

	@Then("I should not see a welcome message with the username {string}")
	public void i_should_not_see_a_welcome_message_with_the_username(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebElement welcomeMessage = null;
		try {
			welcomeMessage = driver.findElement(By.name("username"));
		} catch (NoSuchElementException e) {
			// Handle the case where the element is not found (user is logged out)
		}

		Assert.assertNull(welcomeMessage);
	}
/*
	@After
	public void tearDown() {
		driver.quit();
	}
*/
	/* Invalid user/pwd */
	@When("I enter an invalid username {string} and password {string}")
	public void i_enter_an_invalid_username_and_password(String invalidUsername, String invalidPassword)
			throws InterruptedException {
		WebElement usernameInput = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
		usernameInput.sendKeys(invalidUsername);
		WebElement passwordInput = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		passwordInput.sendKeys(invalidPassword);
		Thread.sleep(2000);
	}

	@Then("I should see an error message")
	public void i_should_see_an_error_message() throws InterruptedException {
		WebElement errorMessage = driver.findElement(By.tagName("p"));
		String expectedErrorMessage = "You don't have permission to access this page OR Your user doesn't exist !";
		String actualErrorMessage = errorMessage.getText();
		assert actualErrorMessage.contains(expectedErrorMessage);
		assert errorMessage.isDisplayed();
		Thread.sleep(2000);
	}

	@Then("I should remain on the login page")
	public void i_should_remain_on_the_login_page() throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://localhost:4200/unauthorized", currentUrl);
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	/* STEP: FORGOT PASSWORD */
	@Given("I am on the login page, I forgot my password")
	public void i_am_on_the_login_page_i_forgot_my_password() {
		System.out.println("step0 browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/log-in");
		driver.manage().window().maximize();
	}

	@When("I enter an invalid username {string} or password {string}")
	public void i_enter_an_invalid_username_or_password(String string, String string2) throws InterruptedException {
		WebElement usernameInput = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
		usernameInput.sendKeys(string);
		WebElement passwordInput = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		passwordInput.sendKeys(string2);
		Thread.sleep(2000);
	}

	@When("I click on the Forgot password button")
	public void i_click_on_the_forgot_password_button() throws InterruptedException {
		Thread.sleep(2000);
		WebElement forgotPwdButton = driver.findElement(By.name("forgotPwd"));
		forgotPwdButton.click();
		Thread.sleep(2000);
	}

	@Then("I shoud be redirected to the Password recovery Forms page")
	public void i_shoud_be_redirected_to_the_password_recovery_forms_page() throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://localhost:4200/recover", currentUrl);
		Thread.sleep(4000);
	}

	@Then("enter a valid email {string}")
	public void enter_a_valid_email(String string) {
		WebElement emailInput = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		emailInput.sendKeys(string);
	}

	@Then("I click on the recover button")
	public void i_click_on_the_recover_button() throws InterruptedException {
		Thread.sleep(2000);
		WebElement recoverButton = driver.findElement(By.name("recover"));
		recoverButton.click();
		Thread.sleep(2000);
	}

	@Then("I should be redirected to the Password recovery page")
	public void i_should_be_redirected_to_the_password_recovery_page() throws InterruptedException {
		driver.navigate().to("http://localhost:4200/pwdrecover");
		Thread.sleep(2000);
	}

	@Then("I enter a newPassword {string} and confirmedNewPassword {string}")
	public void i_enter_a_new_password_and_confirmed_new_password(String string, String string2)
			throws InterruptedException {
		WebElement pwdInput = driver.findElement(By.xpath("//input[@formcontrolname='newPassword']"));
		pwdInput.sendKeys(string);
		WebElement cfpwdInput = driver.findElement(By.xpath("//input[@formcontrolname='confirmNewPassword']"));
		cfpwdInput.sendKeys(string2);
		Thread.sleep(2000);
	}

	@Then("I click on the submit button")
	public void i_click_on_the_submit_button() throws InterruptedException {
		WebElement forgotPwdButton = driver.findElement(By.name("submitNewPwd"));
		forgotPwdButton.click();
		Thread.sleep(2000);
	}

	@Then("I should see a notification Password updated successfully")
	public void i_should_see_a_notification_password_updated_successfully() throws InterruptedException {
		driver.navigate().to("http://localhost:4200/log-in");
		Thread.sleep(2000);
	}

	@Then("be redirected to the log-in page")
	public void be_redirected_to_the_log_in_page() throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://localhost:4200/log-in", currentUrl);
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
