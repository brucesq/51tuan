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
   	url:'../ajax/getSpliderItems?q=1',
	datatype: "json",
	colNames:['编号','来源','城市','解析器','地址','日期'],    
	colModel:[    
	{name:'id',index:'id', width:90,sorttype:"int"},    
	{name:'from',index:'from', width:80,editable:true,edittype:"select",editoptions:{value:"<%= Constants.getFromNameString() %>"}},    
	{name:'city',index:'city', width:80,editable:true,edittype:"select",editoptions:{value:"<%= Constants.getCityString() %>"}},    
	{name:'parser',index:'parser', width:80,editable:true,edittype:"select",editoptions:{value:"<%= Constants.getParserNameString() %>"}},      
	{name:'url',index:'url', width:80,editable:true},     
	{name:'time',index:'time', width:80,sorttype:"date"}      
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
    editurl:"../ajax/editSpliderItem"
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
