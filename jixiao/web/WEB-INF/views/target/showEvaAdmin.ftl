<#import "spring.ftl" as s />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>管理人员考核</title>
    <script src="<@s.url '/js/boot.js'/>" type="text/javascript"></script>
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
        input{
            width:100%;

        }

    </style>
</head>
<body><!-- onload="bodyOnload()" -->
<!--  
	<input type="button" id="tool1Save" value="提交" style="width:40px; height: 30px" onclick="submit()" />
	<input type="button" id="tool1Save" value="退出" style="width:40px; height: 30px" onclick="back()" />
	<input type="button" id="tool1Save" value="通过" style="width:40px; height: 30px" onclick="pass()" />
	-->
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
            colspan="1"><span style="font-size: 12px;"><b>权重(%)</b></span></td>
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
							<input type="button" id="tool1Add" style="display:none" value="添加" style="width:40px;"
                                   onclick="add()" />
							<input type="button" id="tool1Del" style="display:none" value="删除" style="width:40px;"
                                   onclick="deleteRow()" />
					</span>
				</span></td>
    </tr>
    <!-- ==================================onclick="getClick(this,this.value)"=========================================================== -->
	<#list taps as tap>
    <tr id="${tap.p04.p0400 }" ><!-- onclick="changeRow(this)" -->

        <td width="120" valign="middle" align="center" colspan="1"
            rowspan="1" style="word-break: break-all;">
            <span>${tap.p04.p0407 }</span>
        </td>

        <td width="150" valign="middle" align="center" colspan="1"
            rowspan="1" style="word-break: break-all;">
            <span>${tap.p04.p04BK }</span>
            <select id="selectList"  disabled="disabled" name="P04BA" onchange="getSelectName(this,this.name)" style="width: 100%">
				<#if tap.target != null>
					<#if tap.target.desc2 == null || tap.target.desc2 == "">
                        <option id="initValue" value="initValue">请选择达成目标值类型</option>
					<#else>
                        <option value="${tap.target.id }">${tap.target.desc1 }</option>
					</#if>
				</#if>
				<#list targets as target >
					<#if tap.target != null && tap.target.id != target.id>
                        <option value="${target.id }">
						${target.desc1 }
                        </option>
					</#if>
				</#list>
            </select>
        </td>
        <!-- ******************************************************************************* -->

        <td width="96" valign="middle" align="left" colspan="1" rowspan="1"
            style="word-break: break-all;">
			<#if tap.target != null>
                <span>${tap.target.desc2 }</span>
			<#else>
                <span></span>
			</#if>
        </td>
        <td width="96" valign="middle" align="left" colspan="1" rowspan="1"
            style="word-break: break-all;">
			<#if tap.target != null>
                <span>${tap.target.desc3 }</span>
			<#else>
                <span></span>
			</#if>
        </td>
        <td width="96" valign="middle" align="left" colspan="1" rowspan="1"
            style="word-break: break-all;">
			<#if tap.target != null>
                <span>${tap.target.desc4 }</span>
			<#else>
                <span></span>
			</#if>
        </td>

        <td width="96" valign="middle" align="left" colspan="1" rowspan="1"
            style="word-break: break-all;">
			<#if tap.target != null>
                <span>${tap.target.desc5 }</span>
			<#else>
                <span></span>
			</#if>
        </td>
        <td width="96" valign="middle" align="left" colspan="1" rowspan="1"
            style="word-break: break-all;">
			<#if tap.target != null>
                <span>${tap.target.desc6 }</span>
			<#else>
                <span></span>
			</#if>
        </td>

        <!-- ******************************************************************************* -->
        <td width="60" valign="middle" align="center" colspan="1"
            rowspan="1" style="word-break: break-all;">
			<#if tap.target != null>
                <span>${tap.p04.p04BC }</span>
			<#else>
                <span></span>
			</#if>
        </td>
        <td width="60" valign="middle" align="center" colspan="1"
            rowspan="1" style="word-break: break-all;" id="otherAdminRank">
			<#if tap.target != null>
                <span>${tap.p04.p0415 }</span>
			<#else>
                <span></span>
			</#if>
        </td>
        <td width="125" valign="middle" align="center" colspan="1"
            rowspan="1" style="word-break: break-all;">
			<#if tap.target != null>
                <span>${tap.p04.p04Z9 }</span>
			<#else>
                <span></span>
			</#if>
        </td>
        <td width="60" valign="middle" align="center" colspan="1"
            rowspan="1" style="word-break: break-all;">
            <#if tap.evaluationSelfOther != null>
                <span>${tap.evaluationSelfOther.selfScore }</span>
            </#if>
        </td>
        <td width="60" valign="middle" align="center" colspan="1"
            rowspan="1" style="word-break: break-all;" id="scoreEva">
            <#if tap.evaluationSelfOther != null>
                <span>${tap.evaluationSelfOther.otherScore }</span>
            </#if>
            <#--<input type="text" id="otherEva" value="${tap.evaluationSelfOther.otherScore }" onchange="autoSaveEvaValue1(this)" name="oScore" style="width: 100%"/>-->
        </td>
    </tr>
	</#list>
    <!-- ==================================================================================================== -->
    <tr id="lh">
        <td valign="middle" align="left" colspan="12" rowspan="1"
            style="word-break: break-all;; background: #EDEDED"><span
                style="font-size: 12px"> <span
                style="width: 120px; vertical-align: middle"><b>2、量化类指标</b></span>
						<span id="tool2" style="width: 120px; vertical-align: middle">
							<input type="button" id="tool1Add" style="display:none" value="添加" style="width:40px;"
                                   onclick="secondAdd()" />
							<input type="button" id="tool1Del" style="width:40px; display:none;"  value="删除" onclick="secondDelete()" />
					</span>
				</span></td>
    </tr>
	<#list sapes as sape>
    <tr id="${sape.secondP04.p0400 }" ><!-- onclick="secondChangeRow(this)" -->
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${sape.secondP04.p0407 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${sape.secondP04.p04BA }</span>
        </td>
        <td valign="middle" align="center" colspan="5" rowspan="1"
            style="word-break: break-all;">
            <span>${sape.secondP04.p04BB }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${sape.secondP04.p04BC }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;" id="otherAdminRank">
            <span>${sape.secondP04.p0415 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${sape.secondP04.p04Z9 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <#if sape.evaluationSelfOther != null>
                <span>${sape.evaluationSelfOther.selfScore }</span>
            </#if>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;" id="scoreEva">
            <#if sape.evaluationSelfOther != null>
                <span>${sape.evaluationSelfOther.otherScore }</span>
            </#if>
            <#--<input type="text" value="${sape.evaluationSelfOther.otherScore }" onchange="autoSaveEvaValue2(this)" name="oScore" style="width: 100%"/>-->
        </td>
    </tr>
	</#list>
    <!-- ********************************The Second******************************************** -->
    <tr id="tyl">
        <td valign="middle" align="left" colspan="12" rowspan="1"
            style="word-break: break-all;; background: #EDEDED"><span
                style="font-size: 12px;"><b>3、通用类指标</b></span></td>
    </tr>
    <!-- cdass cdasbpis  commonScore common -->
	<#list cdass as cdas>
    <tr id="${cdas.common2Desc.point_id }" onclick="getChangeScore(this)"><!--  onclick="getChangeScore(this)" -->
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.pointname }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.desc1 }</span>
        </td>
        <td valign="middle" align="center" colspan="5" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.desc2 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.desc3 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;" id="otherAdminRank">
            <span>${cdas.common2Desc.rank }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.desc4 }</span>
        </td>
        <td valign="middle" align="center" colspan="2" rowspan="1"
            style="word-break: break-all;" id="scoreEva">
            <#if cdas.commonScore != null>
                <span>${cdas.commonScore.score }</span>
            </#if>
			<#--<#if cdas.commonScore != null>
                <input type="text" onchange="saveCommonScore(this)" value="${cdas.commonScore.score }" name="Score" style="width: 100%"/>
			<#else>
                <input type="text" onchange="saveCommonScore(this)" value="" name="Score" style="width: 100%"/>
			</#if>-->
        </td>
    </tr>
	</#list>
    </tbody>
</table>

<table class="t1" id="tongYongLeiBPI">
    <tbody>
    <tr class="firstRow">
        <td valign="top" style="word-break: break-all;" rowspan="1"
            colspan="12" style="background:yellow"><span
                style="font-size: 14px; color: #836FFF"><b>第二部分：BPI考核指标（20%）</b></span>
        </td>
    </tr>
    <tr>
        <td width="180" valign="middle" style="word-break: break-all;"
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
    <!-- cdass cdasbpis  commonScore common-->
	<#list cdasbpis as cdas>
    <tr id="${cdas.common2Desc.point_id }" onclick="getChangeScore(this)">
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.pointname }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.desc1 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.desc2 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.desc3 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;">
            <span>${cdas.common2Desc.desc4 }</span>
        </td>
        <td valign="middle" align="center" colspan="1" rowspan="1"
            style="word-break: break-all;" id="generalBPI">
            <#if cdas.commonScore != null>
                <span style="width: 100%">${cdas.commonScore.score }</span>
            </#if>
			<#--<#if cdas.commonScore != null>
                <input type="text" onchange="saveCommonScoreBPI(this)" value="${cdas.commonScore.score }" name="Score" style="width: 100%"/>
			<#else>
                <input type="text" onchange="saveCommonScoreBPI(this)" value="" name="Score" style="width: 100%"/>
			</#if>-->
        </td>
    </tr>
	</#list>
    <tr id="tyl">
        <td valign="middle" align="left" colspan="6" rowspan="1"
            style="word-break: break-all;; background: #EDEDED"><span
                style="font-size: 12px;">绩效沟通及反馈（包括绩效优秀之处、存在的问题、提升建议）</span></td>
    </tr>
    <tr>
        <td valign="middle" align="center" colspan="6" rowspan="1"
            style="word-break: break-all;">
            <#if feedBack != null>
                <span style="width: 100%">${feedBack.feedBack}</span>
            </#if>
        </td>
    </tr>
    </tbody>
</table>

<input id="objectid" type="hidden" value="${objectid }"/>
<input id="mainbodyid" type="hidden" value="${mainbodyid }"/>
<input id="planid" type="hidden" value="${planid }"/>
</body>

<script type="text/javascript">

    function saveFeedBack(e){
        var value = e.value;
        var objectId = document.getElementById("objectid").value;
        var planId = document.getElementById("planid").value;
        $.ajax({
            url : "../eva/saveFeedBack",
            data : {
                value : value ,
                objectId :objectId,
                planId : planId
            },
            type : "post",
            success : function(text) {
                //changeRow(row1);
                //document.location.reload(true);
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

    var changeRowId = "";
    var row ;
    var oldRow;

    function changeRow(e) {//选中换颜色！
        row = e;
        if (e != null) {
            changeRowId = e.id;//alert(e.cells);
            for (var i = 0; i < e.cells.length; i++) {
                e.cells[i].style.backgroundColor = "white";//#ffbebe
            }
            if (oldRow != undefined && e != oldRow) {
                for (var j = 0; j < oldRow.cells.length; j++) {
                    oldRow.cells[j].style.backgroundColor = "white";
                }
            }
            oldRow = e;
        }
    }

    function deleteRow() {
        if(changeRowId == ""){
            alert("请点击选择要删除的行！");
        }
        $.ajax({
            url : "../test/deleteRow",
            data : {
                deleteId : changeRowId
            },
            type : "post",
            success : function(text) {
                if (changeRowId != "") {
                    document.location.reload(true);
                }
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

    function setTargetValue(desc2,desc3,desc4,desc5,desc6){
        row.cells[2].getElementsByTagName("span")[0].innerHTML = desc2;
        row.cells[3].getElementsByTagName("span")[0].innerHTML = desc3;
        row.cells[4].getElementsByTagName("span")[0].innerHTML = desc4;
        row.cells[5].getElementsByTagName("span")[0].innerHTML = desc5;
        row.cells[6].getElementsByTagName("span")[0].innerHTML = desc6;
        //row.cells[6].getElementsByTagName("input")[0].value = desc6;
    }

    //ie下拉不兼容处理,设置下拉列表
    var selectName = "";
    function getSelectName(e,name){
        var optionValue = e.options[e.selectedIndex].value;
        selectName = name;
        if (optionValue == "initValue") {
            alert("请选择评分标准！");
            document.location.reload(true);
            return ;
        }
        autoSave(optionValue,selectName);
        var xmlhttp;
        if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else{// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200){
                var text1 = xmlhttp.responseText;
                var text = eval("("+text1+")");
                setTargetValue(text.desc2,text.desc3,text.desc4,text.desc5,text.desc6);
            }
        }
        xmlhttp.open("POST","../test/select",true);
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("selectId="+optionValue);
    }

    function add() {
        var a0100 = document.getElementById("objectid").value;
        var planid = document.getElementById("planid").value;
        $.ajax({
            url : "../test/add",
            data : {
                item_id : "285" ,
                a0100 : a0100 ,
                planid : planid
            },
            type : "post",
            success : function(text) {
                document.location.reload(true);
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

    // ^[0-9]\.[0-9]{1,14}$|^[0-9]$
    function IsNumeric(input){
        var RE = /^[0-9]{1,13}\.?[0-9]{0,4}$/;
        return (RE.test(input));
    }

    function autoSave(value,name){
        //alert(changeRowId);
        if (name == "P0415" && !IsNumeric(value)) {
            alert("权重必须为数字类型，小数点只能为四位有效数字！%号会自动添加！");
            return ;
        }else {
            var xmlhttp;
            if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else{// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function(){
                if (xmlhttp.readyState==4 && xmlhttp.status==200){
                    changeRow(row);
                }
            }
            xmlhttp.open("POST","../test/autoSave",true);
            xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xmlhttp.send("value="+value+"&name="+name+"&changeRowId="+changeRowId+"");
        }
    }
    /////////////////////////////////////////The Second////////////////////////////////////////////////
    /////////////////////////////////////////The Second////////////////////////////////////////////////
    /////////////////////////////////////////The Second////////////////////////////////////////////////

    var changeRowId1 = "";
    var row1 ;
    var oldRow1;
    function secondChangeRow(e){
        row1 = e;
        if (e != null) {
            changeRowId1 = e.id;//alert(e.cells);
            for (var i = 0; i < e.cells.length; i++) {
                e.cells[i].style.backgroundColor = "white";
            }
            if (oldRow1 != undefined && e != oldRow1) {
                for (var j = 0; j < oldRow1.cells.length; j++) {
                    oldRow1.cells[j].style.backgroundColor = "white";
                }
            }
            oldRow1 = e;
        }
    }

    function secondSave(value,name){
        if (name == "P0415" && !IsNumeric(value)) {
            alert("权重必须为数字类型，小数点只能为四位有效数字！%号会自动添加！");
            return ;
        }else {

            $.ajax({
                url : "../test/autoSaveSecond",
                data : {
                    value : value ,
                    name : name ,
                    changeRowId :changeRowId1
                },
                type : "post",
                success : function(text) {
                    changeRow(row1);
                    //document.location.reload(true);
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    function secondAdd() {
        var a0100 = document.getElementById("objectid").value;
        var planid = document.getElementById("planid").value;
        $.ajax({
            url : "../test/secondAdd",
            data : {
                a0100 : a0100,
                planid : planid,
                item_id : "286"
            },
            type : "post",
            success : function(text) {
                document.location.reload(true);
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

    function secondDelete(){
        if(changeRowId1 == ""){
            alert("请点击选择要删除的行！");
        }
        $.ajax({
            url : "../test/deleteSecondRow",
            data : {
                deleteId : changeRowId1
            },
            type : "post",
            success : function(text) {
                if (changeRowId1 != "") {
                    document.location.reload(true);
                }
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    function refashRecord(e) {//实时显示自评分数 otherGeneralRank
        var tableId = e.parentNode.parentNode.parentNode;
        var flag = 0;
        if(tableId != undefined){
            for(var i=4;i<tableId.rows.length;i++){
                var cellList = tableId.rows[i].cells;
                for(var j=0;j<cellList.length;j++){//scoreEva
                    if (cellList[j].id == "otherGeneralRank") {
                        var rankText = parseFloat(cellList[j].innerText);
                        if(cellList[j+3].id == "scoreEva"){
                            var rank = cellList[j+3].getElementsByTagName("input")[0].value;
                            if (rank>rankText || rank<0) {
                                alert("评分不能超过权重分值、也不能小于0；即：0≤评分≤权重分值");
                                return;
                            }
                            //alert(rank);
                            if(rank != ""){
                                flag = flag + parseFloat(rank);
                            }
                        }
                    }
                }
            }
        }
        document.getElementById("nowRecord").innerHTML = "当前评分数总和：("+flag+")分";
        return flag;
    }

    function refashRecordBPI(e) {//实时显示自评分数
        var tableId = e.parentNode.parentNode.parentNode;
        var flag = 0;
        if(tableId != undefined){
            for(var i=3;i<tableId.rows.length;i++){
                var cellList = tableId.rows[i].cells;
                for(var j=0;j<cellList.length;j++){//scoreEva
                    if(cellList[j].id == "generalBPI"){
                        var rank = cellList[j].getElementsByTagName("input")[0].value;
                        if (rank>5 || rank<0) {
                            alert("评分不能超过分值最大值、也不能小于0；即：0≤评分≤分值最大值");
                            return;
                        }
                        //alert(rank);
                        if(rank != ""){
                            flag = flag + parseFloat(rank);
                        }
                    }
                }
            }
        }
        document.getElementById("nowRecordBPI").innerHTML = "当前BPI评分数总和：("+flag+")分";
        return flag;
    }

    function IsNumeric1(input){
        var RE = /^[0-9]{1,26}\.?[0-9]{0}$/;
        return (RE.test(input));
    }

    function autoSaveEvaValue1(e){
        var value = e.value;
        var name = e.name;
        if (name == "sScore" && !IsNumeric1(value)) {
            alert("分数必须为正整数，且总分值不超过100分！");
            e.value = "";
            return ;
        }else if(name == "oScore" && !IsNumeric1(value)){
            alert("分数必须为正整数，且总分值不超过100分！");
            e.value = "";
            return ;
        }else {//其他页面也要搞
            //changeRowId = e.getParentNode.getParentId;判断是否为空，如果为空就帮他初始化
            if (name == "sScore" ) {
                if (parseFloat(value)>100) {
                    alert("评分值不得超过100！");
                    e.value = 0;
                    return ;
                }
                if (parseFloat(value)<0) {
                    alert("评分值不能小于0！");
                    e.value = 0;
                    return ;
                }
            }
            if (name == "oScore" ) {
                if (parseFloat(value)>100) {
                    alert("评分值不得超过100！");
                    e.value = 0;
                    return ;
                }
                if (parseFloat(value)<0) {
                    alert("评分值不能小于0！");
                    e.value = 0;
                    return ;
                }
            }
            if (refashRecord(e) == undefined) {
                e.value = 0;
                return ;
            }
            changeRowId = e.parentElement.parentElement.id;
            //alert(changeRowId);
            var objectid = document.getElementById("objectid").value;
            var mainbodyid = document.getElementById("mainbodyid").value;
            var planid = document.getElementById("planid").value;

            $.ajax({
                url : "../eva/autoSave1",
                data : {
                    "value" : value ,
                    "name" : name ,
                    "changeRowId" :changeRowId,
                    "objectid" : objectid,
                    "mainbodyid" : mainbodyid,
                    "planid" : planid
                },
                type : "post",
                success : function(text) {
                    changeRow(row);
                    //document.location.reload(true);
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
    }

    function autoSaveEvaValue2(e){
        var value = e.value;
        var name = e.name;
        if (name == "sScore" && !IsNumeric1(value)) {
            alert("分数必须为正整数，且总分值不超过100分！");
            e.value = "";
            return ;
        }else if(name == "oScore" && !IsNumeric1(value)){
            alert("分数必须为正整数，且总分值不超过100分！");
            e.value = "";
            return ;
        }else {
            if (name == "sScore" ) {
                if (parseFloat(value)>100) {
                    alert("评分值不得超过100！");
                    e.value = 0;
                    return ;
                }
                if (parseFloat(value)<0) {
                    alert("评分值不能小于0！");
                    e.value = 0;
                    return ;
                }
            }
            if (name == "oScore" ) {
                if (parseFloat(value)>100) {
                    alert("评分值不得超过100！");
                    e.value = 0;
                    return ;
                }
                if (parseFloat(value)<0) {
                    alert("评分值不能小于0！");
                    e.value = 0;
                    return ;
                }
            }
            if (refashRecord(e) == undefined) {
                e.value = 0;
                return ;
            }
            //changeRowId1 = e.parentNode.parentNode.判断是否为空，如果为空就帮他初始化
            changeRowId1 = e.parentElement.parentElement.id;
            //alert(changeRowId1);
            var objectid = document.getElementById("objectid").value;
            var mainbodyid = document.getElementById("mainbodyid").value;
            var planid = document.getElementById("planid").value;
            $.ajax({
                url : "../eva/autoSave2",
                data : {
                    value : value ,
                    name : name ,
                    changeRowId1 :changeRowId1,
                    objectid : objectid,
                    mainbodyid : mainbodyid,
                    planid : planid
                },
                type : "post",
                success : function(text) {
                    changeRow(row);
                    //document.location.reload(true);
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
    }

    function IsNumeric2(input){
        var RE = /^[0-9]{1,4}\.?[0-9]{0,6}$/;
        return (RE.test(input));
    }

    var changeRowIdScore = "";
    var rowScore;
    var oldRowScore;
    function getChangeScore(e){
        rowScore = e;
        changeRowIdScore = e.id;
        for (var i = 0; i < e.cells.length; i++) {
            e.cells[i].style.backgroundColor = "white";
        }
        if (oldRowScore != undefined && e != oldRowScore) {
            for (var j = 0; j < oldRowScore.cells.length; j++) {
                oldRowScore.cells[j].style.backgroundColor = "white";
            }
        }
        oldRowScore = e;
    }

    function saveCommonScore(e){/////////////////////////////////////////
        var value = e.value;
        var name = e.name;
        if (!IsNumeric2(value)) {
            alert("分数必须为正整数，且总分值不超过100分！");
            e.value = "";
            return ;
        }//changeRowId1 = e.parentElement.parentElement.id;
            if (parseFloat(value)>100) {
            alert("评分值不得超过100！");
            e.value = 0;
            return ;
        }
        if (parseFloat(value)<0) {
            alert("评分值不能小于0！");
            e.value = 0;
            return ;
        }
        if (refashRecord(e) == undefined) {
            e.value = 0;
            return ;
        }
        changeRowIdScore = e.parentElement.parentElement.id;
        //alert(changeRowIdScore);
        var objectid = document.getElementById("objectid").value;
        var mainbodyid = document.getElementById("mainbodyid").value;
        var planid = document.getElementById("planid").value;
        //alert(changeRowIdScore);
        $.ajax({
            url : "../eva/saveScore",
            data : {
                scoreValue : value ,
                score : name ,
                objectid : objectid,
                mainbodyid : mainbodyid,
                planid : planid,
                pointid : changeRowIdScore
            },
            type : "post",
            success : function(text) {
                changeRow(rowScore);
                //document.location.reload(true);
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

    function saveCommonScoreBPI(e){/////////////////////////////////////////
        var value = e.value;
        var name = e.name;
        if (!IsNumeric2(value)) {
            alert("分数必须为正整数，且总分值不超过100分！");
            e.value = "";
            return ;
        }//changeRowId1 = e.parentElement.parentElement.id;
        if (parseFloat(value)>100) {
            alert("评分值不得超过100！");
            e.value = 0;
            return ;
        }
        if (parseFloat(value)<0) {
            alert("评分值不能小于0！");
            e.value = 0;
            return ;
        }
        if (refashRecordBPI(e) == undefined) {
            e.value = 0;
            return ;
        }
       // refashRecordBPI(e);
        changeRowIdScore = e.parentElement.parentElement.id;
        //alert(changeRowIdScore);
        var objectid = document.getElementById("objectid").value;
        var mainbodyid = document.getElementById("mainbodyid").value;
        var planid = document.getElementById("planid").value;
        //alert(changeRowIdScore);
        $.ajax({
            url : "../eva/saveScore",
            data : {
                scoreValue : value ,
                score : name ,
                objectid : objectid,
                mainbodyid : mainbodyid,
                planid : planid,
                pointid : changeRowIdScore
            },
            type : "post",
            success : function(text) {
                changeRow(rowScore);
                //document.location.reload(true);
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

    //提交数据的时候表单验证！
    function submit(){//还有下拉列表为验证！
        var inputs = document.getElementsByTagName("input");
        var p0415Value = 0;
        var k = 0;
        for (var i = 0; i < inputs.length; i++) {
            if (inputs[i].name != null && inputs[i].hasAttribute("value") && (inputs[i].value == null || inputs[i].value == "")) {
                alert(inputs[i].name);//此处用来检查input是否为空
                k++;
            }
            if (inputs[i].name == "P0415") {
                //alert(inputs[i].value);//此处用来检测权重项分值是否为100分
                var p = parseInt(inputs[i].value);
                p0415Value += p;
            }
        }
        //alert(p0415Value);
        if (p0415Value != 90) {
            alert("权重分值总和一定为100%！，请检查修改后再提交！");
            return ;
        }else if (k != 0){
            alert("有"+k+"处还为填写！");
            return ;
        }else {
////////////////////////////////////////////////////////////////////////////////////////////////
            var objectid = document.getElementById("objectid").value;
            var planid = document.getElementById("planid").value;
            $.ajax({
                url : "../eva/saveEva",
                data : {
                    //deleteId : changeRowId1 ,
                    sp_flag : "02" ,
                    objectid : objectid ,
                    planid : planid
                },
                type : "post",
                success : function(text) {
                    if (changeRowId1 != "") {
                        document.location.reload(true);
                    }
                    alert(text);
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
            //alert("提交成功！");
        }
    }

    //退回
    function back(){
        var objectid = document.getElementById("objectid").value;
        var planid = document.getElementById("planid").value;
        $.ajax({
            url : "../eva/saveEva",
            data : {
                sp_flag : "07" ,
                objectid : objectid ,
                planid : planid

            },
            type : "post",
            success : function(text) {
                if (changeRowId1 != "") {
                    document.location.reload(true);
                }
                alert(text);
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
        //alert("退出成功！");
    }

    //通过
    function pass(){
        var objectid = document.getElementById("objectid").value;
        var planid = document.getElementById("planid").value;
        $.ajax({
            url : "../eva/saveEva",
            data : {
                sp_flag : "03" ,
                objectid : objectid ,
                planid : planid

            },
            type : "post",
            success : function(text) {
                if (changeRowId1 != "") {
                    document.location.reload(true);
                }
                alert(text);
            },
            error : function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
        //alert("审核通过！");
    }

</script>
</html>

