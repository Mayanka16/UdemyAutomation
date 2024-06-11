package UdemyAutomation;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.qa.TestComponents.BaseTest;


public class StandAloneForErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorValidation"})
	public void purchaseCloth() throws IOException {

		//String productName = "ZARA COAT 3";

		
		landingPageObj.loginApplication("mayaa@gmail.com", "Quality44%");
		AssertJUnit.assertEquals("Incorrect email or password.",landingPageObj.getErrorMessage());

		/*
		 * ProductCatalog productCatalogObj = new ProductCatalog(driver);
		 * productCatalogObj.getProductList();
		 * productCatalogObj.addProductToCart(productName);
		 * productCatalogObj.goToCartPage();
		 * 
		 * MyCart myCartobj = new MyCart(driver); Boolean match =
		 * myCartobj.verifyProductDisplay(productName); Assert.assertTrue(match);
		 * myCartobj.checkOut();
		 * 
		 * Paymentmethod paymentMethodObj = new Paymentmethod(driver);
		 * paymentMethodObj.enterCountry("india"); paymentMethodObj.submitOrder();
		 * 
		 * ConfirmationPage ConfirmationPageObj = new ConfirmationPage(driver);
		 * 
		 * String confirmMessage = ConfirmationPageObj.getConfirmationMessage();
		 * Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."))
		 * ;
		 */
	}

}
