package com.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.AbstractComponents.AbstractComponents;

public class Paymentmethod extends AbstractComponents {
	WebDriver driver;

	public Paymentmethod(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ("//div[@class='form-group']/input"))
	WebElement enterCountry;

	@FindBy(xpath = "(//button[contains(@class,'ng-star-inserted')])[2]")
	WebElement selectCountry;

	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement actionSubmit;
	By results = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement submit;

	public void enterCountry(String country) {
		Actions action = new Actions(driver);
		action.sendKeys(enterCountry, country).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();

	}
	public void submitOrder() {
		submit.click();
		
		
	}

}
