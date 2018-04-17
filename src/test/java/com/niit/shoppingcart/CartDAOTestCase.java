package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

public class CartDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static CartDAO cartDAO;
	
	@Autowired
	private static Cart cart;

	
	@BeforeClass
	public static void init() {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO =(CartDAO)context.getBean("cartDAO");
		cart=(Cart)context.getBean("cart");
		
	}
	@Test
	public void saveCartTestCase() {
	cart=new Cart();
	cart.setId();
	cart.setEmailID("rita@gmail.com");
	cart.setProductName("Complete References");
	cart.setProductID("JavaBook1");
	cart.setPrice(3000);
	cart.setQuantity(1);
		
	boolean status =  cartDAO.save(cart);
	assertEquals("save cart test case", true , status);
		
	}
	@Test
	public void updateCartTestCase() {
		cart=new Cart();
		
		cart.setEmailID("abc@gmail.com");
		cart.setProductName("New Fan");
		cart.setProductID("Fan002");
		cart.setPrice(300);
		cart.setQuantity(1);
	boolean status=cartDAO.update(cart);
	assertEquals("update test case",true,status);
	}
	
	@Test
	public void getCartSuccessTestCase() {
		
	cart=	cartDAO.get(1);
	assertNotNull("get cart test case", cart);
	}
	
	@Test
	public void getCartFailureTestCase() {
		
	cart=	cartDAO.get(2);
	assertNull("get cart test case", cart);
	}
	@Test
	public void deleteCartSuccessTestCase() {
		boolean status= cartDAO.delete(9);
		assertEquals("delete cart test case",true, status);
	}
	
	@Test
	public void deleteCartFailureTestCase() {
		boolean status= cartDAO.delete(9);
		assertEquals("delete cart test case",false, status);
	}
	
	@Test
	public void getAllCartTestCase() {
		List<Cart> carts=cartDAO.list("isha@gmail.com");
		assertEquals("get all carts",2,carts.size());
	}
	
	
	
}
