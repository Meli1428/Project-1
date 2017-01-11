package com.niit.shoppingcartbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcartbackend.model.User;

@Repository
public interface UserDAO {
	
	public boolean isValid(String id,String password); //checking whether the credentials are valid or not
	public boolean saveOrUpdate(User user);
	public boolean delete(User user);
	public User get(String email); //getting user based on id
	public List<User> list(); //get info from all users
	

}
