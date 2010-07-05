<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!-- 隐藏层begin -->
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
<!-- 隐藏层end -->