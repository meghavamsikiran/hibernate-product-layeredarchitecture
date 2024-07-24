package com.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import com.onetomany.entity.Product;
import com.onetomany.util.ProductUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void addproduct(Product product) {
		
		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(product);
		et.commit();
	}

	@Override
	public Product findProductById(int productId) {	
		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Product temp = em.find(Product.class, productId);
		et.commit();
		if(temp==null) System.out.println("Failed to delete the product "+productId);
		return temp;
	}

	@Override
	public void deleteProductById(int productId) {
		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Product temp = em.find(Product.class, productId);
		em.remove(temp);
		et.commit();
	}

	@Override
	public void updateproductNameById(int productId, String productName) {
		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Product temp = em.find(Product.class, productId);
		temp.setProductName(productName);
		et.commit();
	}
	
	@Override
	public void displayAllProducts() {
		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Query query = null;
		et.begin();
		query = em.createQuery("Select p from Product as p");
		List<Product> list = query.getResultList();
		for(Product p: list)
		{
			System.out.println(list);
		}
		et.commit();
	}
	
	@Override
	public void displayProductIdAndName() {
		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Query query = null;
		et.begin();
		query = em.createQuery("SELECT p.productId,p.productName FROM Product as p");
		List<Object[]> listPidAndpName = query.getResultList();
		for(Object[] o : listPidAndpName)
		{
			System.out.println(o[0]+" "+o[1]);
		}
		et.commit();
	}

	@Override
	public void displayProductsWhereQoh() {

		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Query query = null;
		et.begin();
		query = em.createQuery("select p from Product as p where p.qunatityOnHand>50");
		List<Product> listOfQoh = query.getResultList();
		for(Product p : listOfQoh)
		{
			System.out.println(p.getProductId()+" "+p.getProductName());
		}
		et.commit();
	}

	@Override
	public void displayWithDistinct() {

		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Query query = null;
		et.begin();
		query = em.createQuery("select distinct p.category from Product as p");
		List<String> listOfDistinctValues = query.getResultList();
		for(String s : listOfDistinctValues)
		{
			System.out.println(listOfDistinctValues);
		}
		et.commit();
	}

	@Override
	public void displayWithNamedParams() {
		EntityManager em = ProductUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Query query = null;
		et.begin();
		query = em.createQuery("select p from Product as p where p.qunatityOnHand>:vqoh");
		query.setParameter("vqoh", 20);
		List<Product> listofNamedQuery = query.getResultList();
		for(Product p: listofNamedQuery)
		{
			System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getQunatityOnHand());
		}
		et.commit();
	}
	
}
