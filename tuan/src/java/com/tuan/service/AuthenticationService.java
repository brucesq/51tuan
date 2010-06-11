package com.tuan.service;

import com.tuan.domain.User;
import com.tuan.web.framework.AuthenticationException;

public interface AuthenticationService {

	public User  auth(String username,String password)throws AuthenticationException;
	
	public User getUser(String name);
}
