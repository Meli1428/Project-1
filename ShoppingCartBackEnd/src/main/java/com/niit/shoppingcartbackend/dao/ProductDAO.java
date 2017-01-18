package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.model.Product;

public interface ProductDAO {
	
	public Product getByName(String name);
	public void saveOrUpdate(Product product);
	public void delete(int id);
	public Product get(int id);
	public List<Product> list();

}
