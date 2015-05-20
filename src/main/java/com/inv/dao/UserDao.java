package com.inv.dao;

import com.inv.model.User;

public interface UserDao {

	public User findByUsername(String username);
}
