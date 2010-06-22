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
public class YtuanParser   implements ArticleParser{

	public Article parse(String htmlurl, Integer cityId,Integer fromId) throws Exception {

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
//		System.out.println(content);
		parserContent(content,article);
		return article;
	}
	
	public static void parserContent(String content,Article article){
		int index = content.indexOf("class=\"deal-today-link cheng\"");
		if(index > 0 ){
			content = content.substring(index+29);
			index = content.indexOf("</a>");
			if(index >= 0){
				content = content.substring(index+4);
				index = content.indexOf("</h1>");
				String title  = content.substring(0,index);
//				System.out.println(title);
				article.setName(title);
			}
				
		}
		index = content.indexOf("class=\"deal-price\"");
		if(index > 0 ){
			content = content.substring(index+18);
			index = content.indexOf("<strong>");
			if(index > 0){
				content = content.substring(index+8);
				index = content.indexOf("<b");
				String nowPrice  = content.substring(0,index);
				content = content.substring(index+2);
//				nowPrice = getPrice(nowPrice);
//				System.out.println(nowPrice);
				article.setNowPrice(nowPrice);
				index = content.indexOf("class=\"deal-discount\"");
				if(index > 0){
					content = content.substring(index+21);
					index = content.indexOf("</tr>");
					content = content.substring(index+5);
					index = content.indexOf("<td>");
					content = content.substring(index+4);
					index = content.indexOf("<");
					String oldPrice  = content.substring(0,index);
					oldPrice = getPrice(oldPrice);
					article.setOriginalPrice(oldPrice);
//					System.out.println(oldPrice);
				
					index = content.indexOf("<td>");
					if(index >= 0){
						content = content.substring(index+4);
						index = content.indexOf("<");
						String discount  = content.substring(0,index);
//						System.out.println(discount);
						article.setDiscount(discount);
						
					}
					index = content.indexOf("<td>");
					content = content.substring(index+4);
					index = content.indexOf("<");
					String saveMoney  = content.substring(0,index);
					saveMoney = getPrice(saveMoney);
//					System.out.println(saveMoney);
					article.setSaveMoney(saveMoney);
						
					
					index = content.indexOf("deal-buy-cover-img");
					if(index >= 0){
						content = content.substring(index+18);
						index = content.indexOf("src=\"");
						content = content.substring(index+5);
						index= content.indexOf("\"");
						String url = content.substring(0,index);
//						System.out.println(url);
						article.setImgurl(url);
					}
				}
			}
		}
	}
	
	private static String getPrice(String str){
		int index = str.indexOf("¥");
		if(index >= 0){
			str = str.substring(index+1);
			String price = "";
			for(int i=0;i<str.length();i++){
				if(StringUtils.isNumeric(""+str.charAt(i))){
					price += str.charAt(i);
				}else if('.' == str.charAt(i) || '-' == str.charAt(i)){
					price += str.charAt(i);
				}else{
					continue;
				}
			}
			str = price;
		}
		return str;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = 
			"<div id=\"content\">"+
			"			<div id=\"deal-intro\" class=\"cf\">"+
			"				<img style=\"position:absolute; right:0px; top:-30px;\" src=\"static/css/i/zjtg.gif\" />"+
			"                <h1><a class=\"deal-today-link cheng\" href=\"/team.php?id=21\">今日团购：</a>仅售148元！中国第一套儿童情绪管理图画书1和2，包邮并赠送价值126元的芽芽妈杜曼早教视频教程</h1>"+
			"                <div class=\"main\">"+
			"                    <div class=\"deal-buy\">"+
			""+
			"                        <div class=\"deal-price-tag\"></div>"+
			"					                        <p class=\"deal-price\"><strong>148<b style=\"font-size:16px;font-family:'黑体'\">元</b></strong><span><a href=\"/team/buy.php?id=21\"><img src=\"/static/css/i/button-deal-buy.gif\" /></a></span></p>"+
			"					                    </div>"+
			"                    <table class=\"deal-discount\">"+
			"                        <tr>"+
			"                            <th>原价</th>"+
			"                            <th>折扣</th>"+
			""+
			"                            <th>节省</th>"+
			"                        </tr>"+
			"                        <tr>"+
			"                            <td>350<span style=\"font-size:12px;\">元</span></td>"+
			"						                            <td>4.23<span style=\"font-size:12px;\">折</span></td>"+
			"						                            <td>202<span style=\"font-size:12px;\">元</span></td>"+
			""+
			"                        </tr>"+
			"                    </table>"+
			"					                    <div class=\"deal-box deal-timeleft deal-on\" id=\"deal-timeleft\" curtime=\"1277189802000\" diff=\"32598000\">"+
			"						<h3>剩余时间</h3>"+
			"						<div class=\"limitdate\"><ul id=\"counter\">"+
			"													<li><span>9</span>小时</li><li><span>3</span>分钟</li><li><span>18</span>秒</li>"+
			""+
			"												</ul></div>"+
			"					</div>"+
			"					"+
			"														<div class=\"deal-box deal-status deal-status-open\" id=\"deal-status\">"+
			"						<p class=\"deal-buy-tip-top\"><strong>101</strong> 人已购买</p>"+
			"						<p class=\"deal-buy-on\" style=\"line-height:200%;\"><img src=\"/static/css/i/deal-buy-succ.gif\"/> 团购成功！ <br/>还可以继续购买</p>"+
			"					</div>"+
			""+
			"													</div>"+
			"                <div class=\"side\">"+
			"                    <div class=\"deal-buy-cover-img\" id=\"team_images\">"+
			"											<div class=\"mid\">"+
			"							<ul>"+
			"								<li class=\"first\"><img src=\"http://www.ytuan.com/static/team/2010/0618/12768449074199.jpg\"/></li>"+
			"															<li><img src=\"http://www.ytuan.com/static/team/2010/0618/12768451399537.jpg\"/></li>"+
			"																					</ul>"+
			"							<div id=\"img_list\">"+
			""+
			"								<a ref=\"1\" class=\"active\">1</a>"+
			"																						<a ref=\"2\" >2</a>"+
			"																					</div> "+
			"						</div>";
		
		 Article article = new Article();
		 parserContent(content, article);

	}

}
