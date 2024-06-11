package UdemyAutomation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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

	//public void purchaseCloth(String email, String password, String productName) throws IOException {

	public void purchaseCloth(HashMap<String, String> input) throws IOException {
		landingPageObj.loginApplication(input.get("email"), input.get("password"));

		ProductCatalog productCatalogObj = new ProductCatalog(driver);

		productCatalogObj.getProductList();
		productCatalogObj.addProductToCart(input.get("productName"));
		productCatalogObj.goToCartPage();

		MyCart myCartobj = new MyCart(driver);
		Boolean match = myCartobj.verifyProductDisplay(input.get("productName"));
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
	public Object[][] getData() throws IOException {
		/*
		 * converted to Json file reader
		 * 
		 * 
		 * HashMap<String, String> map = new HashMap<>(); map.put("email",
		 * "maya@gmail.com"); map.put("password", "Quality44%"); map.put("productName",
		 * "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map1 = new HashMap<>(); map1.put("email",
		 * "sao@gmail.com"); map1.put("password", "Quality44%"); map1.put("productName",
		 * "ADIDAS ORIGINAL");
		 * 
		 */
		
		//return new Object[][] { { "maya@gmail.com", "Quality44%", "ZARA COAT 3" },{ "sao@gmail.com", "Quality44%", "ADIDAS ORIGINAL" } };
		List<HashMap<String, String>> data = getJsonDataToHashMap(System.getProperty("user.dir") + "//src//test//java//jsonData//PurchaseCloth.json");
		return new Object[][] { {data.get(0)},{data.get(1)}};
				
	}

}
