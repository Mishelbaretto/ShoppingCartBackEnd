package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;
//DAO-data access object

public interface SupplierDAO {
	//declare the methods
	
	//create new supplier
	public boolean save(Supplier supplier);
	
	//update the existing supplier
	
	public boolean update(Supplier supplier);
	
	
	//get the supplier details
	
	public  Supplier   get(String id);
	
	//delete the supplier
	
	public  boolean delete(String id);
	
	//to get all the supplier
	public  List<Supplier>   list();
	
	//validate the credentials crrec or not
	
	

}
