package com.pageObjectLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.GenericLibrary.*;
import com.GenericLibrary.WebDriverCommonLib;

public class HomePage extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	// ----------------------UI Elements----------------------/
	
	//--------For UserName----------------//
	@FindBy(how = How.XPATH, using = "//span[text()='PIM']")
	private WebElement PIM_Button;

		// ----------------------Basic Functions----------------------//

	// ---For ClickOnMenuItem---//
	public void ClickPIM_Module() {
		
		
			PIM_Button.click();
			
		}

	// ---For ClickOnSubMenuItem---//
	
			

	
	

	




}
