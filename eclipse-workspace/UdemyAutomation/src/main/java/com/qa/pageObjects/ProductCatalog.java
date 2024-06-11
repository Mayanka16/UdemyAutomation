package com.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) // constructor

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * By using PageFactory we are writing xpath as below which will internally call
	 * the full driver xpath. Under constructor we have defined initElements
	 * List<WebElement> productsList =
	 * driver.findElements(By.xpath("//div[@class='card']/div/h5/b"));
	 */

	// PageFactory
	@FindBy(xpath = "//div[@class='card']/div/h5/b")
	List<WebElement> productsList;
	By products = By.xpath("//div[@class='card']/div/h5/b");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.xpath("//div[@class='overlay-container']/div");
	@FindBy(xpath = "//div[@class='overlay-container']")
	WebElement invisibilityOfToastMessage;

	public List<WebElement> getProductList() {
		waitForElementToAppear(products);
		return productsList;
	}

	public WebElement getProductByName(String productName) {

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(prods -> prods.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		prod.findElement(addToCart).click();
		return prod;

	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		// prod.findElement(addToCart).click();
		waitForElementToAppear(toastMsg);
		waitForElementToDisAppear(invisibilityOfToastMessage);

	}
}
