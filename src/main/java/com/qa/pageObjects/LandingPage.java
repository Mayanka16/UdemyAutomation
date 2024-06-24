package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) // constructor

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * By using PageFactory we are writing xpath as below which will internally call
	 * the full driver xpath. Under constructor we have defined initElements.
	 * WebElement userEmail1 =
	 * driver.findElement(By.xpath("//input[@type='email']"));
	 */

	// PageFactory
	@FindBy(xpath = "//input[@type='email']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submitButton;
	
	@FindBy(id="toast-container")
	WebElement errorMessage;

	public void loginApplication(String userName, String password) {
		userEmail.sendKeys(userName);
		passwordEle.sendKeys(password);
		submitButton.click();

	}
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
		
		
	}

	public void goToURL() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
