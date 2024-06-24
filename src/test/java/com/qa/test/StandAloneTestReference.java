package com.qa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestReference {

	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://rahulshettyacademy.com/client");
		//LandingPage obj = new LandingPage(driver); 

		/*
		 * Username = maya@gmail.com and password = Quality44%
		 */

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("maya@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Quality44%");
		driver.findElement(By.id("login")).click();

		List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='card']/div/h5/b"));

		/*
		 * 1. By using basic Iterator for (WebElement products : productsList) { if
		 * (products.getText().equals("ZARA COAT 3")) {
		 * System.out.println("Data Available"); } }
		 */

		// 2. by using stream()
		WebElement prod = productsList.stream().filter(products -> products.getText().equals(productName)).findFirst()
				.orElse(null);

		prod.findElement(By.xpath("//button[@style='float: right;']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(400));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='overlay-container']/div")));

		/*
		 * both the lines does same job but below will be faster
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
		 * "//div[@class='overlay-container']")));
		 */

		wait.until(
				ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='overlay-container']"))));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartList = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		// instead of filter we can use anyMatch too
		// WebElement pro1d = cartList.stream().filter(cart ->
		// cart.getText().equals(productName)).findAny().orElse(null);
		Boolean match = cartList.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		/*
		 * instead of using sendkeys we can also use it using Actions class
		 * driver.findElement(By.xpath("//div[@class='form-group']/input")).sendKeys(
		 * "india");
		 */

		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(By.xpath("//div[@class='form-group']/input")), "india").build().perform();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));

		driver.findElement(By.xpath("(//button[contains(@class,'ng-star-inserted')])[2]")).click();
		/*
		 * List<WebElement> country =
		 * driver.findElements(By.xpath("//span[@class='ng-star-inserted']/i"));
		 * WebElement country_india = country.stream().filter(india ->
		 * india.getText().equalsIgnoreCase("india")).findAny() .orElse(null);
		 * country_india.click();
		 */

		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		String confirmMessage = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		System.out.println("Validation Completed");
		driver.close();
	}

}
