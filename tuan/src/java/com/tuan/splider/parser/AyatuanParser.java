/**
 * 
 */
package com.tuan.splider.parser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
public class AyatuanParser implements ArticleParser {

	public static Map<Integer,Integer> cityMap = new HashMap<Integer,Integer>();
	static{
		cityMap.put(1, 1);
		cityMap.put(2, 2);
		cityMap.put(3, 21);
		cityMap.put(4, 5);
		cityMap.put(5, 48);
		cityMap.put(6, 41);
		cityMap.put(7, 12);
		cityMap.put(8, 260);
		cityMap.put(9, 24);
		cityMap.put(10, 19);
		cityMap.put(11, 16);
		cityMap.put(12, 27);
		cityMap.put(13, 13);
		cityMap.put(14, 47);
		cityMap.put(15, 3);
		cityMap.put(16, 32);
		cityMap.put(17, 15);
		cityMap.put(18, 335);
		cityMap.put(19, 184);
		cityMap.put(20, 22);
		cityMap.put(21, 395);
		cityMap.put(22, 399);
		cityMap.put(23, 260);
		cityMap.put(24, 26);
		cityMap.put(25, 23);
		cityMap.put(26, 30);
		cityMap.put(27, 14);
	}
	
	public Article parse(String htmlurl, Integer cityId, Integer fromId)
			throws Exception {

		URL url = new URL("http://www.ayatuan.com/");
		URLConnection urlcon = url.openConnection();
		urlcon.setConnectTimeout(10000);
		urlcon.setReadTimeout(10000);
		urlcon.setDoOutput(true);
		HttpURLConnection httpConn = (HttpURLConnection) urlcon;
		httpConn.setInstanceFollowRedirects(false);
		httpConn.addRequestProperty("Cookie", "b3ab_city="+cityMap.get(cityId)+";"); 
		httpConn.setRequestProperty("user-agent",
			"Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
		InputStream in = null;
		in = httpConn.getInputStream();
		String content = IoUtils.pipe(in, "utf-8");

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
		int index = content.indexOf("class=\"deal-today-link\"");
		if (index > 0) {
			content = content.substring(index + 23);
			index = content.indexOf("</a>");
			
			if (index >= 0) {
				content = content.substring(index + 4);
			
				index = content.indexOf("</h1>");
				String title = content.substring(0, index);
//				 System.out.println(title);
				article.setName(title);
			}

		}
		index = content.indexOf("class=\"deal-price\"");
		if (index > 0) {
			content = content.substring(index + 18);
			index = content.indexOf("<strong>");
			if (index > 0) {
				content = content.substring(index + 8);
				index = content.indexOf("</strong>");
				String nowPrice = content.substring(0, index);
				content = content.substring(index + 9);
				nowPrice = getPrice(nowPrice);
//				System.out.println(nowPrice);
				article.setNowPrice(nowPrice);
				index = content.indexOf("class=\"deal-discount\"");
				if (index > 0) {
					content = content.substring(index + 21);
					index = content.indexOf("</tr>");
					content = content.substring(index + 5);
					index = content.indexOf("<td>");
					if (index > 0) {
						content = content.substring(index + 4);
						index = content.indexOf("</td>");
						String oldPrice = content.substring(0, index);
						oldPrice = getPrice(oldPrice);
//						 System.out.println(oldPrice);
						article.setOriginalPrice(oldPrice);

					}
					index = content.indexOf("<td>");
					if (index >= 0) {
						content = content.substring(index + 4);
						index = content.indexOf("</td>");
						String discount = content.substring(0, index);
						 System.out.println(discount);
						article.setDiscount(discount);

					}
					index = content.indexOf("<td>");

					if (index >= 0) {
						content = content.substring(index + 4);
						index = content.indexOf("</td>");
						String saveMoney = content.substring(0, index);
						saveMoney = getPrice(saveMoney);
//						 System.out.println(saveMoney);
						article.setSaveMoney(saveMoney);

					}
					index = content.indexOf("class=\"deal-buy-cover-img\"");
					if (index >= 0) {
						content = content.substring(index + 26);
						index = content.indexOf("src=\"");
						content = content.substring(index + 5);
						index = content.indexOf("\"");
						String url = content.substring(0, index);
//						 System.out.println(url);
						article.setImgurl( url);
					}
				}
			}
		}
	}

	private static String getPrice(String str) {
		int index = str.indexOf("¥");
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
	public static void main(String[] args)throws Exception {
		AyatuanParser p = new AyatuanParser();
			p.parse("http://www.ayatuan.com/city.php?ename=beijing", 15, 5);
	}
}
