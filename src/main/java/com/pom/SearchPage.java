package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='makeFlex hrtlCenter']//ul//li")
	private WebElement tripType;

	@FindBy(id = "fromCity")
	private WebElement clickSource;
	
	@FindBy(xpath = "//section[@class='modalMain tcnFooter']//span[@class='commonModal__close']")
	private WebElement closeLoginpg;
	
	@FindBy(xpath = "//input[@class='react-autosuggest__input react-autosuggest__input--open']")
	private WebElement source;
	
	
	@FindBy(id = "toCity")
	private WebElement destination;
	
	@FindBy(xpath = "//div[@class='DayPicker-Month']//div[@class='DayPicker-Week'][2]//div[@class='DayPicker-Day'][1]")
	private WebElement departureDate;
	
	@FindBy(xpath = "//div[@data-cy='flightTraveller']")
	private WebElement traveler;
	
	@FindBy(xpath = "//p[@class='makeFlex vrtlCenter ']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "(//div[@id='react-autowhatever-1']//ul)//following::li[0]")
	private WebElement destinationFirstListOption;
	
	@FindBy(xpath = "((//div[@id='react-autowhatever-1'])//following::ul)//li[1]")
	private WebElement sourceFirstListOption;
	
	
	
	
	public WebElement clickSource() {
		return clickSource;
	}
	
	public WebElement closeLoginPage() {
		return closeLoginpg;
	}

	public WebElement enterSource() {
		return source;
	}
	
	public WebElement enterSourceFirstOption() {
		
		return sourceFirstListOption;
	}
	
	public WebElement enterDestination() {
		return destination;
	}
	public WebElement enterDestinationFirstOption() {
		return destinationFirstListOption;
	}
	
	public WebElement enterDate() {
		return departureDate;
	}
	
	public WebElement selectTraveller() {
		return traveler;
	}
	
	public WebElement clickSearchBtn() {
		return searchBtn;
	}
}
