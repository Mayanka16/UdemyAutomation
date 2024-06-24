package com.qa.Selenium4Updates;

import org.openqa.selenium.chrome.ChromeOptions;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4Locators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();

		WebDriver driver = new ChromeDriver(option);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		driver.get("https://www.rahulshettyacademy.com/angularpractice/");

		// 1 .above()

		WebElement nameEditBox = driver.findElement(By.cssSelector("[name=name]"));

		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

		// 2. .below()

		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

		System.out.println("Validation Ends");
		driver.quit();
//similarly we can use toLeftof() and toRightof()
	}

}
