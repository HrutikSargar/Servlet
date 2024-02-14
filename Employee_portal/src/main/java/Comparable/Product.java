package Comparable;

public class Product implements Comparable<Product> {

	private int productId;
	private String productName;
	private double productPrice;
	
	@Override
	public int compareTo(Product p) {
		if(productId==p.getProductId()) {
			return 0;
		}else if(productId>p.getProductId()) {
			return 1;
		}else {
			return -1;
		}
		
	}
	
	
	public Product(int id, String productName, double productPrice) {
		super();
		this.productId = id;
		this.productName = productName;
		this.productPrice = productPrice;
	}


	

	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}


	


	
	
	
	

	
}
