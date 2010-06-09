/**
 * 
 */
package com.tuan.web.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tuan.web.framework.ajax.AjaxServlet;

/**
 * @author BruceSun
 *
 */
public class HtmlServlet extends BaseServlet {
	
	
	private static final long serialVersionUID = 5756441765846820698L;
	
	private static final Logger LOG = LoggerFactory.getLogger(AjaxServlet.class);
	
	@Override
	protected void service(final HttpServletRequest request, 
            final HttpServletResponse response)
			throws ServletException, IOException{
		long startTime = 0;
		if(LOG.isDebugEnabled()){
			startTime = System.currentTimeMillis();
		}
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();   
		uri = uri.substring(request.getContextPath().length());
		uri = uri.replace("html", "jsp");
		try {
		      getServletConfig().getServletContext().getRequestDispatcher(uri).forward(request,response);
		} catch (Exception e) {
		      LOG.error("ServletException",e);
		} finally{
	        	if(LOG.isDebugEnabled()){
	        		LOG.debug("Time to execute request: " + (System.currentTimeMillis() - startTime) + "ms");
	        	}
	    }
	}
}
