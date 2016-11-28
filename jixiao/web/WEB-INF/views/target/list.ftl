<#import "spring.ftl" as s />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>目标达成值维护</title>
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
	<div id="datagrid1" class="mini-datagrid"
		style="width: 1200px; height: 280px;" url="../target/InitDatas"
		idField="id" allowResize="true" pageSize="20" allowCellEdit="true"
		allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true"
		editNextRowCell="true">
		<div property="columns">
			<div type="indexcolumn"></div>
			<div type="checkcolumn"></div>
			
			<div width="120" headerAlign="center" allowSort="true" field="desc1" 
				name="target">
				达成目标值<input property="editor" class="mini-textarea"
					style="width: 200px;" minWidth="200" minHeight="50" />
			</div>
			
			<div field="desc2" width="120" headerAlign="center"
					allowSort="true">
					该项指标权重100%-96%
					<input property="editor" class="mini-textarea"
						style="width: 200px;" minWidth="200" minHeight="25" />
				</div>
				<div field="desc3" width="120" headerAlign="center"
					allowSort="true">
					该项指标权重86%-95% <input property="editor" class="mini-textarea"
						style="width: 200px;" minWidth="200" minHeight="25" />
				</div>
				<div field="desc4" width="120" headerAlign="center"
					allowSort="true">
					该项指标权重76%-85% <input property="editor" class="mini-textarea"
						style="width: 200px;" minWidth="200" minHeight="25" />
				</div>
				<div field="desc5" width="120" headerAlign="center"
					allowSort="true">
					该项指标权重66%-75% <input property="editor" class="mini-textarea"
						style="width: 200px;" minWidth="200" minHeight="25" />
				</div>
				<div field="desc6" width="120" headerAlign="center"
					allowSort="true">
					该项指标权重65%以下<input property="editor" class="mini-textarea"
						style="width: 200px;" minWidth="200" minHeight="25" />
				</div>
				
				

			</div>



		</div>
		<script type="text/javascript">
			mini.parse();

			var grid = mini.get("datagrid1");
			grid.load();

			//////////////////////////////////////////////////////
			function getChild(e) {
				//alert(e.value);

				$.ajax({
					url : "../target/getChild",
					data : {
						targetdescid : e.value
					},
					type : "post",
					success : function(text) {
						//grid.reload();
						alert(e.value);//获取下拉列表中对应的id的值
						alert(text);
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
					name : "New Row"
				};
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
					url : "../target/saveTarget",
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

