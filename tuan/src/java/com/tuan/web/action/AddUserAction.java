/* 
 * AddFeedbackAction.java
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
package com.tuan.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.domain.User;
import com.tuan.service.UserService;
import com.tuan.web.framework.ajax.AjaxAction;
import com.tuan.web.framework.ajax.AjaxServlet;

public class AddUserAction implements AjaxAction {

	private UserService userService;

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setLoginId(request.getParameter("loginid"));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		//user.setCreateTime(new Date());
		user.setStatus(1);
		userService.addUser(user);
		response.setContentType(AjaxServlet.JSON_CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("1");
		out.flush();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}



}
