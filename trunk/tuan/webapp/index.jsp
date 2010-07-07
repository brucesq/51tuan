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
<script type="text/javascript" src="js/swfobject_source.js"></script>	
</head>

<body>
<!--开始-->
<div class="main_alldv">

<%@ include file="/common/header.jsp"%>

<!--中部开始-->

<div id="main_mid">
<!--中部左开始-->

<div class="main_mid_left">

<!--中部热点开始-->

<div id="main_mid_hot">
<div class="main_mid_hot_title"></div>
<div class="main_mid_hot_flash" id="hotList"></div>
<div class="main_mid_hot_bottom"></div>
</div>

<!--中部热点结束-->
<!--中部推荐开始-->

<div id="main_mid_webtj">
<div class="main_mid_webtj_title"></div>
<div class="main_mid_webtj_mid" id="random"></div>
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
<div class="main_mid_yhzk_table" id="discountList">
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

<%@ include file="/common/footer.jsp"%>

</div>
<!--结束-->

<%@ include file="/common/hidden.jsp"%>
</body>
</html>
<script type="text/javascript">
var hot_t = hot_n = count = 0;

$(document).ready(function(){
	$("#cityList").css("display","block");
	changeCityContent(<%= AuthenticationHelper.getCityId(request) %>,'<%= Constants.getCityName(AuthenticationHelper.getCityId(request)) %>');
	$("#top_content").load("ajax/getArticleList?page=1&type=1");
	$("#random").load("ajax/getArticleRandom?page=1&type=1");
});

function changeCityContent(cid,val){
	clearInterval(hot_t);
	$("#center_content").load("ajax/getArticleList?page=1&cityid="+cid);
	$("#discountList").load("ajax/getArticleDiscountList?cityid="+cid);
	$("#hotList").load("ajax/getArticleHotList?cityid="+cid);
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
