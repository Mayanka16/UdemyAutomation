package UdemyAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.TestComponents.BaseTest;
import com.qa.pageObjects.ConfirmationPage;
import com.qa.pageObjects.MyCart;
import com.qa.pageObjects.MyOrders;
import com.qa.pageObjects.Paymentmethod;
import com.qa.pageObjects.ProductCatalog;

public class StandAloneTestForBaseTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase", "Sanity" })

	public void purchaseCloth(String email, String password, String productName) throws IOException {

		landingPageObj.loginApplication(email, password);

		ProductCatalog productCatalogObj = new ProductCatalog(driver);

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

	}

	// dependsOnMethod once product is ordered validate order header
	@Test(dependsOnMethods = { "purchaseCloth" })
	public void validateOrderHistory() {
		landingPageObj.loginApplication("maya@gmail.com", "Quality44%");
		landingPageObj.goToOrderPage();
		MyOrders myOrderobj = new MyOrders(driver);
		// Boolean match = myOrderobj.verifyOrderDisplay(productName);
		// Assert.assertTrue(match);
		Assert.assertTrue(myOrderobj.verifyOrderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "maya@gmail.com", "Quality44%", "ZARA COAT 3" },
				{ "sao@gmail.com", "Quality44%", "ADIDAS ORIGINAL" } };
	}

}
