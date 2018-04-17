package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Cart;
//DAO-data access object

public interface CartDAO {
	//declare the methods
	
	//create new cart
	public boolean save(Cart cart);
	
	//update the existing cart
	
	public boolean update(Cart cart);
	
	
	//relate to order
	public boolean update(String emailID);
	
	//get the cart details
	
	public  Cart   get(int id);
	
	//delete the cart
	
	public  boolean delete(int id);
	
	//to get all the cart added by a particular user
	public  List<Cart>   list(String emailID);
	
	
	
	

}
