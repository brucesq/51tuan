/**
 * 
 */
package com.tuan.web.framework;

/**
 * Authentication Exception
 * @author BruceSun
 *
 */
public class AuthenticationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6109818325910655494L;

	/**
     * Constructs a AuthenticationException object with a message.
     * 
     * @param msg
     *            a description of the exception
     */
    public AuthenticationException(String msg) {
        super(msg);
    }
}
