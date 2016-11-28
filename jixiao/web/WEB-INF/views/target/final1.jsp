<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>final1</title>
<%-- <script src="<@s.url '/js/boot.js'/>" type="text/javascript"></script> --%>
<style type="text/css">
body, html {
	width: 99%;
	height: 99%;
}

* {
	font-family: "宋体";
}

table {
	/*table-layout: fixed;*/
	empty-cells: show;
	border-collapse: collapse;
	margin: 0 auto;
}

td {
	height: 20px;
}

table.t1 {
	border: 1px solid #B0C4DE;
	color: #666;
}

table.t1 td, table.t1 th {
	border: 1px solid #B0C4DE;
	padding: 0 1em 0;
}

table.t1 td {
	padding: 5px;
	background: #fff;
}
</style>
</head>
<body>
	<table class="t1" id="tb1">
		<tbody>
			<tr class="firstRow">
				<td valign="top" style="word-break: break-all;" rowspan="1"
					colspan="12" style="background:yellow"><span
					style="font-size: 14px; color: #836FFF"><b>第一部分：计划考核指标（80%）</b></span>
				</td>
			</tr>
			<tr>
				<td width="120" valign="middle" style="word-break: break-all;"
					rowspan="2" colspan="1" align="center"><span
					style="font-size: 12px;"><b>指标</b></span></td>
				<td width="150" valign="middle" style="word-break: break-all;"
					rowspan="2" colspan="1" align="center"><span
					style="font-size: 12px;"><b>达成目标值</b></span></td>
				<td valign="middle" style="word-break: break-all;" rowspan="1"
					colspan="5" align="center" width="480"><span
					style="font-size: 12px;"><b>评分标准</b></span></td>
				<td width="60" valign="middle" align="center" rowspan="2"
					colspan="1"><span style="font-size: 12px;"><b>数据来源</b></span>
				</td>
				<td width="60" valign="middle" align="center" rowspan="2"
					colspan="1"><span style="font-size: 12px;"><b>权重</b></span></td>
				<td width="125" valign="middle" align="center" rowspan="2"
					colspan="1"><span style="font-size: 12px;"><b>完成情况</b></span></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="2"><span style="font-size: 12px;"><b>自评</b></span></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="2"><span style="font-size: 12px;"><b>考核评分</b></span>
				</td>
			</tr>
			<tr>
				<td width="96" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>该项指标权重的100%-90%</b></span>
				</td>
				<td width="96" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>该项指标权重的86%-96%</b></span>
				</td>
				<td width="96" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>该项指标权重的76%-85%</b></span>
				</td>
				<td width="96" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>该项指标权重的66%-75%</b></span>
				</td>
				<td width="96" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>该项指标权重的65%以下</b></span>
				</td>
			</tr>
			<tr id="flh">
				<td valign="middle" align="left" colspan="12" rowspan="1"
					style="word-break: break-all; background: #EDEDED"><span
					style="font-size: 12px;"> <span
						style="width: 120px; vertical-align: middle"><b>1、非量化类指标</b></span>
						<span id="tool1" style="width: 120px; vertical-align: middle">
							<input type="button" id="tool1Add" value="添加"
							onclick="changeRow()" /> <input type="button" id="tool1Del"
							value="删除" onclick="deleteRow()" />
					</span>
				</span></td>

			</tr>


			<tr id="1111" onclick="changeRow(this)">

				<td width="120" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				
				<td width="150" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;">
				<select name="target">
					<c:forEach items="${targets }" var="target">
						<option value="${target.id }">${target.desc1 }</option>
					</c:forEach>
				</select>
				</td>

				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="125" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
			</tr>

			<!-- <tr>
				<td width="120" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="150" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="125" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
			</tr>
			<tr>
				<td width="120" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="150" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="96" valign="middle" align="left" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="125" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
				<td width="60" valign="middle" align="center" colspan="1"
					rowspan="1" style="word-break: break-all;"></td>
			</tr> -->
			<tr id="lh">
				<td valign="middle" align="left" colspan="12" rowspan="1"
					style="word-break: break-all;; background: #EDEDED"><span
					style="font-size: 12px"> <span
						style="width: 120px; vertical-align: middle"><b>2、量化类指标</b></span>
						<span id="tool2" style="width: 120px; vertical-align: middle">
							<input type="button" id="tool1Add" value="添加"
							onclick="tool2Add()" /> <input type="button" id="tool1Del"
							value="删除" onclick="tool2Del()" />
					</span>
				</span></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="5" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="5" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="5" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
			<tr id="tyl">
				<td valign="middle" align="left" colspan="12" rowspan="1"
					style="word-break: break-all;; background: #EDEDED"><span
					style="font-size: 12px;"><b>3、通用类指标</b></span></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="5" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="5" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="5" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
		</tbody>
	</table>

	<table class="t1">
		<tbody>
			<tr class="firstRow">
				<td valign="top" style="word-break: break-all;" rowspan="1"
					colspan="12" style="background:yellow"><span
					style="font-size: 14px; color: #836FFF"><b>第二部分：BPI考核指标（20%）</b></span>
				</td>
			</tr>
			<tr>
				<td width="120" valign="middle" style="word-break: break-all;"
					rowspan="2" colspan="1" align="center"><span
					style="font-size: 12px;"><b>指标</b></span></td>
				<td valign="middle" style="word-break: break-all;" rowspan="1"
					colspan="4" align="center" width="1000"><span
					style="font-size: 12px;"><b>评分标准</b></span></td>

				<td valign="middle" align="center" colspan="1" rowspan="2"
					width="60" style="word-break: break-all;"><span
					style="font-size: 12px;"><b>考核得分</b></span></td>
			</tr>
			<tr>
				<td width="250" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>5分</b></span>
				</td>
				<td width="250" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>4分</b></span>
				</td>
				<td width="250" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>3分</b></span>
				</td>
				<td width="250" valign="middle" style="word-break: break-all;"
					align="center"><span style="font-size: 12px;"><b>0-2分</b></span>
				</td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
				<td valign="middle" align="center" colspan="1" rowspan="1"
					style="word-break: break-all;"></td>
			</tr>
		</tbody>
	</table>
</body>
<script type="text/javascript">
	var changeRowId = "";
	function changeRow(e) {
		changeRowId = e.id;
	}

	function deleteRow() {
		alert("删除数据：" + changeRowId);

	}
</script>
</html>