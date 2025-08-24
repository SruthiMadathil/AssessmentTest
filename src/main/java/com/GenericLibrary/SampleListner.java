package com.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.GenericLibrary.Browser;
import com.GenericLibrary.WebDriverCommonLib;

public class SampleListner implements ITestListener {

	public void onTestStart(ITestResult result) {
		Browser.logger.info("Test Case Started " + result.getInstanceName());

	}

	public void onTestSuccess(ITestResult result) {
		Browser.logger.info("Test Case Success " + result.getInstanceName());
	}

	public void onTestFailure(ITestResult result) {
		WebDriverCommonLib.Capture(result, "FailedTCScreenshots");
		Browser.logger.info("Test Case Failed " + result.getInstanceName());
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
