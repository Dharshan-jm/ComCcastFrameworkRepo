package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.baseclassutility.BaseClass;

public class ClassListenerutility implements ITestListener, ISuiteListener {

	public static ExtentReports er = null;
	public ExtentSparkReporter esr = null;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
        
		// create object(report configuration)
		esr = new ExtentSparkReporter("./advancereport/report.html");
		esr.config().setDocumentTitle("CRM TEST SUITE RESULT");
		esr.config().setReportName("CRM_EXTENT_REPORT");
		esr.config().setTheme(Theme.DARK);

		// add environment information and create test
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("WINDOWS10", "OS");
		er.setSystemInfo("CHROME-100", "BROWSER");
		System.out.println("Report configuration");
	}

	public void onFinish(ISuite suite) {
		er.flush();
		System.out.println("Report backup");

	}

	public void onTestStart(ITestResult result) {
		test = er.createTest(result.getMethod().getMethodName());
		
		//message
		test.log(Status.INFO,result.getMethod().getMethodName()+ ": started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Result :" + result.getMethod().getMethodName() + "===methodend");
		
		test.log(Status.PASS,result.getMethod().getMethodName()+ ": completed");

	}

	public void onTestFailure(ITestResult result) {
		// we take screenshot on failure script
        // method name
		// local date
		LocalDateTime date = LocalDateTime.now();
		String datevalue = date.toString().replace(":", "_");

		String testname = result.getMethod().getMethodName();

		TakesScreenshot sc = (TakesScreenshot) BaseClass.tempdriver;
		String filepath = sc.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(filepath, "errorfile :"+testname+" : "+datevalue);
		
		test.log(Status.FAIL,result.getMethod().getMethodName()+ ": failed");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP,result.getMethod().getMethodName()+ ": failed");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
