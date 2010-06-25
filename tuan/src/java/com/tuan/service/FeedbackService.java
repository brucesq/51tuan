/* 
 * FeedbackService.java
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
package com.tuan.service;

import java.util.List;

import com.tuan.domain.Feedback;

public interface FeedbackService {

	public void addFeedback(Feedback feedback);
	
	public List<Feedback> getFeedbackList();
}
