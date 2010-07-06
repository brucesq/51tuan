/* 
 * GetArticleHotListAction.java
 * 
 * Created on 2010-7-6
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hunthawk.framework.hibernate.CompareExpression;
import com.hunthawk.framework.hibernate.CompareType;
import com.hunthawk.framework.hibernate.HibernateExpression;
import com.tuan.domain.Article;
import com.tuan.service.SpliderService;
import com.tuan.web.framework.ajax.BaseAction;

public class GetArticleHotListAction extends BaseAction{
	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}

	@Override
	public String getTemplatePath() {
		return "ArticleHotList.html";
	}
	
	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<HibernateExpression> ex = new ArrayList<HibernateExpression>();
		ex.add(new CompareExpression("endTime",new Date(),CompareType.Ge));
		List<Article> newList = null;
		Integer cid = 1;
		String cityId = request.getParameter("cityid");
		if(StringUtils.isNotEmpty(cityId)){
			cid = Integer.parseInt(cityId); 
		}else{
			cid = getCityId(request);
		}
		ex.add(new CompareExpression("cityId",cid,CompareType.Equal));
		newList = spliderService.getArticleList(1,3,"olderNum",false,ex);
		
		Map<String, Object> map = new HashMap<String,Object>(); 
		map.put("newList", newList);
	
		return map;
	}
}
