package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;

	
	@BeforeClass
	public static void init() {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO =(SupplierDAO)context.getBean("supplierDAO");
		supplier=(Supplier)context.getBean("supplier");
		
	}
	@Test
	public void saveSupplierTestCase() {
	supplier=new Supplier();
	supplier.setId("SUP-001");
	supplier.setName("BigC");
	supplier.setAddress("NH33,Chennai");
		
		boolean status =  supplierDAO.save(supplier);
		assertEquals("save supplier test case", true , status);
		
	}
	@Test
	public void updateSupplierTestCase() {
		supplier=new Supplier();
		supplier.setId("SUP-001");
		supplier.setName("BigC");
		supplier.setAddress("Warli,Mumbai");
	boolean status=supplierDAO.update(supplier);
	assertEquals("update test case",true,status);
	}
	
	@Test
	public void getSupplierSuccessTestCase() {
		
	supplier=	supplierDAO.get("SUP-001");
	assertNotNull("get supplier test case", supplier);
	}
	
	@Test
	public void getSupplierFailureTestCase() {
		
	supplier=	supplierDAO.get("SUP-001");
	assertNull("get supplier test case", supplier);
	}
	@Test
	public void deleteSupplierSuccessTestCase() {
		boolean status= supplierDAO.delete("SUP-001");
		assertEquals("delete supplier test case",true, status);
	}
	
	@Test
	public void deleteSupplierFailureTestCase() {
		boolean status= supplierDAO.delete("SUP-001");
		assertEquals("delete supplier test case",false, status);
	}
	
	@Test
	public void getAllSupplierTestCase() {
		List<Supplier> suppliers=supplierDAO.list();
		assertEquals("get all suppliers",1,suppliers.size());
	}
	
	
	
}
