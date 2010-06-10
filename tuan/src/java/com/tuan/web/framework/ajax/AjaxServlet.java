/**
 * 
 */
package com.tuan.web.framework.ajax;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tuan.web.framework.BaseServlet;
import com.tuan.web.framework.WebException;

/**
 * Base ajax servlet.
 * @author BruceSun
 *
 */
public class AjaxServlet extends BaseServlet {

	private static final long serialVersionUID = 790607863452082626L;
	
	private static final Logger LOG = LoggerFactory.getLogger(AjaxServlet.class);
	
	public static final String JSON_CONTENT_TYPE = "text/javascript; charset=utf-8";
	
	private static final String ACTION_BEAN = "Action";
	
	@Override
	protected void service(final HttpServletRequest request, 
            final HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("asdasd");
		long startTime = 0;
		if(LOG.isDebugEnabled()){
			startTime = System.currentTimeMillis();
		}
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();      
		setNoCacheHeaders(response);
		setLanguageFromRequestHeader(request);
		uri = uri.substring(request.getContextPath().length() + "/".length());
        final String[] tokens = uri.split("/");
        try{
        	if(tokens.length < 2)
        	{
        		throw new WebException("Servlet URL did not contain command args: " + uri);
        	}
        	String actionName = tokens[1];
        	AjaxAction command = getAction(request.getSession().getServletContext(),actionName);
        	if(command == null)
        		throw new WebException("Unrecognised command received: " + actionName);
        	System.out.println("ex:"+actionName);
        	command.execute(request, response);
        }catch(Exception e){
        	handleError(response,e);
        }finally{
        	if(LOG.isDebugEnabled()){
        		LOG.debug("Time to execute command: "+ request.getRequestURL()+"?"+(request.getQueryString() == null ? "": request.getQueryString())+ " " + (System.currentTimeMillis() - startTime) + "ms");
        	}
        }
			
	}
	
	private AjaxAction getAction(ServletContext sc,String actionName){
		WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		return (AjaxAction)wc.getBean(actionName+ACTION_BEAN);
	}
	
	/**
	 * Handle any error
	 * @param response
	 * @param cause
	 * @throws ServletException
	 * @throws Exception
	 */
	protected void handleError(HttpServletResponse response, Exception cause){  
		cause.printStackTrace();
		System.out.println("asdasderrot");
		
		//If response is not committed.
		if (!response.isCommitted()){
	         if (LOG.isDebugEnabled()){
	            LOG.debug("ERROR:",cause);
	            Throwable theCause = cause.getCause();
	            if (theCause != null){
	            	LOG.debug("Caused by: ", theCause);
	            }
	         }
	         String msg = cause.getMessage();
	         if (msg == null){
	            msg = cause.toString();
	         }
	         
	         // send the error
	         try{
	        	 response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, msg);
	         }catch(Exception e){
	        	 
	         }
	     }else{
	    	  if (LOG.isDebugEnabled())
		         {
		            LOG.debug("ERROR:",cause);
		            Throwable theCause = cause.getCause();
		            if (theCause != null)
		            {
		            	LOG.debug("Caused by: ", theCause);
		            }
		         }
	      }
	   }
}
