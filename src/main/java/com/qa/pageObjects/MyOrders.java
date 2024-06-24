package com.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.AbstractComponents.AbstractComponents;

public class MyOrders extends AbstractComponents {

	WebDriver driver;

	public MyOrders(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> orderList;

	public boolean verifyOrderDisplay(String productName) {

		Boolean match = orderList.stream().anyMatch(order -> order.getText().equalsIgnoreCase(productName));

		return match;

	}

}
