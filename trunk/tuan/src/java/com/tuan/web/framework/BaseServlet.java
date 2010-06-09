/**
 * 
 */
package com.tuan.web.framework;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.util.I18NUtil;

/**
 * @author BruceSun
 *
 */
public abstract class BaseServlet extends HttpServlet {

	/**
     * Apply the headers required to disallow caching of the response in the browser
     */
    public static void setNoCacheHeaders(HttpServletResponse response)
    {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
    }
    
   /**
    * Apply Client and Repository language locale based on the 'Accept-Language' request header
    */
   public static void setLanguageFromRequestHeader(HttpServletRequest req)
   {
      // set language locale from browser header
      String acceptLang = req.getHeader("Accept-Language");
      if (acceptLang != null && acceptLang.length() != 0)
      {
         StringTokenizer t = new StringTokenizer(acceptLang, ",; ");
         // get language and convert to java locale format
         String language = t.nextToken().replace('-', '_');
         I18NUtil.setLocale(I18NUtil.parseLocale(language));
      }
   }
}
