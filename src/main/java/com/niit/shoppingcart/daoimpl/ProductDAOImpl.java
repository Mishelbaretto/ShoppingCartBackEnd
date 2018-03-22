package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public boolean save(Product product) {
		// store in the database.
		try {
			
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Product product) {
		
			
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		// TODO Auto-generated method stub
		
	}

	public Product get(String emailID) {
		//it will set the record based on emailid and stor in product class
		return sessionFactory.getCurrentSession().get(Product.class, emailID);
	
		
	}

	public boolean delete(String emailID) {
		try {
			product=get(emailID);
			if(product==null) {
				return false;		
				}
			sessionFactory.getCurrentSession().delete(product);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}

	public List<Product> list() {
	return	sessionFactory.getCurrentSession().createQuery("from Product").list();
		
	}

	

}