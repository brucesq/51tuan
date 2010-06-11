/**
 * 
 */
package com.tuan.web.framework;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tuan.domain.User;
import com.tuan.service.AuthenticationService;

//import com.banckle.email.services.User;
//import com.banckle.email.web.services.AuthenticationService;

/**
 * Helper to authenticate
 * @author BruceSun
 *
 */
public final class AuthenticationHelper {

	 /** 
	  * Cookie names. 
	  */
	 private static final String COOKIE_BANCKLE_USER = "banckleUser";
	 /**
	  * Session names.
	  */
	 private static final String AUTHENTICATION_USER = "banckle_user";
	 /**
	  * Auth service bean name.
	  */
	 private static final String AUTHENTICATION_SERVICE = "authService";
	
	 /**
	  * Get current user, first from session,if not get from cookie.
	  * @param req
	  * @return
	  */
	 public static User getCurrentUser(HttpServletRequest req){
		 User user = (User)req.getSession().getAttribute(AUTHENTICATION_USER);
		 if(user == null){
			 Cookie authCookie = getAuthCookie(req);
			 if(authCookie != null){
				 String username = authCookie.getValue();
				 WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(req.getSession().getServletContext()); 
				 AuthenticationService authService = (AuthenticationService)wc.getBean(AUTHENTICATION_SERVICE);
				 user = authService.getUser(username);
				 req.getSession().setAttribute(AUTHENTICATION_USER, user);
			 }
		 }
		 return user; 
	 }
	 /**
	  * Set current user,session and cookie.
	  * @param req
	  * @param res
	  * @param user
	  */
	 public static void setCurrentUser(HttpServletRequest req,HttpServletResponse res,User user){
		 req.getSession().setAttribute(AUTHENTICATION_USER, user);
		 setUsernameCookie(req,res,user.getName());
	 }
	 /**
	    * Helper to return the banckle auth cookie. The cookie saves the last used username value.
	    * 
	    * @param httpRequest
	    * 
	    * @return Cookie if found or null if not present
	    */
	 public static Cookie getAuthCookie(HttpServletRequest req){
	      Cookie authCookie = null;
	      Cookie[] cookies = req.getCookies();
	      if (cookies != null){
	    	 int len = cookies.length;
	         for (int i=0; i<len; i++){
	            if (COOKIE_BANCKLE_USER.equals(cookies[i].getName())){
	               // found cookie
	               authCookie = cookies[i];
	               break;
	            }
	         }
	      }
	      return authCookie;
	 }
	 /**
	  * Helper to remove the username cookie value if explicit logout was requested by the user
	  * @param req
	  * @param res
	  */
	 public static void logout(HttpServletRequest req, HttpServletResponse res){
		 Cookie authCookie = getAuthCookie(req);
		 if(authCookie != null){
			 authCookie.setMaxAge(0);
			 res.addCookie(authCookie);
		 }
		 req.getSession().invalidate();
	 }
	 /**
	  * Set the username cookie
	  * @param req
	  * @param res
	  * @param username
	  */
	 public static void setUsernameCookie(HttpServletRequest req, HttpServletResponse res,String username){
		 Cookie authCookie = getAuthCookie(req);
	      if (authCookie == null)
	      {
	         authCookie = new Cookie(COOKIE_BANCKLE_USER, username);
	      }
	      else
	      {
	         authCookie.setValue(username);
	      }
	      authCookie.setPath(req.getContextPath());
	      authCookie.setMaxAge(7*24*60*60);
	      res.addCookie(authCookie);
	 }
}
