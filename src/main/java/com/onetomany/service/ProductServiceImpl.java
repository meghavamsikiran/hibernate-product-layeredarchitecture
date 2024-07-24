package com.onetomany.service;

import com.onetomany.dao.ProductDao;
import com.onetomany.dao.ProductDaoImpl;
import com.onetomany.entity.Product;

public class ProductServiceImpl implements ProductService{
	
	private ProductDao productDao;
	
	@Override
	public void addProduct(Product product) 
	{
		productDao = new ProductDaoImpl();
		productDao.addproduct(product);
	}

	@Override
	public Product findProductByid(int productId) {
		
		productDao = new ProductDaoImpl();
		Product product = productDao.findProductById(productId);
		if(product==null) System.out.println("No product found with product id = "+productId);
		return product;
	}

	@Override
	public void deleteById(int productId) {
		productDao = new ProductDaoImpl();
		productDao.deleteProductById(productId);
	}

	@Override
	public void updateproductNameById(int productId, String productName) {
		// TODO Auto-generated method stub
		productDao = new ProductDaoImpl();
		productDao.updateproductNameById(productId, productName);
	}
	
	@Override
	public void displayAllProducts() {
		productDao = new ProductDaoImpl();
		productDao.displayAllProducts();
	}
	
	@Override
	public void displayProductIdAndName() {
		productDao = new ProductDaoImpl();
		productDao.displayProductIdAndName();
	}

	@Override
	public void displayProductsWhereQoh() {

		productDao = new ProductDaoImpl();
		productDao.displayProductsWhereQoh();
	}

	@Override
	public void displayWithDistinct() {
		productDao = new ProductDaoImpl();
		productDao.displayWithDistinct();
	}

	@Override
	public void displayWithNamedParams() {
		productDao = new ProductDaoImpl();
		productDao.displayWithNamedParams();
	}
}
