package com.onetomany.dao;

import com.onetomany.entity.Product;
import com.onetomany.util.ProductUtil;

import jakarta.persistence.EntityManager;

public interface ProductDao {
	public void addproduct(Product product);
	public Product findProductById(int productId);
	public void deleteProductById(int productId);
	public void updateproductNameById(int productId, String productName);
	public void displayAllProducts();
	public void displayProductIdAndName();
	public void displayProductsWhereQoh();
	public void displayWithDistinct();
	public void displayWithNamedParams();
	
}
