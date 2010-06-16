/**
 * 
 */
package com.tuan.splider.parser;

import java.io.InputStream;
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
public class MeituanParser  implements ArticleParser{

	public Article parse(String htmlurl, Integer cityId,Integer fromId) throws Exception {

		URL url = new URL(htmlurl);
		URLConnection urlcon = url.openConnection();
		urlcon.setConnectTimeout(10000);
		urlcon.setReadTimeout(10000);
		urlcon.setDoOutput(true);
		InputStream in = null;
		in = url.openStream();
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
		parserContent(content,article);
		return article;
	}
	
	public static void parserContent(String content,Article article){
		int index = content.indexOf("class=\"deal-today-link\"");
		if(index > 0 ){
			content = content.substring(index+16);
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
			content = content.substring(index+13);
			index = content.indexOf(">");
			if(index > 0){
				content = content.substring(index+1);
				index = content.indexOf("</strong>");
				String nowPrice  = content.substring(0,index);
				content = content.substring(index+9);
				nowPrice = getPrice(nowPrice);
//				System.out.println(nowPrice);
				article.setNowPrice(nowPrice);
				index = content.indexOf("class=\"deal-discount\"");
				if(index > 0){
					content = content.substring(index+15);
					index = content.indexOf("</tr>");
					content = content.substring(index+5);
					index = content.indexOf("<td>");
					if(index > 0){
						content = content.substring(index+4);
						index = content.indexOf("</td>");
						String oldPrice  = content.substring(0,index);
						oldPrice = getPrice(oldPrice);
//						System.out.println(oldPrice);
						article.setOriginalPrice(oldPrice);
						
					}
					index = content.indexOf("<td>");
					if(index >= 0){
						content = content.substring(index+4);
						index = content.indexOf("</td>");
						String discount  = content.substring(0,index);
//						System.out.println(discount);
						article.setDiscount(discount);
						
					}
					index = content.indexOf("<td>");
				
					if(index >= 0){
						content = content.substring(index+4);
						index = content.indexOf("</td>");
						String saveMoney  = content.substring(0,index);
						saveMoney = getPrice(saveMoney);
//						System.out.println(saveMoney);
						article.setSaveMoney(saveMoney);
						
					}
					index = content.indexOf("class=\"deal-buy-cover-img\"");
					if(index >= 0){
						content = content.substring(index+13);
						index = content.indexOf("src=\"");
						content = content.substring(index+5);
						index= content.indexOf("\"");
						String url = content.substring(0,index);
//						System.out.println("http://www.meituan.com"+url);
						article.setImgurl("http://www.meituan.com"+url);
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
				}else{
					continue;
				}
			}
			str = price;
		}
		return str;
	}
	
	public static void main(String[] args){
		String content =" <div id=\"content\">"+

        "<div id=\"deal-share\"><div class=\"deal-share-top\"><div class=\"deal-share-links\"><h4>分享到：</h4><ul class=\"cf\"><li><a class=\"im\" href=\"javascript:void(0);\" id=\"deal-share-im\">MSN/QQ</a></li><li><a galabel=\"default\" class=\"kaixin\" href=\"http://www.kaixin001.com/repaste/share.php?rurl=http%3A%2F%2Fwww.meituan.com%2Fbeijing%2Fdeal%2Fyijinwenquan.html%3Fr%3Dk&rcontent=%E4%BA%94%E6%98%9F%E7%BA%A7%E7%9A%84%E6%9C%8D%E5%8A%A1%EF%BC%8C%E8%AE%A9%E6%82%A8%E4%BA%94%E5%88%86%E9%92%9F%E5%BF%98%E6%8E%89%E8%87%AA%E5%B7%B1%EF%BC%8C%E4%BA%8C%E5%8D%81%E5%88%86%E9%92%9F%E5%90%8E%E5%BF%98%E6%8E%89%E6%95%B4%E4%B8%AA%E4%B8%96%E7%95%8C%7E&rtitle=%E7%BE%8E%E5%9B%A2%E5%8C%97%E4%BA%AC%E4%BB%8A%E6%97%A5%E5%9B%A2%E8%B4%AD%EF%BC%9A%E4%BB%85%E5%94%AE276%E5%85%83%EF%BC%81%E5%8E%9F%E4%BB%B72460%E5%85%83%E7%9A%84%E9%A2%90%E9%94%A6%E6%B8%A9%E6%B3%89%E5%85%BB%E7%94%9F%E4%BC%9A%E6%89%80%E5%8F%8C%E4%BA%BA%E8%B1%AA%E5%8D%8E%E5%A5%97%E9%A4%90%EF%BC%8860%E5%88%86%E9%92%9F%E7%A7%81%E6%B1%A4%E6%B8%A9%E6%B3%89%2B90%E5%88%86%E9%92%9F%E5%85%A8%E8%BA%AB%E8%8A%B3%E7%96%97%E6%8C%89%E6%91%A9%EF%BC%89\" target=\"_blank\">开心</a></li><li><a galabel=\"default\" class=\"renren\" href=\"http://share.renren.com/share/buttonshare.do?link=http%3A%2F%2Fwww.meituan.com%2Fbeijing%2Fdeal%2Fyijinwenquan.html%3Fr%3Dr&title=\" target=\"_blank\">人人</a></li><li><a galabel=\"default\" class=\"douban\" href=\"http://www.douban.com/recommend/?url=http%3A%2F%2Fwww.meituan.com%2Fbeijing%2Fdeal%2Fyijinwenquan.html%3Fr%3Dd&title=%E7%BE%8E%E5%9B%A2%E5%8C%97%E4%BA%AC%E4%BB%8A%E6%97%A5%E5%9B%A2%E8%B4%AD%EF%BC%9A%E4%BB%85%E5%94%AE276%E5%85%83%EF%BC%81%E5%8E%9F%E4%BB%B72460%E5%85%83%E7%9A%84%E9%A2%90%E9%94%A6%E6%B8%A9%E6%B3%89%E5%85%BB%E7%94%9F%E4%BC%9A%E6%89%80%E5%8F%8C%E4%BA%BA%E8%B1%AA%E5%8D%8E%E5%A5%97%E9%A4%90%EF%BC%8860%E5%88%86%E9%92%9F%E7%A7%81%E6%B1%A4%E6%B8%A9%E6%B3%89%2B90%E5%88%86%E9%92%9F%E5%85%A8%E8%BA%AB%E8%8A%B3%E7%96%97%E6%8C%89%E6%91%A9%EF%BC%89\" target=\"_blank\">豆瓣</a></li><li><a galabel=\"default\" class=\"sina\" href=\"http://v.t.sina.com.cn/share/share.php?appkey=579809138&url=http%3A%2F%2Fwww.meituan.com%2Fbeijing%2Fdeal%2Fyijinwenquan.html%3Fr%3Dt&title=%E7%BE%8E%E5%9B%A2%E5%8C%97%E4%BA%AC%E4%BB%8A%E6%97%A5%E5%9B%A2%E8%B4%AD%EF%BC%9A%E4%BB%85%E5%94%AE276%E5%85%83%EF%BC%81%E5%8E%9F%E4%BB%B72460%E5%85%83%E7%9A%84%E9%A2%90%E9%94%A6%E6%B8%A9%E6%B3%89%E5%85%BB%E7%94%9F%E4%BC%9A%E6%89%80%E5%8F%8C%E4%BA%BA%E8%B1%AA%E5%8D%8E%E5%A5%97%E9%A4%90%EF%BC%8860%E5%88%86%E9%92%9F%E7%A7%81%E6%B1%A4%E6%B8%A9%E6%B3%89%2B90%E5%88%86%E9%92%9F%E5%85%A8%E8%BA%AB%E8%8A%B3%E7%96%97%E6%8C%89%E6%91%A9%EF%BC%89&pic=http%3A%2F%2Fwww.meituan.com%2Fcontent%2Fdeal%2F201006%2Fyijinwenquan6_1.jpg\" target=\"_blank\">新浪微博</a></li><li><a galabel=\"default\" class=\"t139\" href=\"javascript:void(0);\" onclick=\"window.open('http://www.139.com/share/share.php?tl=953010017&source=shareto139_meituan&url=http%3A%2F%2Fwww.meituan.com%2Fbeijing%2Fdeal%2Fyijinwenquan.html%3Fr%3Do&title=%E7%BE%8E%E5%9B%A2%E5%8C%97%E4%BA%AC%E4%BB%8A%E6%97%A5%E5%9B%A2%E8%B4%AD%EF%BC%9A%E4%BB%85%E5%94%AE276%E5%85%83%EF%BC%81%E5%8E%9F%E4%BB%B72460%E5%85%83%E7%9A%84%E9%A2%90%E9%94%A6%E6%B8%A9%E6%B3%89%E5%85%BB%E7%94%9F%E4%BC%9A%E6%89%80%E5%8F%8C%E4%BA%BA%E8%B1%AA%E5%8D%8E%E5%A5%97%E9%A4%90%EF%BC%8860%E5%88%86%E9%92%9F%E7%A7%81%E6%B1%A4%E6%B8%A9%E6%B3%89%2B90%E5%88%86%E9%92%9F%E5%85%A8%E8%BA%AB%E8%8A%B3%E7%96%97%E6%8C%89%E6%91%A9%EF%BC%89','_blank', 'width=490,height=340');return false;\">139说客</a></li><li><a galabel=\"default\" class=\"email\" href=\"mailto:?subject=%D3%D0%D0%CB%C8%A4%C3%B4%A3%BA%BD%F6%CA%DB276%D4%AA%A3%A1%D4%AD%BC%DB2460%D4%AA%B5%C4%D2%C3%BD%F5%CE%C2%C8%AA%D1%F8%C9%FA%BB%E1%CB%F9%CB%AB%C8%CB%BA%C0%BB%AA%CC%D7%B2%CD%A3%A860%B7%D6%D6%D3%CB%BD%CC%C0%CE%C2%C8%AA%2B90%B7%D6%D6%D3%C8%AB%C9%ED%B7%BC%C1%C6%B0%B4%C4%A6%A3%A9&body=%B7%A2%CF%D6%D2%BB%BA%C3%CD%F8%D5%BE--%C3%C0%CD%C5%CD%F8%A3%AC%CB%FB%C3%C7%C3%BF%CC%EC%D7%E9%D6%AF%D2%BB%B4%CE%CD%C5%B9%BA%A3%AC%B3%AC%D6%B5%A3%A1%0A%0A%BD%F1%CC%EC%B1%B1%BE%A9%B5%C4%CD%C5%B9%BA%CA%C7%A3%BA%BD%F6%CA%DB276%D4%AA%A3%A1%D4%AD%BC%DB2460%D4%AA%B5%C4%D2%C3%BD%F5%CE%C2%C8%AA%D1%F8%C9%FA%BB%E1%CB%F9%CB%AB%C8%CB%BA%C0%BB%AA%CC%D7%B2%CD%A3%A860%B7%D6%D6%D3%CB%BD%CC%C0%CE%C2%C8%AA%2B90%B7%D6%D6%D3%C8%AB%C9%ED%B7%BC%C1%C6%B0%B4%C4%A6%A3%A9%0A%0A%CE%D2%CF%EB%C4%FA%BB%E1%B8%D0%D0%CB%C8%A4%B5%C4%A3%BA%0A%0Ahttp%3A%2F%2Fwww.meituan.com%2Fbeijing%2Fdeal%2Fyijinwenquan.html%3Fr%3De\" id=\"deal-buy-mailto\">邮件</a></li></ul></div></div><div class=\"deal-share-fix\"></div><div id=\"deal-share-im-c\"><div class=\"deal-share-im-b\"><h3>把下面的内容通过 MSN 或 QQ 发送给好友：</h3><p><input id=\"share-copy-text\" type=\"text\" value=\"http://www.meituan.com/r/i\" size=\"30\" class=\"f-input\" /> <input id=\"share-copy-button\" type=\"button\" value=\"复制\" class=\"formbutton\" /></p></div></div></div>            <div id=\"deal-intro\" class=\"cf\">"+
             "   <h1><a class=\"deal-today-link\" href=\"http://www.meituan.com/beijing/deal/yijinwenquan.html\">今日团购：</a>仅售276元！原价2460元的颐锦温泉养生会所双人豪华套餐（60分钟私汤温泉+90分钟全身芳疗按摩）</h1>"+

             "   <div class=\"main\">"+
             "       <div class=\"deal-buy\">"+
             "           <div class=\"deal-price-tag\"></div>"+
               "         <p class=\"deal-price\"><strong>¥276</strong>"+
             "<span><a href=\"/deal/buy/yijinwenquan\"><img src=\"http://www.meituan.com/static//css/i/button-deal-buy.gif\" /></a></span></p>"+
                  "  </div>"+
               "     <table class=\"deal-discount\">"+
               "         <tr>"+

                   "         <th>原价</th>"+
                  "          <th>折扣</th>"+
                    "        <th>节省</th>"+
                   "     </tr>"+
                   "     <tr>"+
                     "       <td>¥2460</td>"+
                     "       <td>1.1折</td>"+

                     "       <td>¥2184</td>"+
                  "      </tr>"+
                "    </table>"+
             "       <div class=\"deal-box deal-timeleft deal-on\" id=\"deal-timeleft\" diff=\"378418\"><h3>剩余时间</h3><div class=\"limitdate\"><ul id=\"counter\"><li><span>4</span>天</li><li><span>9</span>小时</li><li><span>6</span>分钟</li></ul></div></div><div class=\"deal-box deal-status deal-status-open\" id=\"deal-status\"><p class=\"deal-buy-tip-top\"><strong>797</strong> 人已购买</p><p class=\"deal-buy-tip-notice\">数量有限，下单要快哟</p><p class=\"deal-buy-on\">团购已成功，<br />可继续购买…</p><p class=\"deal-buy-tip-btm\">0点39分达到最低团购人数：<strong>20</strong> 人</p></div>                </div>"+

             "   <div class=\"side\">"+
             "       <div class=\"deal-buy-cover-img\"><img src=\"/content/deal/201006/yijinwenquan6_1.jpg\"/></div>"+
                                            "<ul class=\"deal-detail-t cf\">"+
                            "<li class=\"col first\">";

		Article article = new Article();
		parserContent(content,article);
	}
}
