package com.qa.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderButton;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(400));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(400));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}


	public void waitForElementToDisAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(400));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void goToCartPage() {
		cartButton.click();

	}
	
	public void goToOrderPage() {
		orderButton.click();
	}
}
