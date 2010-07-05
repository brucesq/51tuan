<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.tuan.web.framework.AuthenticationHelper" %>
<%@ page import="com.tuan.domain.Constants"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html id="html" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>百团网 - 高端放心团购搜索引擎</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="description" content="百团网 - 高端放心团购搜索引擎">
<link rel="shortcut icon" href="favicon.ico" />
<meta name="Keywords" content="团购，百团，放心，高端，百团大战，集结号，搜索引擎，团购汇总，折扣，打折，团购网，团购，团购网站，团购吧，团购导航，baituan， baituanwang, tuangou">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/boxOver.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
</head>

<body>
<!--开始-->
<div class="main_alldv">

<!--顶部收藏部分开始-->

<div class="main_top_ssdv">
<div class="main_top_ssdv_left"></div>
<div class="main_top_ssdv_midd">
<div class="main_top_ssdv_midd_d1"><img src="image/main_top_img2.gif" width="10" height="9" /><a href="javascript:void(0);" onclick="bookmark('百团大战：吹响团购-集结号', 'http://www.100grouper.com/tg/index.html');">加入收藏</a></div>
<!-- 
<div class="main_top_ssdv_midd_d2"><img src="image/main_top_img1.gif" width="10" height="9" /><a href="#" target="_blank">设为首页</a></div>
<div class="main_top_ssdv_midd_d2"><img src="image/main_top_img1.gif" width="10" height="9" /><a href="#" target="_blank">设为首页</a></div>
-->
</div>
<div class="main_top_ssdv_right"></div>
</div>

<!--顶部收藏部分结束-->
<!--顶部导航部分开始-->

<div id="main_top_dh">
<div class="main_top_dh_left"></div>
<div class="main_top_dh_right">
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img1.gif" alt="团购" border="0" />团&nbsp;购</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img2.gif" alt="团购" border="0" />购物车</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img3.gif" alt="团购" border="0" />购物志</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img4.gif" alt="团购" border="0" />新&nbsp;闻</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img5.gif" alt="团购" border="0" />论&nbsp;坛</a></div>
<div class="main_top_dh_right_dv"><a href="#" target="_blank"><img src="image/main_top_dh_img6.gif" alt="团购" border="0" />帮&nbsp;助</a></div>
</div>
</div>

<!--顶部导航部分结束-->
<!--顶部banner部分开始-->

<div id="main_top_banner">
<div class="main_top_banner_left"></div>
<div class="main_top_banner_midd">
<div class="main_top_banner_midd_bo" id="city">北京</div>
<div class="main_top_banner_midd_qh"><b style="cursor:pointer;" onclick="changeCity('');">切换城市</b>&nbsp;&nbsp;&nbsp;&nbsp;本网站已能搜索 <b><%=Constants.CITY_ID.entrySet().size() %></b> 个城市的  <b><%=Constants.FROM_ID.entrySet().size() %></b> 家团购网站的团购信息</div>
<div class="main_top_banner_midd_gx"><img src="image/main_top_banner_ico8.gif" align="absmiddle" />&nbsp;分享到：&nbsp;&nbsp;<img src="image/main_top_banner_ico1.gif" align="absmiddle" />&nbsp;<a onclick="window.prompt('请复制网址','www.100grouper.com');" href="javascript:void(0)">QQ/MSN</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico2.gif" width="16" height="16" align="absmiddle" />&nbsp;<a href="http://www.kaixin001.com/repaste/share.php?rurl=www.100grouper.com&rcontent=www.100grouper.com%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81&rtitle=%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81" target="_blank">开心</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico3.gif" align="absmiddle" />&nbsp;<a href="http://share.renren.com/share/buttonshare.do?link=www.100grouper.com&title=www.100grouper.com%20%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81&body=%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7" target="_blank">人人</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico4.gif" align="absmiddle" />&nbsp;<a href="http://www.douban.com/recommend/?url=www.100grouper.com&title=www.100grouper.com%20%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81" target="_blank">豆瓣</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico5.gif" align="absmiddle" />&nbsp;<a href="http://v.t.sina.com.cn/share/share.php?url=www.100grouper.com&title=%E2%80%9C%E7%99%BE%E5%9B%A2%E5%A4%A7%E6%88%98%E2%80%9D%E5%90%B9%E5%93%8D%E5%9B%A2%E8%B4%AD-%E9%9B%86%E7%BB%93%E5%8F%B7%EF%BC%81&pic=&type=0" target="_blank">新浪</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico6.gif" align="absmiddle" />&nbsp;<a href="http://bai.sohu.com/share/blank/addbutton.do?from=bianews.com&link=http://www.100grouper.com/tg/index.html" target="_blank">白社会</a>&nbsp;&nbsp;<img src="image/main_top_banner_ico7.gif" align="absmiddle" />&nbsp;<a href="mailto:?subject=%A1%B0%B0%D9%CD%C5%B4%F3%D5%BD%A1%B1%B4%B5%CF%EC%CD%C5%B9%BA-%BC%AF%BD%E1%BA%C5&body=%B7%A2%CF%D6%D2%BB%BA%C3%CD%F8%D5%BE--%B0%D9%CD%C5%CD%F8%A3%AC%CB%FB%C3%C7%B5%C4%CD%C5%B9%BA%D0%C5%CF%A2%B3%AC%C8%AB%A3%A1%0A%0A%CE%D2%CF%EB%C4%FA%BB%E1%B8%D0%D0%CB%C8%A4%B5%C4%A3%BA%0A%0Ahttp%3A%2F%2Fwww.100grouper.com%2Ftg%2Findex.html">信箱</a></div>
</div>
<div class="main_top_banner_right"></div>
</div>

<!--顶部banner部分结束-->
<!--中部开始-->

<div id="main_mid">
<!--中部左开始-->

<div class="main_mid_left">

<!--中部热点开始-->

<div id="main_mid_hot">
<div class="main_mid_hot_title"></div>
<div class="main_mid_hot_flash"></div>
<div class="main_mid_hot_bottom"></div>
</div>

<!--中部热点结束-->
<!--中部推荐开始-->

<div id="main_mid_webtj">
<div class="main_mid_webtj_title"></div>
<div class="main_mid_webtj_mid">今日团购：仅售35元！原价100元的奥体中心德国啤酒门票（超大高清屏幕观战世界杯1/4决赛+抽奖）
<br /><img src="image/zy2.jpg" alt="网站推荐" /></div>
<div class="main_mid_webtj_bottom"></div>
</div>

<!--中部推荐结束-->
<!--中部banner广告开始-->

<div class="main_mid_bannerAD"><img src="image/zy3.jpg" /></div>

<!--中部banner广告结束-->
<!--中部今日团购开始-->

<div id="main_mid_tdtg">
<div class="main_mid_tdtg_title">
<div class="main_mid_tdtg_title_button0"></div>
<div name="type" class="main_mid_tdtg_title_button1" type="2" onclick="switchCategory(2);">本地团购</div>
<div name="type" class="main_mid_tdtg_title_button2" type="1" onclick="switchCategory(1);">全国信息</div>
<!-- 
<div class="main_mid_tdtg_title_button2">娱乐生活</div>
 -->
</div>
<div class="main_mid_tdtg_product">
<div class="main_mid_tdtg_product_dv">
<div id="center_content"></div>
<div id="top_content"></div>

<div class="main_mid_tdtg_product_dv_page">
<div class="main_mid_tdtg_product_dv_page_one">首页</div>
<div class="main_mid_tdtg_product_dv_page_pg">[1]<!-- &nbsp;&nbsp;[2]&nbsp;&nbsp;[3]&nbsp;&nbsp;[4]&nbsp;&nbsp;[5] --></div>
<div class="main_mid_tdtg_product_dv_page_end">尾页</div>
</div>

</div>
</div>
</div>
<div class="main_mid_tdtg_bottom"></div>

<!--中部今日团购结束-->

</div>

<!--中部左结束-->
<!--中部右开始-->

<div class="main_mid_right">

<!--中部注册部分开始-->

<div id="main_mid_login">
<div class="main_mid_login_left">
<div class="main_mid_login_left_id">账号： 
  <input type="text" /><br /><br />
  密码： 
  <input type="text" />
</div>
<div class="main_mid_login_left_zc"><a href="#" target="_blank" class="login">· 注册</a>&nbsp;&nbsp;&nbsp;<a href="#" target="_blank" class="login">· 重新填写</a></div>
</div>
<div class="main_mid_login_right"></div>
</div>

<!--中部注册部分结束-->
<!--中部名站导航开始-->

<div id="main_mid_webdh">
<div class="main_mid_webdh_title"></div>
<div class="main_mid_webdh_link">
<div class="main_mid_webdh_link_dv">
<table width="100%">
	<tr>
		<td width="30%"></td>
		<td width="30%"></td>
		<td></td>
	</tr>
<%
	int position = 0;
	for (Map.Entry<String, Integer> entry : Constants.FROM_ID.entrySet()) {
		position++;
		if(position % 3 == 1){
%>
	<tr>
<%
		}
%>
		<td><img src="image/main_mid_webdh_bg3.gif" /><a href="#" class="webdh" target="_blank"><%=entry.getKey()%></a></td>
<%
		if(position % 3 == 0 || position == Constants.FROM_ID.entrySet().size()){
%>
	</tr>
<%
		}		
	}
%>	
</table>
</div>
</div>
<div class="main_mid_webdh_bottom"></div>
</div>

<!--中部名站导航结束-->
<!--广告开始-->

<div id="main_top_rightAD"><img src="image/main_mid_right_ad1.gif" alt="右侧广告1" /></div>
<div id="main_top_rightAD"><img src="image/main_mid_right_ad2.jpg" alt="右侧广告2" /></div>

<!--广告结束-->
<!--优惠折扣开始-->

<div id="main_mid_yhzk">
<div class="main_mid_yhzk_title"></div>
<div class="main_mid_yhzk_table" id="discount">
</div>
<div class="main_mid_webdh_bottom"></div>
</div>

<!--优惠折扣结束-->
<!--在线帮助开始-->
<!-- 
<div id="main_mid_help">
<div class="main_mid_help_title"></div>
<div class="main_mid_help_dv">
<div class="main_mid_help_tel">15801228444</div>
<div class="main_mid_help_wz">
<b>用户帮助</b><br />
<img src="image/main_mid_help_bg4.gif" />&nbsp;&nbsp;如何成为VIP会员？<br />
<img src="image/main_mid_help_bg4.gif" />&nbsp;&nbsp;怎样赚取VIP会员佣金？
</div>
<div class="main_mid_help_QQ">28429091</div>
<div class="main_mid_help_wz">
<b>网站帮助</b><br />
<img src="image/main_mid_help_bg4.gif" />&nbsp;&nbsp;怎样能快速选中高性价比商品？<br />
<img src="image/main_mid_help_bg4.gif" />&nbsp;&nbsp;怎样能让沙袋王变成水泥王？
</div>
</div>
<div class="main_mid_webdh_bottom"></div>
</div>
 -->
<!--在线帮助结束-->

</div>

<!--中部右结束-->

</div>

<!--中部结束-->
<!--底部开始-->

<div id="main_bottom">

<!--底部友情链接开始-->
<!-- 
<div id="main_bottom_link">
<div class="main_bottom_link_left"></div>
<div class="main_bottom_link_wz"><b>友情链接：</b>&nbsp;&nbsp;新浪网&nbsp;&nbsp;|&nbsp;&nbsp;搜狐娱乐&nbsp;&nbsp;|&nbsp;&nbsp;网易&nbsp;&nbsp;|&nbsp;&nbsp;魔兽世界&nbsp;&nbsp;|&nbsp;&nbsp;更多 ...</div>
<div class="main_bottom_link_right"></div>
</div>
 -->
<!--底部友情链接结束-->
<!--底部网站信息开始-->

<div id="main_bottom_webmess">
<div class="main_bottom_webmess_left"></div>
<div class="main_bottom_webmess_wz">
关于我们&nbsp;&nbsp;|&nbsp;&nbsp;联系我们&nbsp;&nbsp;|&nbsp;&nbsp;广告服务&nbsp;&nbsp;|&nbsp;&nbsp;人才招聘&nbsp;&nbsp;|&nbsp;&nbsp;百团社区&nbsp;&nbsp;|&nbsp;&nbsp;商品评价<br />
Copyright&copy;2010-2099  www.100grouper.com 百团网 版权所有 京ICP备 暂无<br />
地址：暂无&nbsp;&nbsp;&nbsp;&nbsp;电话：暂无
</div>
<div class="main_bottom_webmess_right"></div>
</div>

<!--底部网站信息结束-->
</div>

<!--底部结束-->

</div>
<!--结束-->

<!--隐藏层 -->
<div id="mask"></div>
<div id="cityList">
	<ul>
<%
	for (Map.Entry<String, Integer> entry : Constants.CITY_ID.entrySet()) {
		if(entry.getValue().intValue() > 0){
%>
		<li onclick="changeCityContent(<%=entry.getValue()%>,'<%=entry.getKey()%>');"><%=entry.getKey()%></li>
<%
		}
	}
%>
	</ul>
</div>
</body>
</html>
<script type="text/javascript">

$(document).ready(function(){
	$("#mask").css("height",$(document).height()+"px");
	$("#cityList").css("display","block");
	changeCityContent(<%= AuthenticationHelper.getCityId(request) %>,'<%= Constants.getCityName(AuthenticationHelper.getCityId(request)) %>');
	$("#top_content").load("ajax/getArticleList?page=1&type=1");
});

function changeCity(val){
	var obj = document.getElementById("cityList");
	if(obj.style.display == 'none' || obj.style.display==''){
		$("#mask").show();
		$("#cityList").css("left",$(window).width()/2-210);
		$("#cityList").css("top",$(window).height()/2-80);
		obj.style.display="block";
	}else if(obj.style.display == 'block'){
		obj.style.display="none";
		$("#mask").hide();
	}if(val != ''){
		$("#city").html(val);
		$("#cityList").find("li").each(function(i,n){
			$(n).css("color","");
			var str = $(n).html();
			if($.trim($(n).html()) == val){
				$(n).css("color","#BBD9F7");
			}
		});
	}
}
function changeCityContent(cid,val){
	$("#center_content").load("ajax/getArticleList?page=1&cityid="+cid);
	$("#discount").load("ajax/getArticleDiscountList?page=1&cityid="+cid);
	changeCity(val);
	switchCategory(2);
}
function switchCategory(val){
	$("div").find("[name=type]").each(function(i,n){
		$(n).removeClass("main_mid_tdtg_title_button1");
		$(n).removeClass("main_mid_tdtg_title_button2");
		if($(n).attr("type") == val)
			$(n).addClass("main_mid_tdtg_title_button1");
		else
			$(n).addClass("main_mid_tdtg_title_button2");
	});
	if(val == 1){
		$("#center_content").hide();
		$("#top_content").show();
	}else{
		$("#center_content").show();
		$("#top_content").hide();		
	}	
}


</script>
