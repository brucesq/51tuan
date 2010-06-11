/**
 * 
 */
package com.tuan.service.impl;

import com.tuan.domain.User;
import com.tuan.service.AuthenticationService;
import com.tuan.web.framework.AuthenticationException;

/**
 * @author sunquanzhi
 *
 */
public class AuthenticationServiceImpl implements AuthenticationService {

	public User  auth(String username,String password)throws AuthenticationException{
		if(username.equals("admin")&&password.equals("123456")){
			User user = new User();
			user.setName(username);
			user.setPassword(password);
			return user;
		}
		throw new AuthenticationException("”√ªß√˚√‹¬Î¥ÌŒÛ");
	}
	
	public User getUser(String username){
		if(username.equals("admin")){
			User user = new User();
			user.setName(username);
			user.setPassword("123456");
			return user;
		}
		return null;
	}
}
