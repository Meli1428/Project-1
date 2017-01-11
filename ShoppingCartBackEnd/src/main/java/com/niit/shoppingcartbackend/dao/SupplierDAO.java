package com.niit.shoppingcartbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcartbackend.model.Supplier;

@Repository

public interface SupplierDAO {
	
	public Supplier getByName(String name);
	public void saveOrUpdate(Supplier supplier);
	public void delete(int id);
	public Supplier get(int id);	
	public List<Supplier>list();

}
