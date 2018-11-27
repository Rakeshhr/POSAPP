package com.cruds.pos.db;

import java.util.List;

import com.cruds.pos.entity.User;

public interface UserDao {
	
	public boolean create(User user);
	public String authenticateUser(String firstName,String password );
	public List<User> getAllUser();
	
}
