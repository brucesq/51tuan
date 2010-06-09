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
	
	public List<Article> getArticleList(int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions);
}
