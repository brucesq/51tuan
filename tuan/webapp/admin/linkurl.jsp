<%@ page import="com.tuan.domain.Constants" %>
<div style="font-size:12px;">
   链接地址信息管理<br/>
</div>
<br />
<table id="editgrid"></table>
<div id="pagered"></div>
<input type="BUTTON" id="bedata" value="Edit Selected" />
<script type="text/javascript">
jQuery("#editgrid").jqGrid({        
   	url:'../ajax/getItems?q=1',
	datatype: "json",
	colNames:['编号','姓名','密码','年龄','地址','出生日期'],    
	colModel:[    
	{name:'id',index:'id', width:90,sorttype:"int"},    
	{name:'username',index:'name', width:110},    
	{name:'password',index:'password', width:80,editable:true,edittype:"select",editoptions:{value:"<%= Constants.getCityString() %>"}},    
	{name:'age',index:'age', width:80},      
	{name:'address',index:'address', width:80},     
	{name:'time',index:'time', width:80,sorttype:"date"}      
	 ],    
   	rowNum:5,
   	rowList:[5,20,30],
   	pager: '#pagered',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
    jsonReader: {    
      root: "dataRows",  
         repeatitems : false    
      },    
    caption:"Editing Example",
    editurl:"someurl.php"
});
$("#bedata").click(function(){
	var gr = jQuery("#editgrid").jqGrid('getGridParam','selrow');
	if( gr != null ) jQuery("#editgrid").jqGrid('editGridRow',gr,{height:280,reloadAfterSubmit:false});
	else alert("Please Select Row");
});
</script>
<br /><br />
