<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.tuan.domain.Constants" %>
<div style="font-size:12px;">
   链接地址信息管理<br/>
</div>
<br />
<table id="editgrid"></table>
<div id="pagered"></div>
<input type="BUTTON" id="bedata" value="Edit Selected" />
<input type="BUTTON" id="bedata1" value="Add" />
<script type="text/javascript">
jQuery("#editgrid").jqGrid({        
   	url:'../ajax/getAdminArticles?q=1',
	datatype: "json",
	colNames:['编号','来源','城市','标题','地址','有效期','价格','原价','折扣','节省','图片地址'],    
	colModel:[    
	{name:'id',index:'id', width:70,sorttype:"int"},    
	{name:'from',index:'from', width:70,editable:true,edittype:"select",editoptions:{value:"<%= Constants.getFromNameString() %>"}},    
	{name:'city',index:'city', width:70,editable:true,edittype:"select",editoptions:{value:"<%= Constants.getCityString() %>"}},    
	{name:'parser',index:'parser', width:180,editable:true},      
	{name:'url',index:'url', width:80,editable:true},     
	{name:'time',index:'time', width:80,sorttype:"date",editable:true},
	{name:'nowPrice',index:'nowPrice', width:40,editable:true},  
	{name:'originalPrice',index:'originalPrice', width:40,editable:true},     
	{name:'discount',index:'discount', width:40,editable:true}, 
	{name:'saveMoney',index:'saveMoney', width:40,editable:true}, 
	{name:'imgurl',index:'imgurl', width:80,editable:true}
	 ],    
   	rowNum:50,
   	rowList:[50,100,200],
   	pager: '#pagered',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
    jsonReader: {    
      root: "dataRows",  
         repeatitems : false    
      },    
    caption:"Editing Example",
    editurl:"../ajax/editArticleItem"
});
$("#bedata").click(function(){
	var gr = jQuery("#editgrid").jqGrid('getGridParam','selrow');
	if( gr != null ) jQuery("#editgrid").jqGrid('editGridRow',gr,{height:280,reloadAfterSubmit:true});
	else alert("Please Select Row");
});
$("#bedata1").click(function(){
	jQuery("#editgrid").jqGrid('editGridRow',"new",{height:280,reloadAfterSubmit:true});
});
</script>
<br /><br />
