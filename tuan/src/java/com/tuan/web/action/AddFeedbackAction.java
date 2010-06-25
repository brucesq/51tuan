/* 
 * AddFeedbackAction.java
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
package com.tuan.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.domain.Feedback;
import com.tuan.service.FeedbackService;
import com.tuan.web.framework.ajax.AjaxAction;
import com.tuan.web.framework.ajax.AjaxServlet;

public class AddFeedbackAction implements AjaxAction {

	private FeedbackService feedbackService;

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Feedback fb = new Feedback();
		fb.setName(request.getParameter("name"));
		fb.setContent(request.getParameter("content"));
		fb.setCreateTime(new Date());
		feedbackService.addFeedback(fb);
		response.setContentType(AjaxServlet.JSON_CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("1");
		out.flush();
	}

	public FeedbackService getFeedbackService() {
		return feedbackService;
	}

	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

}
