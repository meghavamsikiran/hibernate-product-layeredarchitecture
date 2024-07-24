package com.onetomany.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	@Column(name="product_name")
    private String productName;
    private double price;
    private String category;
    @Column(name="in_stock")
    private boolean inStock;
    @Column(name="quantity_on_hand")
    private int qunatityOnHand;
    
    public Product() {

    }

    public Product(int productId, String productName, double price, String category, boolean inStock, int qunatityOnHand) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
        this.qunatityOnHand = qunatityOnHand;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQunatityOnHand() {
        return qunatityOnHand;
    }

    public void setQunatityOnHand(int qunatityOnHand) {
        this.qunatityOnHand = qunatityOnHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(price, product.price) == 0 && inStock == product.inStock && qunatityOnHand == product.qunatityOnHand && Objects.equals(productName, product.productName) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, category, inStock, qunatityOnHand);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", inStock=" + inStock +
                ", qunatityOnHand=" + qunatityOnHand +
                '}';
    }
}
