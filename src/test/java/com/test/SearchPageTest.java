package com.test;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pom.SearchPage;
import com.utility.BaseClass;

public class SearchPageTest extends BaseClass {

	@Test
	public void TC_03_oneWayTrip() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		Thread.sleep(2000);
		search.closeLoginPage().click();
		search.clickSource().click();
		search.enterSource().sendKeys("BLR");
		Thread.sleep(2000);
		search.enterSourceFirstOption().click();
		Thread.sleep(2000);
		search.enterDestination().sendKeys("BOM");
		Thread.sleep(2000);
		search.enterSourceFirstOption().click();
		Thread.sleep(2000);
		search.enterDate().click();
		Thread.sleep(2000);
		search.clickSearchBtn().click();
		Thread.sleep(2000);
	}
}
