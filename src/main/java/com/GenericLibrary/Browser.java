package com.GenericLibrary;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import com.GenericLibrary.Constants;
import com.pageObjectLib.LoginPage;
import com.pageObjectLib.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser implements Constants 
{
	

		public static WebDriver driver;
		LoginPage login;
		public static SoftAssert ast;
		public static Logger logger = Logger.getLogger("LoggerCreation");
		@BeforeSuite
		public void Loadlogfile() throws Exception {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/Resources/log4j.properties");
			System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		}
		@BeforeTest
	 public void getBrowser() throws Exception{

			if (browser.equalsIgnoreCase("Chrome")) {
				
				try {
					WebDriverManager.chromedriver().clearDriverCache().setup();

					logger.info("Connecting to Chrome browser");

					ChromeOptions options = new ChromeOptions();
					driver = new ChromeDriver(options);
					logger.info("Opened  Chrome browser");

					driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error("Unable to Open Chrome Browser " + e.getMessage());
					ast.assertTrue(false, "Unable to Open Chrome Browser " + e.getMessage());
				}
				try {

					logger.info("Maximizing Browser");
					driver.manage().window().maximize();
					logger.info("Completed Maximizing Browser");
					logger.info("Connecting to Url");
					driver.navigate().to(Constants.url);
					logger.info("Connected to Url " + Constants.url);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error("Unable to Connect to URl " + e.getMessage());
					ast.assertTrue(false, "Unable to Connect to URl " + e.getMessage());
				}
				login = PageFactory.initElements(driver, LoginPage.class);
				login.login();

			} }

		@AfterTest
		public void Logout() {
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			try {
				logger.info("Trying to Logout");
				// home.ClickOnNavBox();
				Thread.sleep(1000);
				logger.info("Logged out from application Successfully");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Unable to Logout " + e.getMessage());
			}
			try {
				logger.info("Trying to close Browser");
				driver.quit();
				logger.info("Browser Closed Successfully");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Unable to close the browser " + e.getMessage());
			}
			
		}

	}

