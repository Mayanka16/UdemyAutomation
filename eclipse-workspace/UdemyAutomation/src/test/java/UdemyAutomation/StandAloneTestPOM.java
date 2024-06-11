package UdemyAutomation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pageObjects.ConfirmationPage;
import com.qa.pageObjects.LandingPage;
import com.qa.pageObjects.MyCart;
import com.qa.pageObjects.Paymentmethod;
import com.qa.pageObjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestPOM {

	@Test
	public void purchaseCloth() {

		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		LandingPage landingPageObj = new LandingPage(driver);
		landingPageObj.goToURL();
		landingPageObj.loginApplication("maya@gmail.com", "Quality44%");

		ProductCatalog productCatalogObj = new ProductCatalog(driver);
		// List<WebElement> productsList =
		productCatalogObj.getProductList();
		productCatalogObj.addProductToCart(productName);
		productCatalogObj.goToCartPage();

		MyCart myCartobj = new MyCart(driver);
		Boolean match = myCartobj.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		myCartobj.checkOut();

		Paymentmethod paymentMethodObj = new Paymentmethod(driver);
		paymentMethodObj.enterCountry("india");
		paymentMethodObj.submitOrder();

		ConfirmationPage ConfirmationPageObj = new ConfirmationPage(driver);

		String confirmMessage = ConfirmationPageObj.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		System.out.println("Validation Completed");
		driver.close();
	}

}
