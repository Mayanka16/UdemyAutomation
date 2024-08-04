package featureClass;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private String prodcutName;
	private int productPrice;

	public Product(String productName, int productPrice) {
		this.prodcutName = productName;
		this.productPrice = productPrice;

	}

	public String getProductName() {
		return prodcutName;
	}

	public void setProductName(String productName) {
		this.prodcutName = productName;
	}

	public int getproductPrice() {
		return productPrice;

	}

	public void setproductPrice(int productPrice) {
		this.productPrice = productPrice;

	}

	public List<String> getProductList() {
		List<String> products = new ArrayList<String>();
		products.add("iPhone 15 pro");
		products.add("iPhone 15 pro max");
		products.add("iPhone 14 pro");
		products.add("iPhone 14 pro max");
		return products;

	}

}
