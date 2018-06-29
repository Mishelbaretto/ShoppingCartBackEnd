package com.niit.shoppingcart.domain;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Cart implements Serializable  {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String emailID;
	private String productName;
	private int price;
	private int quantity;
	private String productID;
	
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Transient  //we are not going to save this data in table
	private int total;
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = new Random().nextInt();
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
