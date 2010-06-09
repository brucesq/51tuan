package com.tuan.splider;

import com.tuan.domain.Article;

public interface ArticleParser {

	public Article parse(String htmlurl, Integer cityId,Integer fromId) throws Exception ; 
}
