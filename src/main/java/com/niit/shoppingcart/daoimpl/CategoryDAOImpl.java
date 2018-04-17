package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger log= LoggerFactory.getLogger(CategoryDAOImpl.class);
	public boolean save(Category category) {
		log.debug("Starting of the save method");
		// store in the database.
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {
		
		log.debug("Starting of the update method");
		try {
			sessionFactory.getCurrentSession().update(category);
			log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		// TODO Auto-generated method stub
		
	}

	public Category get(String emailID) {
		log.debug("get method");
		//it will set the record based on emailid and stor in category class
		return sessionFactory.getCurrentSession().get(Category.class, emailID);
	
		
	}

	public boolean delete(String emailID) {
		log.debug("Starting of the delete method");
		try {
			category=get(emailID);
			if(category==null) {
				return false;		
				}
			sessionFactory.getCurrentSession().delete(category);
			log.debug("Ending of the delete method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}

	public List<Category> list() {
	//return	sessionFactory.getCurrentSession().createQuery("from Category").list();
		log.debug("List method");
		return (List<Category>)
				sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	

}
