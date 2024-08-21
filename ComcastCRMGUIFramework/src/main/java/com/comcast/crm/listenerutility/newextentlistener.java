package com.comcast.crm.listenerutility;

import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.castcast.crm.generic.webdrivereutlity.UtilityClassObject;
import com.comcast.baseclassutility.BaseClass;

public class newextentlistener implements ISuiteListener, ITestListener {

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		
		LocalDateTime date = LocalDateTime.now();
		String datetime = date.toString().replace(":", "_");

		spark = new ExtentSparkReporter("./advancedextenddemoreport/extentrepo"+datetime+".html");
		spark.config().setDocumentTitle("extent_demo_document");
		spark.config().setReportName("extent_demo_report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "firefox");
		report.setSystemInfo("os", "windows-64");
	}

	public void onFinish(ISuite suite) {
		report.flush();
	}
	
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		
		UtilityClassObject.setTest(test); // it will set the test object
		
		test.log(Status.INFO, "test started :" + result.getMethod().getMethodName()+": test started");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO, "test success:" + result.getMethod().getMethodName()+": test completed");
	}

	public void onTestFailure(ITestResult result) {

	
		TakesScreenshot ss = (TakesScreenshot) BaseClass.tempdriver;
		String filepath = ss.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(filepath, "failure" + result.getMethod().getMethodName());

		test.log(Status.FAIL, "test fail :" + result.getMethod().getMethodName()+": test failure");
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "test skip :" + result.getMethod().getMethodName()+": test skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

}
