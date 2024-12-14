package com.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.pom.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public ExcelDataProvider excel;
	public LoginPage loginPage;
	
	@BeforeSuite
	public void beforeSuite() throws Exception {
		excel = new ExcelDataProvider();
		loginPage = new LoginPage(driver);
	}
	
	@BeforeMethod
	public WebDriver IntializationBrowser() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--incognito");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		return driver;
	}
//	@AfterMethod
//	public void TearDown() throws InterruptedException {
//		driver.quit();
//	}
}
