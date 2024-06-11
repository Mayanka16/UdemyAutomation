package com.qa.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pageObjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPageObj;

	public WebDriver initializeDriver() throws IOException {

		// properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"//Users//mayanka//eclipse-workspace//UdemyAutomation//src//main//java//com//qa//resources//GlobalData.properties");
		// FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+
		// "//src/main//java//com//qa//resources//GlobalData.properties)");
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else {
			System.out.println("Error in Browser Launch");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToHashMap(String filePath) throws IOException {
		// reading json to string
		// FileUtils.readFileToString(new
		// File("//Users//mayanka//eclipse-workspace//UdemyAutomation//src//test//java//jsonData//PurchaseCloth.json"));
		String jsonContent = FileUtils.readFileToString(
				new File(filePath), StandardCharsets.UTF_8);
		
		//String to HashMap using Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
			
		});
		return data;
	}
	

	@BeforeMethod(alwaysRun = true) //(alwaysRun = true) in any case this method will always run

	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPageObj = new LandingPage(driver);
		landingPageObj.goToURL();
		return landingPageObj;

	}

	@AfterMethod(alwaysRun = true)//(alwaysRun = true) in any case this method will always run
	public void tearDown() {
		System.out.println("Validation Completed");
		driver.close();
	}
}
