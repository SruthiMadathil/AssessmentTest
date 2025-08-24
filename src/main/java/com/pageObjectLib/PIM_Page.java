package com.pageObjectLib;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.GenericLibrary.Constants;
import com.pageObjectLib.*;

import junit.framework.Assert;

import com.GenericLibrary.*;
public class PIM_Page extends WebDriverCommonLib {
	WebDriver driver;

	// ----------------------Constructor----------------------//

	public PIM_Page(WebDriver driver) {
		this.driver = driver;

	}

	// ----------------------UI Elements----------------------/
	
	//--------For UserName----------------//
	@FindBy(how = How.XPATH, using = "//a[text()='Add Employee']")
	private WebElement Add_Employee;
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	private WebElement FirstName;
	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	private WebElement LastrName;
	@FindBy(how = How.XPATH, using = "//input[contains(@class,'oxd-input oxd-input--active')])[5]")
	private WebElement EmployeeId;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']/../span")
	private WebElement create_LoginCheck;
		// ----------------------Basic Functions----------------------//

	// ---For ClickOnMenuItem---//
	public void ClickAddEmployee() {
			Add_Employee.click();
		}
  public void EnterFirstName(String first_name)
{
	entervalue(first_name,FirstName);
	
}
  public void EnterLastName(String last_name)
  {
  	entervalue(last_name,LastrName);
  	
  }
 
  public void ClickLogincheck() {
		create_LoginCheck.click();
	}
}
