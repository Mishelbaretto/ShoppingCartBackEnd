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


import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Transactional
@Repository("supplierDAO")  //will create iinstance of SupplierDAOImpl and the name will supplierDAO
public class SupplierDAOImpl implements SupplierDAO{
	
	
	//first inject hibernate session
	//@Autowire
	
	@Autowired   //seseion factory will automatically inject in the class
	private SessionFactory sessionFactory;
	@Autowired
	private Supplier supplier;

	Logger log= LoggerFactory.getLogger(SupplierDAOImpl.class);
	public boolean save(Supplier supplier) {
		log.debug("Starting of the save method");
		// store in the database.
		try {
			sessionFactory.getCurrentSession().save(supplier);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Supplier supplier) {
		
		log.debug("Starting of the update method");
		try {
			sessionFactory.getCurrentSession().update(supplier);
			log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		// TODO Auto-generated method stub
		
	}

	public Supplier get(String emailID) {
		log.debug("Get method");
		//it will set the record based on emailid and stor in supplier class
		return sessionFactory.getCurrentSession().get(Supplier.class, emailID);
	
		
	}

	public boolean delete(String emailID) {
		log.debug("Starting of the delete method");
		try {
			supplier=get(emailID);
			if(supplier==null) {
				return false;		
				}
			sessionFactory.getCurrentSession().delete(supplier);
			log.debug("Ending of the delete method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}

	public List<Supplier> list() {
		log.debug("List method");
	return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		
	}

	
}
