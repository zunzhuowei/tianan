<#import "spring.ftl" as s />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用miniui开发中---</title>
<script src="<@s.url '/js/boot.js'/>" type="text/javascript"></script>
<style type="text/css">
body, html {
	width: 99%;
	height: 99%;
	overflow: hidden
}
</style>
</head>
<body>
	<div style="width: 800px;">
		<div class="mini-toolbar" style="border-bottom: 0; padding: 0px;">
			<table style="width: 100%;">
				<tr>
					<td style="width: 100%;"><a class="mini-button"
						iconCls="icon-add" onclick="addRow()" plain="true" tooltip="增加...">增加</a>
						<a class="mini-button" iconCls="icon-remove" onclick="removeRow()"
						plain="true">删除</a> <span class="separator"></span> <a
						class="mini-button" iconCls="icon-save" onclick="saveData()"
						plain="true">保存</a></td>
					<td style="white-space: nowrap;"><input id="key"
						class="mini-textbox" emptyText="请输入达成目标值" style="width: 150px;"
						onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
					</td>
				</tr>
			</table>
		</div>
	</div>



<div id="datagrid1" class="mini-datagrid" allowHeaderWrap="true" allowCellWrap="true" onload="onload"
		style="width: 1500px; height: 280px;" url="../p04/InitTable" 
		idField="p0400" allowResize="true" pageSize="20" allowCellEdit="true"
		allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true"
		editNextRowCell="true">
		<div property="columns">
				
				<div type="indexcolumn">序号</div>
				<div type="checkcolumn"></div>
				<div width="40" headerAlign="center" allowSort="true" field="zhibiao" name="zhibiao">
					指标类型
					 <input property="editor" class="mini-textbox"
						style="width: 200px;" minWidth="20" minHeight="50" readonly="readonly"/>
				</div>
					
				<div width="80" headerAlign="center" allowSort="true" field="p0407"  name="target">
					指标
					<input property="editor" class="mini-textbox"
						style="width: 200px;" minWidth="20" minHeight="50" />
				</div>
				
				<div type="comboboxcolumn" width="80" headerAlign="center" allowSort="true" 
						headerAlign="center" field="desc1" >
							达成目标值（从时间、数量、质量等维度描述）
                		<input property="editor" class="mini-combobox" style="width:100%;" textField="desc1" valueFromSelect="true"
                		valueField="id" onvaluechanged="getChild(this)" url="../p04/InitSelect" />                
				</div>

<!-- ************************************************************************************************ -->
				<div header="评分标准"  headerAlign="center">
	                <div property="columns">
	                    <div field="desc2" width="120" >该项指标权重的100%-96%
	                    	<input property="editor" class="mini-textbox" 
								style="width: 200px;" minWidth="20" minHeight="50" readonly="readonly"/>
	                    </div>
	                    <div field="desc3" width="120" >该项指标权重的86%-95%
	                    	<input property="editor" class="mini-textbox" 
								style="width: 200px;" minWidth="20" minHeight="50" readonly="readonly"/>
	                    </div>
	                    <div field="desc4" width="120">该项指标权重的76%-85%
	                    	<input property="editor" class="mini-textbox" 
								style="width: 200px;" minWidth="20" minHeight="50" readonly="readonly"/>
	                    </div>
	                    <div field="desc5" width="120">该项指标权重的66%-75%
	                    	<input property="editor" class="mini-textbox" 
								style="width: 200px;" minWidth="20" minHeight="50" readonly="readonly"/>
	                    </div>
	                    <div field="desc6" width="120">该项指标权重的65%及以下
	                    	<input property="editor" class="mini-textbox" 
								style="width: 200px;" minWidth="20" minHeight="50" readonly="readonly"/>
	                    </div>
	           	 	</div>
				</div>
<!-- ************************************************************************************************ -->				
           	 	<div width="80" headerAlign="center" allowSort="true" field="p04BC">
           	 		数据来源
					<input property="editor" class="mini-textbox"
						style="width: 200px;" minWidth="20" minHeight="50" />
				</div>
				<div width="80" headerAlign="center" allowSort="true" field="p0415">
           	 		权重
					<input property="editor" class="mini-textbox"
						style="width: 200px;" minWidth="20" minHeight="50" />
				</div>
				<div width="80" headerAlign="center" allowSort="true" field="p04Z9">
           	 		完成情况（从完成的时间、数量、质量等维度描述）
					<input property="editor" class="mini-textbox"
						style="width: 200px;" minWidth="20" minHeight="50" />
				</div>
				<div width="80" headerAlign="center" allowSort="true" field="xxx">
           	 		自评
					<input property="editor" class="mini-textbox"
						style="width: 200px;" minWidth="20" minHeight="50" />
				</div>
				<div width="80" headerAlign="center" allowSort="true" field="yyy">
           	 		考核人评分
					<input property="editor" class="mini-textbox"
						style="width: 200px;" minWidth="20" minHeight="50" />
				</div>
		</div>
</div>

<script type="text/javascript">
			mini.parse();

			var grid = mini.get("datagrid1");
			
			
			grid.on("load", function () {//合并用
	            grid.mergeColumns(["zhibiao"]);
	        });

			grid.load();
			
	   		function onload(){//第一行为空白行
	    	   var newRow = {
					name : "New Row"
				};
				///alert(mini.encode(newRow)); //TODO
				grid.addRow(newRow, 0);
	       } 
				
				
			//////////////////////////////////////////////////////,zhibiao : "非量化类指标"
			function getChild(e) {
				//alert(e.value);
				var row = grid.getSelected();
				//alert(mini.encode(row));
				var targetdescid = e.value;
				
				$.ajax({
					url : "../p04/returnTable",
					data : {
						targetdescid : targetdescid
					},
					type : "post",
					success : function(text) {
						//alert(e.value);//获取下拉列表中对应的id的值
						
						var rowdata = mini.decode(text);//json转对象
						grid.updateRow(row,rowdata);
						//var json = $.parseJSON(text);
						//var desc2 = json.desc2;
						//alert(desc2);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.responseText);
					}
				});
			}

			//////////////////////////////////////////////////////

			function search() {
				var key = mini.get("key").getValue();

				grid.load({
					key : key
				});
			}

			function onKeyEnter(e) {
				search();
			}

			function addRow() {
				var newRow = {
					name : "New Row",zhibiao : "非量化类指标"
				};
				///alert(mini.encode(newRow)); //TODO
				grid.addRow(newRow, 0);

				grid.beginEditCell(newRow, "target");
			}
			
			function removeRow() {
				var rows = grid.getSelecteds();
				
				if (rows.length > 0) {
					grid.removeRows(rows, true);
				}
			}
			function saveData() {

				var data = grid.getChanges();
				var json = mini.encode(data);

				grid.loading("保存中，请稍后......");
				$.ajax({
					url : "../p04/saveTarget",
					data : {
						target : json
					},
					type : "post",
					success : function(text) {
						grid.reload();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.responseText);
					}
				});
			}

			grid.on("celleditenter", function(e) {
				var index = grid.indexOf(e.record);
				if (index == grid.getData().length - 1) {
					var row = {};
					grid.addRow(row);
				}
			});

			grid.on("beforeload", function(e) {
				if (grid.getChanges().length > 0) {
					if (confirm("有增删改的数据未保存，是否取消本次操作？")) {
						e.cancel = true;
					}
				}
			});
		</script>

</body>
</html>

