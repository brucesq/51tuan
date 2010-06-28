/**
 * 
 */
package com.tuan.splider.parser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.hunthawk.reader.enhance.util.ToolDateUtil;
import com.tuan.domain.Article;
import com.tuan.splider.ArticleParser;
import com.tuan.util.IoUtils;

/**
 * @author sunquanzhi
 * 
 */
public class SohutuanParser implements ArticleParser {

	public Article parse(String htmlurl, Integer cityId, Integer fromId)
			throws Exception {

		URL url = new URL(htmlurl);
		URLConnection urlcon = url.openConnection();
		urlcon.setConnectTimeout(10000);
		urlcon.setReadTimeout(10000);
		urlcon.setDoOutput(true);
		HttpURLConnection httpConn = (HttpURLConnection) urlcon;
		httpConn.setInstanceFollowRedirects(false);
		httpConn.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
		InputStream in = null;
		in = httpConn.getInputStream();
		String content = IoUtils.pipe(in, "gbk");

		Article article = new Article();
		article.setUrl(htmlurl);
		article.setCategoryId(1);
		article.setCityId(cityId);

		Date date = new Date();
		date = DateUtils.addDays(date, 1);
		String strDate = ToolDateUtil.dateToString(date, "yyyyMMdd");
		date = ToolDateUtil.stringToDate(strDate, "yyyyMMdd");

		article.setEndTime(date);
		article.setFromId(fromId);
		parserContent(content, article);
		return article;
	}

	public static void parserContent(String content, Article article) {
		int index = content.indexOf("class=\"box clear\"");
		if (index > 0) {
			content = content.substring(index + 16);
			index = content.indexOf("<h2>");

			if (index >= 0) {
				content = content.substring(index + 4);

				index = content.indexOf("</h2>");
				String title = content.substring(0, index);
				System.out.println(title);
				article.setName(title);
			}

		}
		index = content.indexOf("class=\"lboxA borbox\"");
		if (index > 0) {
			content = content.substring(index + 20);
			index = content.indexOf("<p>");
			if (index > 0) {
				content = content.substring(index + 3);
				index = content.indexOf("</p>");
				String oldPrice = content.substring(0, index);
				content = content.substring(index + 4);
				oldPrice = getPrice(oldPrice);
				System.out.println(oldPrice);
				article.setOriginalPrice(oldPrice);
			}
			index = content.indexOf("<p>");
			if (index >= 0) {
				content = content.substring(index + 3);
				index = content.indexOf("</p>");
				String discount = content.substring(0, index);
				System.out.println(discount);
				article.setDiscount(discount);

			}
			index = content.indexOf("<p>");
			if (index >= 0) {
				content = content.substring(index + 3);
				index = content.indexOf("</p>");
				String saveMoney = content.substring(0, index);
				saveMoney = getPrice(saveMoney);
				System.out.println(saveMoney);
				article.setSaveMoney(saveMoney);

			}
			String nowPrice = String.valueOf((Integer.parseInt(article
					.getOriginalPrice()) - Integer.parseInt(article
					.getSaveMoney())));

			System.out.println(nowPrice);
			article.setNowPrice(nowPrice);

			index = content.indexOf("class=\"boxA_r\"");
			if (index >= 0) {
				content = content.substring(index + 14);
				index = content.indexOf("src=\"");
				content = content.substring(index + 5);
				index = content.indexOf("\"");
				String url = content.substring(0, index);
				 System.out.println(url);
				article.setImgurl(url);

			}
		}

	}

	private static String getPrice(String str) {
		int index = str.indexOf("￥");
		if (index >= 0) {
			str = str.substring(index + 1);
			String price = "";
			for (int i = 0; i < str.length(); i++) {
				if (StringUtils.isNumeric("" + str.charAt(i))) {
					price += str.charAt(i);
				} else {
					continue;
				}
			}
			str = price;
		}
		return str;
	}

	public static void main(String[] args) throws Exception {
		SohutuanParser p = new SohutuanParser();
		p.parse("http://ihome.sohu.com/today/", 1, 5);
	}
}