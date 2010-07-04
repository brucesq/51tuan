/**
 * 
 */
package com.tuan.service;

import java.util.Collection;
import java.util.List;

import com.hunthawk.framework.hibernate.HibernateExpression;
import com.tuan.domain.Article;
import com.tuan.domain.SpliderItem;

/**
 * @author sunquanzhi
 * 
 */
public interface SpliderService {

	public List<SpliderItem> getSpliderItems();

	public void addArticle(Article article);
	
	public void updateArticle(Article article);

	public List<Article> getArticleList(int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions);

	public Long getArticleListCount(Collection<HibernateExpression> expressions);

	public List<SpliderItem> getSpliderItem(int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions);

	public Long getSpliderItemCount(Collection<HibernateExpression> expressions);

	public SpliderItem getSpliderItem(Integer id);

	public void addSpliderItem(SpliderItem item);

	public void editSpliderItem(SpliderItem item);

	public Article getArticle(Integer id);

	public void editArticle(Article item);
	
	public List<Article> getArticleDiscountList(int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions);
}
