package com.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.AbstractComponents.AbstractComponents;

public class MyCart extends AbstractComponents {
	WebDriver driver;

	public MyCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ("//div[@class='cartSection']/h3"))
	List<WebElement> cartList;
	
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOutButton;

	public List<WebElement> getCartList() {
		// waitForElementToAppear(cartList);
		return cartList;
	}

	public boolean verifyProductDisplay(String productName) {

		Boolean match = cartList.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productName));

		return match;

	}

	public void checkOut() {
		checkOutButton.click();
	}

}
