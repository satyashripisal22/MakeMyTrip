package com.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library extends BaseClass {
	
	static WebDriver driver;
	
	public static WebDriverWait waitforWebElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		return wait;
	}

	public static void clickElement(WebElement element, String fieldName) {
//		waitforWebElement(element);
		element.click();
		System.out.println("Clickced Suscessfuly on "+ fieldName);
	}
	
	public static void enterText(WebElement element, double text, String fieldName) {
		waitforWebElement(element);
		element.sendKeys(""+text);
		System.out.println("Entered text in "+fieldName);
	}
	
	
}
