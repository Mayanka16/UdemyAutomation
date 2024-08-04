package featureClass;

public class Search {
	
	public String displayProduct(Product productName) {
		if(productName.getProductList().contains(productName.getProductName())) {
			return productName.getProductName();
		}
		return null;
		
	}

}
