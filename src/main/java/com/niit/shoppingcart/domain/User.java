package com.niit.shoppingcart.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;




//whenevr it scan all the classes under particular pkg will create instance of this class


@Component //to create instance
@Entity  //to specify it is not normal class --it is data base entity

@Table(name="user")     //to specify t which database

public class User {
	@Id
	private String emailID;//email is primary key
	
	@Column
	private String name;
	private String password;
	private String mobile;
	private Character role;
	private String	registeredDate;
	
	
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Character getRole() {
		return role;
	}
	public void setRole(Character role) {
		this.role = 'C';
	}
	public String getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = new Date(System.currentTimeMillis())+"";
	}
	

}
