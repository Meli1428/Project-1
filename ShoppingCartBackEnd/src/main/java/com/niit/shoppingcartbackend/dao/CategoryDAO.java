package com.niit.shoppingcartbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcartbackend.model.Category;

@Repository
public interface CategoryDAO {
	
	public Category getByName(String name);
	public void saveOrUpdate(Category category);
	public void delete(int id);
	public Category get(int id);	
	public List<Category>list();

}
