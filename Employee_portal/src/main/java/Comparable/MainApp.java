package Comparable;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
	public static void main(String[] args) {
		
		ArrayList<Product>productList=new ArrayList<Product>();
		
		productList.add(new Product(1, "ZC", 24999.99));
		productList.add(new Product(3, "TV", 28456.99));
		productList.add(new Product(2, "Fridge", 28999.99));
		productList.add(new Product(4, "Kflsd", 54599.99));
		
		
		//comparable interface
//		Collections.sort(productList);
//		System.out.println(productList);
		
		//comparator interface
		Collections.sort(productList,new ProductNameComparator());
		//System.out.println(productList);
		
		Collections.reverse(productList);
		System.out.println(productList);
		
		
	}
	
	

}
