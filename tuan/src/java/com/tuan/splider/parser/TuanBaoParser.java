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
public class TuanBaoParser   implements ArticleParser{

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
		String content = IoUtils.pipe(in, "gb2312");
		
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
		int index = content.indexOf("class=\"deal clearfix\"");
		if(index > 0 ){
			content = content.substring(index+15);
			index = content.indexOf("</b><b>");
			if(index >= 0){
				content = content.substring(index+7);
				index = content.indexOf("</b>");
				String title  = content.substring(0,index);
//				System.out.println(title);
				article.setName(title);
			}
				
		}
		index = content.indexOf("class=amount");
		if(index > 0 ){
			content = content.substring(index+12);
			index = content.indexOf("<b>");
			if(index > 0){
				content = content.substring(index+3);
				index = content.indexOf("</b>");
				String nowPrice  = content.substring(0,index);
				content = content.substring(index+4);
//				nowPrice = getPrice(nowPrice);
//				System.out.println(nowPrice);
				article.setNowPrice(nowPrice);
				index = content.indexOf("class=buy");
				if(index > 0){
					content = content.substring(index+9);
					index = content.indexOf("<DD>");
					content = content.substring(index+4);
					index = content.indexOf("/>");
					if(index > 0){
						content = content.substring(index+2);
						index = content.indexOf("</DD>");
						String oldPrice  = content.substring(0,index);
//						oldPrice = getPrice(oldPrice);
//						System.out.println(oldPrice);
						article.setOriginalPrice(oldPrice);
						
					}
					index = content.indexOf("<DD>");
					if(index >= 0){
						content = content.substring(index+4);
						index = content.indexOf("</DD>");
						String discount  = content.substring(0,index);
//						System.out.println(discount);
						article.setDiscount("降"+discount);
						
					}
					index = content.indexOf("<DD>");
					content = content.substring(index+4);
					index = content.indexOf("/>");
					if(index >= 0){
						content = content.substring(index+2);
						index = content.indexOf("</DD>");
						String saveMoney  = content.substring(0,index);
//						saveMoney = getPrice(saveMoney);
//						System.out.println(saveMoney);
						article.setSaveMoney(saveMoney);
						
					}
					index = content.indexOf("class=photos");
					if(index >= 0){
						content = content.substring(index+12);
						index = content.indexOf("src=\"");
						content = content.substring(index+5);
						index= content.indexOf("\"");
						String url = content.substring(0,index);
//						System.out.println("http://www.groupon.cn"+url);
						article.setImgurl("http://www.groupon.cn"+url);
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
	
	public static void main(String[] args)throws Exception{
//		String content = "</DIV>"+
//
//		
//		"			<DIV class=\"deal clearfix\">     "+
//		"				<div style=\"width:inherit;font-family:'黑体';font-size:30px; margin-bottom:10px;\">"+
//		"					<b style=\" color:#4BC1DE;\">今日团购 A </b><b>0.2折美容套餐！炎炎夏日，男人关注的焦点不只是世界杯，还有擦身而过的一双双修长美腿！仅58元享“瘦”夏日清爽性感美人套餐！“古埃及‘木乃伊’瘦身+溶副乳（去除腋下多余脂肪）+植物控油疗程沙龙护理”【原价2800元，5次美容，共270分钟，美容过程所涉及的化妆品全部免费，无任何隐形消费】</b>"+
//		"				</div>"+
//		"				<DIV class=primary>"+
//		"					<DIV class=price_tag>"+
//		"						<IMG alt=\"\" src=\"/images/price_tag.png\" width=287 height=92>"+
//		"					</DIV>"+
//
//		"					<DIV class=price style=\"width:130px; text-align:center;\">"+
//		"						<DIV class=amount><img src=\"/images/rmb_1.gif\" />&nbsp;<b>58</b></DIV>"+
//		"					</DIV>"+
//		"					"+
//		"					<A id=buy href=\"http://www.groupon.cn/buy/?id=475\"><IMG alt=Buy src=\"/images/buy.png\" width=\"100\" height=\"47\"  style=\"margin-top:10px; margin-left:50px;\"></A> "+
//		"					"+
//		"					<DIV class=buy>"+
//		"						<DIV class=value>"+
//		"							<DL>"+
//		"							  <DT style=\"font-family:'黑体'; font-size:14px; font-weight:normal; margin-bottom:3px;\">原价</DT>"+
//		""+
//		"							  <DD><img src=\"/images/rmb.gif\" />2800</DD></DL>"+
//		"							<DL class=discount>"+
//		"							  <DT style=\"font-family:'黑体'; font-size:14px; font-weight:normal; margin-bottom:3px;\">降幅</DT>"+
//		"							  <DD>98%</DD></DL>"+
//		"							<DL class=save>"+
//		"							  <DT style=\"font-family:'黑体'; font-size:14px; font-weight:normal; margin-bottom:3px;\">您节省</DT>"+
//		"							  <DD><img src=\"images/rmb.gif\" />2742</DD>"+
//		""+
//		"							</DL>"+
//		"						</DIV>"+
//		"						"+
//		"						<DIV class=for_a_friend>"+
//		"							"+
//		"							<A class=\"icon_gift for_friend\" href=\"http://www.groupon.cn/buy/?id=475\"><img src=\"/images/buyforfriend.gif\" /></A>"+
//		"							"+
//		"						</DIV>"+
//		"					</DIV>"+
//		"					<SPAN style=\"DISPLAY: none\" class=\"deal_permalink deal_permalink\">mv-hair-salon</SPAN> <SPAN style=\"DISPLAY: none\" class=\"deal_refresh_interval deal_refresh_interval\">300</SPAN> "+
//		"							"+
//		"					<div style=\"width:218px;height:105px;border:1px solid #98C267; margin-top:10px; background:#DDEDCC;\">"+
//		""+
//		""+						
//		"						<!--剩余时间： -->"+
//		"						<span style=\"width:85px; font-size:12px; float:left; margin-top:10px; margin-left:30px;\">本期倒计时：</span><br />"+
//		"						<UL style=\" list-style-type:none;width:85px;float:left; margin-left:30px; margin-top:2px;\">"+
//		"						  <LI id=\"hours\" style=\"font-size:12px;\"></LI>"+
//		"						  <LI id=\"minutes\" style=\"font-size:12px;\"></LI>"+
//		"						  <LI id=\"seconds\" style=\"font-size:12px;\"></LI>"+
//		"						</UL><IMG alt=Hourglass009 src=\"/images/hourglass009.gif\" style=\"float:left; margin-left:30px;\">"+
//		"						"+
//		"					</div>"+
//		
//							
//		"					<div style=\"clear:both\"></div>"+
//		"					<div id=\"ajax_buynums\" style=\"margin:0px; padding:0px;width:auto;height:auto; margin-top:10px;\">"+
//		"						"+
//		"						"+
//		"						<div id=\"buyerinfo1\" style=\"width:218px;height:135px;border:1px solid #98C267;text-align:center; background:#DDEDCC; margin-bottom:10px;\">"+
//		"							<span style=\"width:inherit; margin:0 auto; text-align:center; font-weight:600;line-height:40px; font-size:18px;\"><span class=\"howmens\" style=\"color:#d01e3b;\">106</span>人已购买</span>	"+
//		"							<br />"+
//		"							<br />"+
//		"							<DIV style=\"width:208px;\">"+
//		"								<img src=\"/images/Image_r2_c2.jpg\" align=\"absmiddle\" style=\"float:left; margin-left:10px;\" /><b style=\"font-size:14px; float:left; margin-top:10px;\">组团成功,可继续购买&nbsp;&nbsp;</b>"+
//
//		"							</DIV>"+
//		"							<br />"+
//		"							<div style=\"clear:both\"></div>"+
//		"							<div style=\"width:216px;font-size:12px; margin-top:5px; float:left;text-align:center; \"><b>12:41:22</b> 达到最低团购人数10人</div>"+
//		"						</div>"+
//		"						"+
//		"					</div>"+
//		"				</DIV>"+
//		""+
//		"				<DIV class=secondary>"+
//		"					<DIV class=photos>"+
//		"						<UL>"+
//		"					 		<LI><IMG alt=\"0.2折美容套餐！炎炎夏日，男人关注的焦点不只是世界杯，还有擦身而过的一双双修长美腿！仅58元享“瘦”夏日清爽性感美人套餐！“古埃及‘木乃伊’瘦身+溶副乳（去除腋下多余脂肪）+植物控油疗程沙龙护理”【原价2800元，5次美容，共270分钟，美容过程所涉及的化妆品全部免费，无任何隐形消费】\" src=\"/images/UploadImages/20106/201061258192.jpg\" width=440></LI>"+
//		"						</UL>"+
//		"					</DIV>"+
//		"					"+
//		"					<DIV style=\"width:350px; margin-left:auto; margin-right:auto; margin-top:20px;\">"+
//		"						<div style=\"float:left;width:50px;height:50px;\"><img src=\"/images/groupbut_r4_c10.gif\" width=\"50\"></div>"+
//		"						<div style=\"float:right;width:295px;height:auto; color:#666666; font-size:12px; line-height:20px; margin-top:9px;\">"+
//		""+
//		"							曼妙多姿的身材~完美的曲线~清爽美白的肌肤~这个激情四射的盛夏，男人们关注的焦点不再仅仅是世界杯！"+
//		"						</div>"+
//		"						"+
//		"					</DIV>";
//		Article article = new Article();
//		parserContent(content,article);
		
		TuanBaoParser p = new TuanBaoParser();
		p.parse("http://www.groupon.cn/?cityid=1", 1, 5);
	}

}
