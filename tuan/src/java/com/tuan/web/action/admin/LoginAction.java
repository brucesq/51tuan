/**
 * 
 */
package com.tuan.web.action.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.domain.User;
import com.tuan.service.AuthenticationService;
import com.tuan.web.framework.AuthenticationException;
import com.tuan.web.framework.AuthenticationHelper;
import com.tuan.web.framework.ajax.BaseAction;

/**
 * @author sunquanzhi
 *
 */
public class LoginAction extends BaseAction {

	private AuthenticationService authService; 
	
	public AuthenticationService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthenticationService authService) {
		this.authService = authService;
	}

	@Override
	public String getTemplatePath() {
		return "login.json";
	}
	
	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		String message = "Login successful";
		Boolean result = true;
		try {
			user = authService.auth(username, password);
		} catch (AuthenticationException e) {
			message = e.getMessage();
			result = false;
		}
		if(user != null){
			AuthenticationHelper.setCurrentUser(request,response,user);
		}
		Map<String,Object> map = new HashMap<String,Object>(2);	
		map.put("message", message);
		map.put("result", result.toString());
		return map;
	}

}
