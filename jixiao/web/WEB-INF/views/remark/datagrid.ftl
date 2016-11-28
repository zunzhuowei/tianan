<#import "spring.ftl" as s />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DataGrid1</title>
<script src="<@s.url '/js/boot.js'/>" type="text/javascript"></script>
<style>
	body,html {width:100%;height:100%;overflow:hidden}
	*{
		margin:0;
		padding:0;
		font-family: "微软雅黑";
	}
	fieldset{
        border:solid 1px #ddd;
    }        
    .hideFieldset{
        border-left:0;
        border-right:0;
        border-bottom:0;
    }
    .hideFieldset .fieldset-body{
        display:none;
    }

</style>
</head>

<body>
	
	<!-- mini-toolbar表示生成一个工具条 -->
	<div class="mini-toolbar" style="border:solid 2px #47b5e6;padding:5px;">
		<fieldset id="fd2" class="hideFieldset" style="width:100%;height:100%">
	        <legend><label><input type="checkbox" id="checkbox1" onclick="toggleFieldSet(this, 'fd2')" hideFocus/>查询条件</label></legend>
		        <div class="fieldset-body" style="padding-top:10px">
		        	<div>
			        	姓名：<input id="name" class="mini-textbox" style="width:100px"/><span class="separator"></span>
			        	性别：<input id="gender" class="mini-combobox" style="width:100px"/><span class="separator"></span>
			        	单位：<input name="unit" class="mini-combobox" style="width:100px"/><span class="separator"></span>
			        	部门：<input id="dept" class="mini-combobox" style="width:100px"/><span class="separator"></span>
			        	岗位：<input name="job" class="mini-combobox" style="width:100px"/>
		        	</div>
		        	<div style="margin-top:5px">
			        	<div id="education"
			        		 class="mini-checkboxlist" 
			        		 repeatItems="3" 
			        		 repeatLayout="none" 
			        		 repeatDirection="vertical" 
			        		 textField="text" 
			        		 valueField="id" 
			        		 value="" 
			        		 data="[{'id':'01','text':'初中'},{'id':'03','text':'高中'},{'id':'05','text':'大专'},{'id':'07','text':'本科'},{'id':'09','text':'硕士'},{'id':'11','text':'博士'}]" >
			        	</div>
		        	</div>

		        	<center>
		        		<a class="mini-button" iconCls="icon-search" onclick="addRow()">查询</a>
			        	<a class="mini-button" iconCls="icon-expand" onclick="addRow()">显示全部</a>
			        	<a class="mini-button" iconCls="icon-redo" onclick="addRow()">清空条件</a>
			        </center>
		        </div>

	    </fieldset>
	</div>
	 
    
    <!-- mini-toolbar表示生成一个工具条 -->
	<div class="mini-toolbar" style="border-bottom:0;padding:5px;background:#fff">
		<a id="add" class="mini-button" iconCls="icon-add" plain="true">新增</a>
		<a id="save" class="mini-button" iconCls="icon-edit" plain="true">保存</a>
		<a id="del" class="mini-button" iconCls="icon-remove" plain="true">删除</a>
	</div>
	
	<!-- mini-fit表示让该DIV里面的内容撑满剩余的屏幕 -->
	<div class="mini-fit" style="padding:5px;border:solid 1px #ddd" >
		<div id="datagrid1"
			 url="/demo/miniui/datagrid/search?json" 
			 class="mini-datagrid"
			 idField="id" 
			 allowResize="true"
			 sizeList="[20,30,50,100]" 
			 pageSize="20"
			 fitColumns="false"
			 style="height:100%"
		>
		    <div property="columns">
		    	<div type="checkcolumn" width="30"></div>
		        <div type="indexcolumn" width="50" headerAlign="center" align="center">序号</div>
		        <div field="loginname" width="120" headerAlign="center" align="center" allowSort="true">员工编号</div>    
		        <div field="name" width="120" headerAlign="center" align="center" allowSort="true">姓名</div>                            
		        <div field="gender" width="100" renderer="onGenderRenderer" align="center" headerAlign="center">性别</div>
		        <div field="salary" numberFormat="¥#,0.00" align="right" width="100" allowSort="true">薪资</div>                                
		        <div field="age" width="100" allowSort="true" decimalPlaces="2" dataType="float">年龄</div>
		        <div field="createtime" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">创建日期</div>                
		    </div>
		</div>
	</div>
</body>
<script type="text/javascript">
	mini.parse();
	var obj = {
		grid: mini.get("datagrid1"),
		search:function(){
			obj.grid.load();
		},
  		add:function(){
  			obj.grid.addRow({},0);
  		},
  		save:function(){
  			alert("修改");
  		},
  		del:function(){
  			alert("删除");
  		}
  	}
    $(document).ready(function(){
		 obj.search();
		 $("#add").click(obj.add);
		 $("#save").click(obj.save);
		 $("#del").click(obj.del);
		 
    });
</script>

</html>

