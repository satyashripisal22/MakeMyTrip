package com.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG implements ITestListener {

	ExtentSparkReporter reporter;
	ExtentReports report;
	static ExtentTest test;
	WebDriver driver;
	public void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "ExecutionReport "+timestamp + ".html";
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		report = new ExtentReports();
		report.attachReporter(reporter);
		
		//addsystem information/env info to reports
		report.setSystemInfo("Machine", "DELL");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("QA", "Satyashri");
		
		//configuration to change look and feel of report
		
		reporter.config().setDocumentTitle("Extent Report");
		reporter.config().setReportName("Execution Report");
		reporter.config().setTheme(Theme.DARK);
		
	}
	
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		configureReport();
		ExtentReporterNG.test = report.createTest(result.getTestClass().getName()+"=="+result.getMethod().getMethodName());
		extenttest.set(test);
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Nmae of the pass test case is: "+result.getName(), ExtentColor.GREEN));
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		ExtentReporterNG.test.log(Status.FAIL, MarkupHelper.createLabel("Nmae of the failed test case is: "+result.getName(), ExtentColor.RED));
		String capturescreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(capturescreenshot,"Failed Test Screenshot");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		ExtentReporterNG.test.log(Status.PASS, MarkupHelper.createLabel("Nmae of the Skip test case is: "+result.getName(), ExtentColor.YELLOW));
	}
	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
	
	
	
	
	
}
