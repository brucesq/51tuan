/* 
 * FeedbackServiceImpl.java
 * 
 * Created on 2010-6-25
 * 
 * Copyright(C) 2010, by Ambow Develop & Research Branch.
 * 
 * Original Author: liujia
 * Contributor(s):
 * 
 * Changes 
 * -------
 * $Log$
 */
package com.tuan.service.impl;

import java.util.List;

import com.hunthawk.framework.HibernateGenericController;
import com.tuan.domain.Feedback;
import com.tuan.domain.User;
import com.tuan.service.UserService;

public class UserServiceImpl implements UserService {

	private HibernateGenericController controller;

	public void setHibernateGenericController(
			HibernateGenericController controller) {
		this.controller = controller;
	}
	
	@Override
	public void addUser(User user) {
		controller.save(user);
	}

	@Override
	public List<User> getUserList() {
		return controller.getAll(User.class);
	}

}
