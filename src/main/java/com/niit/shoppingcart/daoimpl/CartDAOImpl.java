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


import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

@Transactional
@Repository("cartDAO")  //will create iinstance of CartDAOImpl and the name will cartDAO
public class CartDAOImpl implements CartDAO{
	
	
	//first inject hibernate session
	//@Autowire
	
	@Autowired   //seseion factory will automatically inject in the class
	private SessionFactory sessionFactory;
	@Autowired
	private Cart cart;
	
	Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	public boolean save(Cart cart) {
		log.debug("Starting of the save method");
		// store in the database.
		try {
			
			sessionFactory.getCurrentSession().save(cart);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Cart cart) {
		log.debug("Starting of the update method");
			
		try {
			
			sessionFactory.getCurrentSession().update(cart);
			log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	

	
	public List<Cart> list(String emailID) {
		log.debug("Starting of the list method");
	return	sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("emailID", emailID)).list();
		
	}

	
	
	public boolean update(String emailID) {
		log.debug("Starting of the method update");
		log.debug("Goiig to place order of "  + emailID);
		String hql="update Cart set status='O' where emailid='"+emailID+"'";
		try {
			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			log.debug("Ending of the method update");
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Cart get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Cart.class, id);
		
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		log.debug("Starting of the delete method");
		try{
			cart= get(id);
			if (cart== null){
				return false;}
			else
			{sessionFactory.getCurrentSession().delete(cart);
			log.debug("Ending of the delete method");
			return true;}
		} 
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}
	

	

}
