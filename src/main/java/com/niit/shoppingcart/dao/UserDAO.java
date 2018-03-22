package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;
//DAO-data access object

public interface UserDAO {
	//declare the methods
	
	//create new user
	public boolean save(User user);
	
	//update the existing user
	
	public boolean update(User user);
	
	
	//get the user details
	
	public  User   get(String emailID);
	
	//delete the user
	
	public  boolean delete(String emailID);
	
	//to get all the user
	public  List<User>   list();
	
	//validate the credentials crrec or not
	public   User    validate(String emailID,String password);
	

}
