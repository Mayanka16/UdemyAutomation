package stepDefinition;

import featureClass.Product;
import featureClass.Search;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	Product product;
	Search search;

	@Given("I have a search field on Amazon Page")
	public void i_have_a_search_field_on_amazon_page() {
		System.out.println("Step 1");

	}

	@When("I search for a product with name {string} and price {int}")
	public void i_search_for_a_product_with_name_and_price(String productName, Integer amount) {
		System.out.println("Step 2 - the product name is " + productName + " and amount is " + amount);

		product = new Product(productName, amount);

	}

	@Then("I search the product {string} should be displayed")
	public void i_search_the_product_should_be_displayed(String productName) {
		System.out.println("Step 3 - the product name is " + productName);

		search = new Search();

	}

}
