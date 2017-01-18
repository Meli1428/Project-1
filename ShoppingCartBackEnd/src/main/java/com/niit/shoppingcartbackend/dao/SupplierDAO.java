package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.model.Supplier;


public interface SupplierDAO {
	
	public Supplier getByName(String name);
	public void saveOrUpdate(Supplier supplier);
	public void delete(int id);
	public Supplier get(int id);	
	public List<Supplier>list();

}
