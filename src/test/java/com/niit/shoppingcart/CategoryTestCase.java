package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;

	
	@BeforeClass
	public static void init() {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO =(CategoryDAO)context.getBean("categoryDAO");
		category=(Category)context.getBean("category");
		
	}
	@Test
	public void saveCategoryTestCase() {
	category=new Category();
		category.setId("MenCategory-001");
		category.setName("Men");
		category.setDescription("This is men category");
		
		boolean status =  categoryDAO.save(category);
		assertEquals("save category test case", true , status);
		
	}
	@Test
	public void updateCategoryTestCase() {
		category=new Category();
		category.setId("Mob-001");
		category.setName("Mobile");
		category.setDescription("This is mobile category");
	boolean status=categoryDAO.update(category);
	assertEquals("update test case",true,status);
	}
	
	@Test
	public void getCategorySuccessTestCase() {
		
	category=	categoryDAO.get("mish@gmail.com");
	assertNotNull("get category test case", category);
	}
	
	@Test
	public void getCategoryFailureTestCase() {
		
	category=	categoryDAO.get("jaya@gmail.com");
	assertNull("get category test case", category);
	}
	@Test
	public void deleteCategorySuccessTestCase() {
		boolean status= categoryDAO.delete("miss1@gmail.com");
		assertEquals("delete category test case",true, status);
	}
	
	@Test
	public void deleteCategoryFailureTestCase() {
		boolean status= categoryDAO.delete("arpith@gmail.com");
		assertEquals("delete category test case",false, status);
	}
	
	@Test
	public void getAllCategoryTestCase() {
		List<Category> categorys=categoryDAO.list();
		assertEquals("get all categorys",4,categorys.size());
	}
	
	
	
}
