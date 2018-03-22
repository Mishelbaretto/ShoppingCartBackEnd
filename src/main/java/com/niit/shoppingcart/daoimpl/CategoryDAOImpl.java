package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO")  //will create iinstance of CategoryDAOImpl and the name will categoryDAO
public class CategoryDAOImpl implements CategoryDAO{
	
	
	//first inject hibernate session
	//@Autowire
	
	@Autowired   //seseion factory will automatically inject in the class
	private SessionFactory sessionFactory;
	@Autowired
	private Category category;
	public boolean save(Category category) {
		// store in the database.
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {
		
			
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		// TODO Auto-generated method stub
		
	}

	public Category get(String emailID) {
		//it will set the record based on emailid and stor in category class
		return sessionFactory.getCurrentSession().get(Category.class, emailID);
	
		
	}

	public boolean delete(String emailID) {
		try {
			category=get(emailID);
			if(category==null) {
				return false;		
				}
			sessionFactory.getCurrentSession().delete(category);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}

	public List<Category> list() {
	return	sessionFactory.getCurrentSession().createQuery("from Category").list();
		
	}

	

}
