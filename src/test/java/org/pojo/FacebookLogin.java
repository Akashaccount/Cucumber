package org.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLogin extends org.helper.BaseClass{

	
	
	public FacebookLogin() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement txtusername;

	@FindBy(name="pass")
	private WebElement txtpassword;
	
	@FindBy(name="login")
	private WebElement loginbtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
}
