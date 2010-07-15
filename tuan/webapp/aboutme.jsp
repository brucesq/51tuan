<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.tuan.web.framework.AuthenticationHelper" %>
<%@ page import="com.tuan.domain.Constants"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html id="html" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>百团网 - 关于我们</title>
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

<%@ include file="/common/header.jsp"%>

<!--中部开始-->

<div id="main_mid">
<!--中部左开始-->

<div class="main_mid_left">



<!--中部今日团购开始-->

<div id="main_mid_tdtg">
<div class="main_mid_tdtg_title1">


</div>
<div class="main_mid_tdtg_product">
<div class="main_mid_tdtg_product_dv">
<div style="padding:10px 20px 10px 20px;">
<h1>关于我们</h1>
<hr/>
百团 = 高端团购<br/><br/>
百团 = 放心团购<br/><br/>
百团 = 一眼挑选你所要的团购<br/><br/>
百团网是一家高端放心团购搜索引擎。每天跟踪中国数百个团购网站，及时更新各大团购网站动态，第一时间发布最新团购信息。
<br/><br/>
百团网讯科技(北京)有限公司<br/>
www.100grouper.com	
</div>

<div style="padding-left:20px;padding-right:20px;padding-top:10px;padding-bottom:10px;">
<h1>联系我们</h1>
<hr/>
如果您有任何意见和建议，请联系我们：
<br/><br/>
E-mail：contact@100grouper.com
<br/><br/>
QQ服务：28429091
<br/><br/>
广告业务联系：E-mail：ad@100grouper.com
<br/><br/>
人才招聘：E-mail：hr@100grouper.com
<br/><br/>
百团网讯科技(北京)有限公司<br/>
www.100grouper.com	
</div>

</div>
</div>
</div>
<div class="main_mid_tdtg_bottom"></div>

<!--中部今日团购结束-->

</div>

<!--中部左结束-->

<!--中部右开始-->
<%@ include file="/common/right1.jsp"%>
<!--中部右结束-->

</div>

<!--中部结束-->

<%@ include file="/common/footer.jsp"%>

</div>
<!--结束-->


</body>
</html>
<script type="text/javascript">

$(document).ready(function(){
	$("#changeCityButton").hide();
});

</script>
