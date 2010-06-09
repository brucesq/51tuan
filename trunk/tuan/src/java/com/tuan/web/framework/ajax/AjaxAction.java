/**
 * 
 */
package com.tuan.web.framework.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author BruceSun
 *
 */
public interface AjaxAction {
	
	
	
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) 
	         throws ServletException, IOException;
}
