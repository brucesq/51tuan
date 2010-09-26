/**
 * 
 */
package com.tuan.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hunthawk.framework.HibernateGenericController;
import com.hunthawk.framework.hibernate.CompareExpression;
import com.hunthawk.framework.hibernate.CompareType;
import com.hunthawk.framework.hibernate.HibernateExpression;
import com.tuan.domain.Article;
import com.tuan.domain.SpliderItem;
import com.tuan.service.SpliderService;
import com.tuan.util.StringUtil;

/**
 * @author sunquanzhi
 * 
 */
public class SpliderServiceImpl implements SpliderService {

	private HibernateGenericController controller;

	public void setHibernateGenericController(
			HibernateGenericController controller) {
		this.controller = controller;
	}

	public List<SpliderItem> getSpliderItems() {
		Collection<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		return controller.findBy(SpliderItem.class, 1, 100000, "id", true,
				expressions);
	}

	public void addArticle(Article article) {
		article.setOlderNum(StringUtil.getRandom(50, 300));
		article.setName(StringUtil.trimHref(article.getName()));
		controller.save(article);
	}

	public void updateArticle(Article article) {
		Collection<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new CompareExpression("endTime", article.getEndTime(),
				CompareType.Equal));
		expressions.add(new CompareExpression("cityId", article.getCityId(),
				CompareType.Equal));
		expressions.add(new CompareExpression("fromId", article.getFromId(),
				CompareType.Equal));
		expressions.add(new CompareExpression("url", article.getUrl(),
				CompareType.Equal));
		List<Article> articles = controller.findBy(Article.class, 1, 1, "id",
				false, expressions);
		if (articles.size() > 0) {
			article.setName(StringUtil.trimHref(article.getName()));
			article.setOlderNum(articles.get(0).getOlderNum());
			article.setId(articles.get(0).getId());
			controller.update(article);
			// System.out.println("UPDATE:"+article.getId());
		} else {
			addArticle(article);
			// System.out.println("ADD:"+article.getId());
		}
	}

	public List<Article> getArticleList(int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions) {
		return controller.findBy(Article.class, pageNo, pageSize, orderBy,
				isAsc, expressions);
	}

	public Long getArticleListCount(Collection<HibernateExpression> expressions) {
		return controller.getResultCount(Article.class, expressions);
	}

	public SpliderItem getSpliderItem(Integer id) {
		return controller.get(SpliderItem.class, id);
	}

	public void addSpliderItem(SpliderItem item) {
		controller.save(item);
	}

	public void editSpliderItem(SpliderItem item) {
		controller.update(item);
	}

	public List<SpliderItem> getSpliderItem(int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions) {
		return controller.findBy(SpliderItem.class, pageNo, pageSize, orderBy,
				isAsc, expressions);
	}

	public Long getSpliderItemCount(Collection<HibernateExpression> expressions) {
		return controller.getResultCount(SpliderItem.class, expressions);
	}

	public Article getArticle(Integer id) {
		return controller.get(Article.class, id);
	}

	public void editArticle(Article item) {
		controller.update(item);
	}

	
	public List<Article> getArticleListByHql(String hql, Object[] values,
			int pageNo, int pageSize) {
		return controller.findBy(hql, pageNo, pageSize, values);
	}
}
