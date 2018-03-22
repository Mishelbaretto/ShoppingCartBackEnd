package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static User user;

	
	@BeforeClass
	public static void init() {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO =(UserDAO)context.getBean("userDAO");
		user=(User)context.getBean("user");
		
	}
	@Test
	public void saveUserTestCase() {
	user=new User();
		user.setEmailID("isha1@gmail.com");
		user.setMobile("7788778812");
		user.setName("Isha");
		user.setPassword("isha@123");
		
		boolean status =  userDAO.save(user);
		assertEquals("save user test case", true , status);
		
	}
	@Test
	public void updateUserTestCase() {
		user=new User();
		user.setEmailID("isha1@gmail.com");
		user.setMobile("788888887");
		user.setName("Isha");
		user.setPassword("isha@123");
	boolean status=userDAO.update(user);
	assertEquals("update test case",true,status);
	}
	
	@Test
	public void getUserSuccessTestCase() {
		
	user=	userDAO.get("mish@gmail.com");
	assertNotNull("get user test case", user);
	}
	
	@Test
	public void getUserFailureTestCase() {
		
	user=	userDAO.get("jaya@gmail.com");
	assertNull("get user test case", user);
	}
	@Test
	public void deleteUserSuccessTestCase() {
		boolean status= userDAO.delete("isha1@gmail.com");
		assertEquals("delete user test case",true, status);
	}
	
	@Test
	public void deleteUserFailureTestCase() {
		boolean status= userDAO.delete("arpith@gmail.com");
		assertEquals("delete user test case",false, status);
	}
	
	@Test
	public void getAllUserTestCase() {
		List<User> users=userDAO.list();
		assertEquals("get all users",6,users.size());
	}
	@Test
	public void validateCredentialsTestCase() {
	user=	userDAO.validate("mish@gmail.com", "mis@123");
	assertNotNull("validate test case",user);
	}
	
	
}
