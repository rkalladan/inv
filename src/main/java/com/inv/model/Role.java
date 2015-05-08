package com.inv.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="INV_Role")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long role_id;
	private String rolename;
	@OneToMany(cascade=CascadeType.ALL,targetEntity=User.class)
	@JoinColumn(name="role_id")
	private Set<User> userroles;
	public long getRole_id() {
		return role_id;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Set<User> getUserroles() {
		return userroles;
	}
	public void setUserroles(Set<User> userroles) {
		this.userroles = userroles;
	}
	
	
}
