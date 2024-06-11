package com.qa.Selenium4Updates;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeMultipleWindows {

	WebDriver driver;
	WebElement name;

	public void invokeWindow() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();

		driver = new ChromeDriver(option);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");

		String textOfFirstCourse = driver
				.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		driver.close();
		driver.switchTo().window(parentWindow);

		name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(textOfFirstCourse);

		File file = name.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("nameImage.png"));

		Thread.sleep(2000);

		System.out.println("Validation Completed to get the text");

	}

	public static void main(String[] args) throws InterruptedException, IOException {

		InvokeMultipleWindows obj = new InvokeMultipleWindows();
		obj.invokeWindow();

	}

}
