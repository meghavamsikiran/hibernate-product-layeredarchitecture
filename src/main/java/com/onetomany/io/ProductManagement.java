package com.onetomany.io;

import java.util.Scanner;

import com.onetomany.entity.Product;
import com.onetomany.service.ProductService;
import com.onetomany.service.ProductServiceImpl;
import com.onetomany.util.ProductUtil;

public class ProductManagement {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add a Product");
		System.out.println("2. Delete a Product");
		System.out.println("3. Update a Product");
		System.out.println("4. Find a Product by Id");
		System.out.println("5. Display Product Details");
		System.out.println("6. Display By ProductId and ProductName");
		System.out.println("7. Display Products where Qoh>50");
		System.out.println("8. Display the Distinct Product Categories");
		System.out.println("9. Display with Named Parameters");
		System.out.println("Enter your Choice: ");
		
		int ch = sc.nextInt();
		switch(ch) {
		case 1: addProduct(); break;
		case 2: deleteProductById(); break;
		case 3: updateproductNameById(); break;
		case 4: findProductById(); break;
		case 5: displayAllProducts(); break;
		case 6: displayProductIdAndName(); break;
		case 7: displayProductsWhereQoh(); break;
		case 8: displayWithDistinct(); break;
		case 9: displayWithNamedParams(); break;
		default: System.out.println("Invalid Input!"); break;
		}
	}


	private static void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Product Name: ");
		String productName = sc.nextLine();
		System.out.println("Price: ");
		double price = sc.nextDouble();
		sc.nextLine();
		System.out.println("Category: ");
		String category = sc.nextLine();
		System.out.println("In Stock: ");
		boolean inStock = sc.nextBoolean();
		System.out.println("Qunatity On Hand: ");
		int quantityOnHand = sc.nextInt();
		
		Product product = new Product();
		product.setProductName(productName);
		product.setPrice(price);
		product.setCategory(category);
		product.setInStock(inStock);
		product.setQunatityOnHand(quantityOnHand);
		
		ProductService productService = new ProductServiceImpl();
		productService.addProduct(product);
	}
	
	private static void deleteProductById() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Id to delete: ");
		int productId = sc.nextInt();
		
		ProductService productService = new ProductServiceImpl();
		productService.deleteById(productId);
	}
	
	private static void findProductById()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Id to find: ");
		int productId = sc.nextInt();
		
		ProductService productService = new ProductServiceImpl();
		System.out.println(productService.findProductByid(productId));
	}
	
	private static void updateproductNameById()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter product Id to Update: ");
		int productId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new Product Name: ");
		String productName = sc.nextLine();
		
		ProductService productService = new ProductServiceImpl();
		productService.updateproductNameById(productId, productName);
	}
	
	public static void displayAllProducts()
	{
		ProductService productService = new ProductServiceImpl();
		productService.displayAllProducts();
	}
	
	public static void displayProductIdAndName()
	{
		ProductService productService = new ProductServiceImpl();
		productService.displayProductIdAndName();
	}
	
	public static void displayProductsWhereQoh()
	{
		ProductService productService = new ProductServiceImpl();
		productService.displayProductsWhereQoh();
	}
	
	public static void displayWithDistinct()
	{
		ProductService productService = new ProductServiceImpl();
		productService.displayWithDistinct();
	}
	
	public static void displayWithNamedParams()
	{
		ProductService productService = new ProductServiceImpl();
		productService.displayWithNamedParams();
	}
}
