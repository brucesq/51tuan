/**
 * 
 */
package com.tuan.web.framework;

/**
 * Web exception.
 * @author BruceSun
 *
 */
public class WebException extends Exception {

	
	private static final long serialVersionUID = 1315140201522815272L;

	/**
     * Constructs a DataException object with a message.
     * 
     * @param msg
     *            a description of the exception
     */
    public WebException(String msg) {
        super(msg);
    }
}
