package com.GenericLibrary;

import java.io.File;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
public class WebDriverCommonLib extends Browser {

	public static String data;
	protected static Select s;
	public static String parentWindow = null;
	public Alert alt;

	public static String output;
	public static String value;
	public void waitforpageload() {
		try {
			logger.info("Waiting for page to load");
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			logger.info("page to load completed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Message: "+ e.getMessage());
		}
	}
	public void waitforalert()
	{
		logger.info("Waiting for alert");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		logger.info("alert got");
	}
	
	// Method to wait for alert
    public Alert waitForAlert(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.alertIsPresent());
    }
	
	// Wait Statement to wait still Element to be loaded
	public static void waitForElementToBePresent(WebElement element) 
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
		
				logger.info("Waiting for Element Present");
				WebDriverWait wait1 = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(element));
				logger.info("Completed Waiting for Element Present");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ast.assertTrue(false, "Message: "+ e.getMessage());
			}
		
	}

	// ---Accept alert-----//
	public void acceptAlert() {
		try {
			alt = driver.switchTo().alert();
				alt.accept();
				logger.info("Alert Accepted");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to accept Alert Message");
		}

	}

	// ---Alert Message-----//
	public String getAlertmsg() {
		try {
			alt = driver.switchTo().alert();
			alt.getText();
			logger.info("Alert Message " + alt.getText());
				
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Retrive Alert Message");
		}
		return alt.getText();
	}

	// ---Dismiss alert-----//
	public void dismissAlert() {
		try {
			alt = driver.switchTo().alert();
				alt.dismiss();
				logger.info("Alert Dismissed");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to dismiss Alert Message");
		}
	}

	// ----------Capture Image----------------------//

	// ---Capture Full Screen image----//
	public static void Capture(ITestResult result, String filename) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./" + filename + "/" + result.getName() + ".png"));
			logger.info("Testcase failed and screenshot taken");
		} catch (Exception e) {
			ast.assertTrue(false, "Unable to Take Element ScreenShot");
			logger.error("Unable to Take ScreenShot " + e.getMessage());
		}

	}

	// ---Capture Element image----//
	public static void Captureelement(WebElement element) {
		Screenshot screenshot = new AShot().takeScreenshot(driver, element);
		try {
			ImageIO.write(screenshot.getImage(), "PNG",
					new File(System.getProperty("user.dir") + "\\ErrorScreenshots\\ElementScreenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Take Element ScreenShot");
			logger.error("Unable to Take ScreenShot " + e.getMessage());
		}
	}

	public static void selectByTxt(WebElement element, String text) {
		try {
			waitForElementToBePresent(element);
			s = new Select(element);
			s.selectByVisibleText(text);
			logger.info("Selected Dropdown by Text " + text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select Dropdown " + text);
			logger.error("Unable to Select Dropdown " + e.getMessage());
		}
	}

	public static void selectDrpdwnByTxt(WebElement element, String text) {
		try {
			waitForElementToBePresent(element);
			Select sel = new Select(element);
			List<WebElement> dropdown = sel.getOptions();
			for (int i = 0; i < dropdown.size(); i++) {
				String drop_down_values = dropdown.get(i).getText().trim();
				if (drop_down_values.contains(text)) {
					sel.selectByVisibleText(text);
					logger.info("Selected Dropdown by Visible Text " + text);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select Dropdown " + text);
			logger.error("Unable to Select Dropdown " + e.getMessage());
		}
	}
	public static void selectDrpdwnByIndex(WebElement element, int index) {
		try {
			waitForElementToBePresent(element);
			s = new Select(element);
			s.selectByIndex(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select Dropdown " + index);
			logger.error("Unable to Select Dropdown " + e.getMessage());
		}
	}

	public void selectDrpdwnByValue(WebElement element, String value) {
		try {
			waitForElementToBePresent(element);
			Select sel = new Select(element);
			List<WebElement> dropdown = sel.getOptions();
			for (int i = 0; i < dropdown.size(); i++) {
				String drop_down_values = dropdown.get(i).getText().trim();
				if (drop_down_values.contains(value)) {
					sel.selectByVisibleText(value);
					break;
				} else {
					ast.assertTrue(false, value + " Not Found");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select Dropdown " + value);
			logger.error("Unable to Select Dropdown " + e.getMessage());
			
		}
	}
	

	

	public String getselectDrpdwnValue(WebElement element) {
		try {
			
			Select sel = new Select(element);
			sel.getFirstSelectedOption();
			value = sel.getFirstSelectedOption().getText().trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to get Selected Dropdown Value " + value);
			logger.error("Unable to get Selected Dropdown Value " + e.getMessage());
		}
		return value;

	}

	public void switchToWindow(WebDriver driver) {
		parentWindow = driver.getWindowHandle();
		// System.out.println(parentWindow);
		Iterator<String> it = driver.getWindowHandles().iterator();
		while (it.hasNext()) {
			String popup = it.next().toString();
			// System.out.println(popup);
			if (!popup.contains("parentWindow")) {
				logger.info("switched to new window");
				driver.switchTo().window(popup);
				waitforpageload();
			} else {
				ast.assertTrue(false, "Unable to switch to new window");
				logger.error("Unable to switch to new window");
			}
		}
	}

	public void switchToMainWindow(WebDriver driver) {
		try {
			driver.close();
			driver.switchTo().window(parentWindow);

			logger.info("switched to Main window");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to switch to Parent window");
			logger.error("Unable to switch to Parent window " + e.getMessage());

		}
	}

	// For Entering Value
	public static void entervalue(String value, WebElement element) {
		if (IsElementPresent(element)) {
			element.clear();
			element.sendKeys(value);
			logger.info("Entered value is " + value);
		} else {
			ast.assertTrue(false, "Unable to enter value on element ");
			logger.error("Unable to enter value on element ");
		}

	}
	// For Entering number
		public static void enterNumber(double value, WebElement element) {
			if (IsElementPresent(element)) {
				element.clear();
				element.sendKeys(String.valueOf(value));
				logger.info("Entered value is " + value);
			} else {
				ast.assertTrue(false, "Unable to enter value on element ");
				logger.error("Unable to enter value on element ");
			}

		}
	// For Entering Value
		public static void enterNumvalue(String value, WebElement element, WebDriver driver) {
			if (IsElementPresent(element)) {
				element.clear();
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].value=" + value + ";", element);
				logger.info("Entered value is " + value);
			} else {
				ast.assertTrue(false, "Unable to enter value on element ");
				logger.error("Unable to enter value on element ");
			}
		}
		// ---For Selecting value---//
	public static void selectvalue(String value, WebElement element) {
		if (IsElementPresent(element)) {
			selectDrpdwnByTxt(element, value);
			logger.info("selected value is " + value);
		} else {
			ast.assertTrue(false, "Unable to select value of element ");
			logger.info("Unable to select value of element ");
		}
	}

	// ---For Selecting---//
	public static void selectvalue(int index, WebElement element) {
		if (IsElementPresent(element)) {
			selectDrpdwnByIndex(element, index);
			logger.info("selected value is " + element.getText());
		} else {
			ast.assertTrue(false, "Unable to select value of element ");
			logger.info("Unable to select value of element ");
		}
	}

	// For CheckBox Select
	public static void checkboxselect(WebElement element) {
		try {
			if (!element.isSelected()) {
				element.click();
				logger.info("Clicked on checkbox");
			} else {
				logger.info("Checkbox already selected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select CheckBox");
			logger.error("Unable to Select CheckBox " + e.getMessage());
		}

	}

	// For CheckBox DeSelect
	public static void checkboxdeselect(WebElement element) {
		try {
			if (element.isSelected()) {
				element.click();
				logger.info("checkbox Deselected");
			} else {
				logger.info("Checkbox already Deselected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Select CheckBox");
			logger.error("Unable to Select CheckBox " + e.getMessage());
		}

	}
	
	
	//---checkboxIsselected---//
	public static boolean checkboxIsselected(WebElement element) {
		if (element.isSelected()) {
				return true;
			} else {
				return false;
			}
	}
	
	public static boolean radiobtnIsselected(WebElement element) {
		if (element.isEnabled()) {
				return true;
			} else {
				return false;
			}
	}
	
	public static boolean isButtonEnabled(WebElement element) {
		if (element.isEnabled()) {
				return true;
			} else {
				return false;
			}
	}

	// For Button Click
	public static void buttonClick(WebElement element) {
		if (element.isEnabled()) {
			element.click();
			// logger.info("Clicked on" +element);
		} else {
			ast.assertTrue(false, "Unable to Click on element");
			logger.error("Unable to Click on element");
		}

	}
	public static void selectRadioButton(WebElement element) {
		try {
			if (!element.isSelected()) {
				element.click();
				logger.info("Radio Button selected");
			} else {
				logger.info("Radio Button already selected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ast.assertTrue(false, "Unable to Radio Button");
			logger.error("Unable to Select Radio Button " + e.getMessage());
		}

	}

	// For Get Value
	public static String getvalue(WebElement element) {
		if (IsElementPresent(element)) {
			logger.info("Value of element is " + element.getAttribute("value"));
		} else {
			ast.assertTrue(false, "Unable to get value of element ");
			logger.error("Unable to get value of element ");
		}

		value = element.getAttribute("value").trim();
		return value;
	}

	// For Get Value
	public static int getintvalue(WebElement element) {
		if (IsElementPresent(element)) {
			logger.info("Value of element is " + element.getAttribute("value"));
		} else {
			ast.assertTrue(false, "Unable to get integer type value of element ");
			logger.error("Unable to get value of element ");
		}

		value = element.getAttribute("value");
		int result = Integer.parseInt(value);
		return result;
	}

	// For Get Text
	public static String getText(WebElement element) {
		if (IsElementPresent(element)) {
			logger.info("Value of element is " + element.getText().trim());

		} else {
			ast.assertTrue(false, "Unable to get value of element");
			logger.error("Unable to get value of element");
		}
		value = element.getText().trim();
		return value;
	}

	// For Get Text
	public static String getvisibleText(WebElement element) {
		if (IsElementPresent(element)) {
			logger.info("Value of element is " + element.getText().trim());

		} else {
			ast.assertTrue(false, "Unable to get value of element");
			logger.error("Unable to get value of element");
		}
		value = element.getText().trim();
		return value;
	}

	public static boolean IsElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			ast.assertTrue(false, "Element not found" + e.getMessage());
			return false;
		}

	}



	
	

	

	
	
	
	
}
