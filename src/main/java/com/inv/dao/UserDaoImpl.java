package com.inv.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inv.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public User findByUsername(String username){
		List<User> users = new ArrayList<User>();
		 
		users = sessionFactory.openSession()
			.createQuery("from INV_Users where username=:username")
			.setParameter("username", username)
			.list();
 
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
 
	}
}
