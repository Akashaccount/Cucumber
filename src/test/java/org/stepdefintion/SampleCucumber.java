package org.stepdefintion;

import org.helper.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pojo.FacebookLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleCucumber extends BaseClass {
	WebDriver Driver;
	
	@When("user have to enter valid {string} and {string}")
	public void user_have_to_enter_valid_and(String string, String string2) {
		Driver.findElement(By.name("email")).sendKeys(string);
		Driver.findElement(By.id("pass")).sendKeys(string2);
	}

	
	@Given("User have to enter fb Login page")
	public void user_have_to_enter_fb_Login_page() {
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://www.facebook.com/");
	}
	@When("user have to enter valid Email and Password")
	public void user_have_to_enter_valid_Email_and_Password() {

	}
	
	@When("User have to clig login button")
	public void user_have_to_clig_login_button() {
		Driver.findElement(By.name("login")).click();
	}

	@Then("User have to be in invalid Credentials page")
	public void user_have_to_be_in_invalid_Credentials_page() {
		String url = Driver.getCurrentUrl();
		
		System.out.println(url);
		}
	@When("User have to click login button")
	public void user_have_to_click_login_button() {
		Driver.findElement(By.name("login")).click();
	}

	@When("user have to enter Invalid Email and Password")
	public void user_have_to_enter_Invalid_Email_and_Password() {
		 FacebookLogin f = new FacebookLogin();
		 WebElement txtuser = Driver.findElement(By.name("email"));
		 fillTextBox(txtuser, "9789411120");
		 fillTextBox(f.getTxtpassword(), "Akash@123456");
		
	}
	@Given("Maximize Browser Web page")
	public void maximize_Browser_Web_page() {
	    Driver.manage().window().maximize();
	}
	
	@Given("User have to Click on Forgotten Password")
	public void user_have_to_Click_on_Forgotten_Password() throws InterruptedException {
			Driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
			Thread.sleep(5000);
	}

	@When("User have to Enter Valid Mail Address")
	public void user_have_to_Enter_Valid_Mail_Address() {
		Driver.findElement(By.xpath("//input[@placeholder='Email address or mobile number']")).sendKeys("9789411120");
		
		Driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("Message Should Display OTP Sent")
	public void message_Should_Display_OTP_Sent() {
		WebElement Text = Driver.findElement(By.xpath(("//h2[text()='Identify your account'])[2]")));
		String text2 = Text.getText();
		if (text2.equals("Identify your account")) {
			System.out.println("Pass");
			}
		System.out.println("Not Pass");
		System.out.println("Sucuessfully Completed Program");
	}


	}


