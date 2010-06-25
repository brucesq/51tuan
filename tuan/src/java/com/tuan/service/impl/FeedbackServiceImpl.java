/* 
 * FeedbackServiceImpl.java
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
package com.tuan.service.impl;

import java.util.List;

import com.hunthawk.framework.HibernateGenericController;
import com.tuan.domain.Feedback;
import com.tuan.service.FeedbackService;

public class FeedbackServiceImpl implements FeedbackService {

	private HibernateGenericController controller;

	public void setHibernateGenericController(
			HibernateGenericController controller) {
		this.controller = controller;
	}
	
	@Override
	public void addFeedback(Feedback feedback) {
		controller.save(feedback);
	}

	@Override
	public List<Feedback> getFeedbackList() {
		return controller.getAll(Feedback.class);
	}

}
