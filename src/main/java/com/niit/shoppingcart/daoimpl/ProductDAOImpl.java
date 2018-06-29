package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")  //will create iinstance of ProductDAOImpl and the name will productDAO
public class ProductDAOImpl implements ProductDAO{
	
	
	//first inject hibernate session
	//@Autowire
	
	@Autowired   //seseion factory will automatically inject in the class
	private SessionFactory sessionFactory;
	@Autowired
	private Product product;
	Logger log= LoggerFactory.getLogger(ProductDAOImpl.class);
	public boolean save(Product product) {
		log.debug("Starting of the save method");
		// store in the database.
		try {
			
			sessionFactory.getCurrentSession().save(product);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Product product) {
		log.debug("Starting of the update method");
			
		try {
			sessionFactory.getCurrentSession().update(product);
			log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		// TODO Auto-generated method stub
		
	}

	public Product get(String emailID) {
		log.debug("get method");
		//it will set the record based on emailid and stor in product class
		return sessionFactory.getCurrentSession().get(Product.class, emailID);
	
		
	}

	public boolean delete(String emailID) {
		log.debug("Starting of the delete method");
		try {
			product=get(emailID);
			if(product==null) {
				return false;		
				}
			sessionFactory.getCurrentSession().delete(product);
			log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}

	public List<Product> list() {
		log.debug("list method");
	return	sessionFactory.getCurrentSession().createQuery("from Product").list();
		
	}

	public List<Product> search(String searchString) {
		String hql ="from Product where description like '%"+searchString+"%' or name like '%\" + searchString + \"%'";
		
	return	sessionFactory.getCurrentSession().createQuery(hql).list();
		
	}

	public List<Product> search(String searchString, int maxPrice) {
		// TODO Auto-generated method stub
		
		String hql ="from Product where description like '%"+searchString+"%' and price <"+maxPrice;
		return	sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public List<Product> search(String searchString, int minPrice, int maxPrice) {
	//	select 
		// TODO Auto-generated method stub
		return null;
	}

	

}
