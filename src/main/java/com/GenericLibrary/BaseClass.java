package com.GenericLibrary;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import com.pageObjectLib.HomePage;
import com.pageObjectLib.LoginPage;
import com.pageObjectLib.PIM_Page;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.GenericLibrary.*;
public class BaseClass extends WebDriverCommonLib {
	public LoginPage lgn;
	public HomePage home;
	public WebDriverCommonLib wcl;
	public PIM_Page pim;
	
	@BeforeClass
	public void LoadMethods() throws Exception {
		try {
			home = PageFactory.initElements(driver, HomePage.class);
			lgn= PageFactory.initElements(driver, LoginPage.class);
			wcl = PageFactory.initElements(driver, WebDriverCommonLib.class);
			pim=PageFactory.initElements(driver, PIM_Page.class);
			ast = new SoftAssert();
			logger.info("Completed Loading Methods");
			wcl.waitforpageload();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

}


