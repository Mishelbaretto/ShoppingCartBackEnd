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


import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("userDAO")  //will create iinstance of UserDAOImpl and the name will userDAO
public class UserDAOImpl implements UserDAO{
	
	private static final Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	//first inject hibernate session
	//@Autowire
	
	@Autowired   //seseion factory will automatically inject in the class
	private SessionFactory sessionFactory;
	@Autowired
	private User user;
	public boolean save(User user) {
		log.debug("starting of the save method");
		// store in the database.
		try {
			user.setRole('C');

			user.setRegisteredDate(new Date(System.currentTimeMillis()) + "");
			sessionFactory.getCurrentSession().save(user);
			log.debug("ending of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(User user) {
		
		log.debug("starting of the update method");

		try {
			sessionFactory.getCurrentSession().update(user);
			log.debug("ending of the update method");

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("error occured in update method"+e.getMessage());
			return false;
		} 
		// TODO Auto-generated method stub
		
	}

	public User get(String emailID) {
		log.debug("starting of the list method");

		//it will set the record based on emailid and stor in user class
		return sessionFactory.getCurrentSession().get(User.class, emailID);
	
		
	}

	public boolean delete(String emailID) {
		try {
			user=get(emailID);
			if(user==null) {
				return false;		
				}
			sessionFactory.getCurrentSession().delete(user);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}

	public List<User> list() {
	return	sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	public User validate(String emailID, String password) {
		//select * from user whre emailid='miss1@gmail.com' and passwors='mis123'
		log.debug("Starting of the validate methid");
		log.info("user"+emailID+"trying to login");
	user=(User) sessionFactory.getCurrentSession().createCriteria(User.class)
	.add(Restrictions.eq("emailID", emailID))
	.add(Restrictions.eq("password", password)).uniqueResult();
	return user;
	}

}
