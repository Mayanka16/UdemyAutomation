package com.qa.Selenium4Updates;

import java.io.File;
import java.io.IOException;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;

public class GetPartialScreenshot extends InvokeMultipleWindows {

	public void screenshot() throws IOException, InterruptedException {

		super.invokeWindow();

		// ToTakePartialScreenshot

		File file = name.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("nameImage.png"));

		Thread.sleep(2000);

		System.out.println("Validation Completed");
		
		
		
		// to get the Height and Width of a text box
		int width = name.getRect().getDimension().getWidth();
		int height = name.getRect().getDimension().getHeight();
		
		if(width>1000 && height>1000) {
			Assert.assertTrue(true, "The Height is : "+ height + " and Width is : "+ width);
		}
		else {
			Assert.assertFalse(false, "The Height is : "+ height + " and Width is : "+ width + "larger than 1000");
		}
		driver.quit();

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		GetPartialScreenshot obj1 = new GetPartialScreenshot();
		obj1.screenshot();
	}
}