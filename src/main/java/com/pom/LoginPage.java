package com.pom;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Library;

public class LoginPage  {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@class='font14 fullWidth']")
	private WebElement username;
	
		@FindBy(xpath = "//section[@class='modalMain tcnFooter']//span[@class='commonModal__close']")
		private WebElement closeLoginpg;
	
	@FindBy(xpath = "//button[@class='capText font16']")
	private WebElement contiueBtn;
	
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement enterUsername() {
		return username;
	}

	public WebElement closeLoginPage() {
		return closeLoginpg;
	}

	public WebElement clickContiueBtn() {
		return contiueBtn;
	}

	// done code review
	
	
}
