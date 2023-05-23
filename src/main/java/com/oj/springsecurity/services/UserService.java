package com.oj.springsecurity.services;

import java.util.List;

import com.oj.springsecurity.domain.Role;
import com.oj.springsecurity.domain.User;

public interface UserService {
	
	User saveUser(User user);
	Role saveRole (Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();

}
