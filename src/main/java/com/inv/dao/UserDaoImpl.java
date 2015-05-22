package com.inv.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		 System.out.println("===="+username);
		 Criteria criteria=sessionFactory.openSession().createCriteria(User.class);
		 criteria.add(Restrictions.eq("username", username));
		 users=criteria.list();
		System.out.println("====="+users.get(0).getPassword()+"==="+users.get(0).getRoleList().toString());
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
 
	}
}
