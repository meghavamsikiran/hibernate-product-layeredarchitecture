package com.onetomany.service;

import com.onetomany.entity.Product;

public interface ProductService {
	public void addProduct(Product product);
	public Product findProductByid(int productId);
	public void deleteById(int productId);
	public void updateproductNameById(int productId, String productName);
	public void displayAllProducts();
	public void displayProductIdAndName();
	public void displayProductsWhereQoh();
	public void displayWithDistinct();
	public void displayWithNamedParams();
}
