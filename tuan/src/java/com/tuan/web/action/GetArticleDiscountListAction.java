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

public class GetArticleDiscountListAction extends BaseAction{
	
	private SpliderService spliderService;

	public void setSpliderService(SpliderService spliderService) {
		this.spliderService = spliderService;
	}

	@Override
	public String getTemplatePath() {
		return "ArticleDiscountList.html";
	}
	
	@Override
	public Map<String, Object> action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer type = 2;
		if("1".equals(request.getParameter("type"))){
			type = 1;
		}
		List<HibernateExpression> ex = new ArrayList<HibernateExpression>();
		ex.add(new CompareExpression("endTime",new Date(),CompareType.Ge));
		List<Article> newList = null;
		if(type == 1){
			ex.add(new CompareExpression("cityId",0,CompareType.Equal));
			newList = spliderService.getArticleList(page,6,"saveMoney",false,ex);
		}else{
			Integer cid = 1;
			String cityId = request.getParameter("cityid");
			if(StringUtils.isNotEmpty(cityId)){
				cid = Integer.parseInt(cityId); 
				//changeCityId(request,response,cid);
			}else{
				cid = getCityId(request);
			}
			ex.add(new CompareExpression("cityId",cid,CompareType.Equal));
			newList = spliderService.getArticleList(page,24,"saveMoney",false,ex);
		}
		
		Map<String, Object> map = new HashMap<String,Object>(); 
		map.put("newList", newList);
	
		return map;
	}
}
