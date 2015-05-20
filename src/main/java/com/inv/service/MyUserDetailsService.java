package com.inv.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inv.dao.UserDao;
import com.inv.model.Role;
import com.inv.model.User;
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService{

	//get user from the database, via Hibernate
	@Autowired
	private UserDao userDao;
		
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user=userDao.findByUsername(username);
		List<GrantedAuthority> authorities=buildUserAuthority(user.getRoleList());
		return buildUserForAuthentication(user,authorities);
	}
	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),user.isEnabled(),true,true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Role> roleList) {
		// TODO Auto-generated method stub
		Set<GrantedAuthority> setAuths=new HashSet<GrantedAuthority>();
		for(Role role:roleList){
			setAuths.add(new SimpleGrantedAuthority(role.getRolename()));
		}
		List<GrantedAuthority> result=new ArrayList<GrantedAuthority>(setAuths);
		return result;
	}

}
