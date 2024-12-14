package com.test;

import org.testng.annotations.Test;

import com.pom.LoginPage;
import com.utility.BaseClass;
import com.utility.Library;

public class LoginTest extends BaseClass{

	LoginPage loginpage ;
	
	@Test(enabled = false)
	public void TC_001_verifyLogin() {
		loginpage = new LoginPage(driver);
		
//		loginpage.enterUsername().sendKeys("814905849");
//		loginpage.clickContiueBtn().click();
		
		Library.enterText(loginpage.enterUsername(), excel.getNumericData("Sheet1", 1, 0), "Username");
		Library.clickElement(loginpage.clickContiueBtn(), "Continue button");
	}
	
	@Test
	public void TC_02_closeLoginPage(){
		loginpage = new LoginPage(driver);
		Library.clickElement(loginpage.closeLoginPage(), "Clicked on Login page close butotn");
	}
	
}
