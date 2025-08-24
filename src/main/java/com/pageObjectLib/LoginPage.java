package com.pageObjectLib;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.GenericLibrary.Constants;
import com.pageObjectLib.*;
import com.GenericLibrary.*;


public class LoginPage extends WebDriverCommonLib {
	WebDriver driver;
	WebDriverCommonLib wcl = new WebDriverCommonLib();

	// ----------------------Constructor----------------------//
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------------UI Elements----------------------//
	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	private WebElement UserName;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement Password;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement LoginButton;
	public void login() {
		try {
			wcl.waitforpageload();
			
			entervalue(Constants.username, UserName);
			Thread.sleep(1000);
				entervalue(Constants.Password, Password);
				LoginButton.click();
				logger.info("Logged in Successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Login");
			logger.error("Login Failed " + e.getMessage());
		}

	}
	

}
