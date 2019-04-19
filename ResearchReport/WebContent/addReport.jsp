<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<title>科研项目录入</title>
</head>
<body>
	<div style = "color:red"><s:property value="tips"/></div>
	<form action="${pageContext.request.contextPath}/AddReportAction_addReport" method="post">
	<table style="table-layout:fixed;" border=1; width="900px"; cellpadding=8; cellspacing=0; align=center>
		<tr align=center>
			<td colspan="7">科研项目信息表</td>
		</tr>
		<tr align=center>
			<td colspan="1">项目名称:</td>
			<td colspan="6"><input type="text" name="res_name" required="required"/></td>
		</tr>
		<tr align=center>
			<td colspan="1">项目编号:</td>
			<td colspan="2"><input type="text" name="res_id" required="required"/></td>
			<td colspan="1">项目类别:</td>
			<td colspan="3"><input type="text" name="res_type" required="required"/></td>
		</tr>
		<tr align=center>
			<td colspan="1">项目经费:</td>
			<td colspan="2"><input type="text" name="res_fund" required="required"/></td>
			<td colspan="1">项目填报人:</td>
			<td colspan="3"><input type="text" name="res_host" required="required"/></td>
		</tr>
		<tr align=center>
			<td colspan="1">立项时间:</td>
			<td colspan="2"><input type="text" name="start_time" placeholder="例：2019-01-01" required="required"/></td>
			<td colspan="1">验收时间:</td>
			<td colspan="3"><input type="text" name="end_time" placeholder="例：2019-01-01" required="required"/></td>

		</tr>
		<tr align=center>
		<td rowspan="6">项目主要参与人</td>
		<td>工号</td><td>姓名</td><td>学历</td><td>职称</td><td>单位</td><td>主要贡献</td>
		</tr>
		
		<tr>
		<td><input type="text" name="list[0].tea_id" id="tea_id0" required="required"></td>
		<td><input type="text" name="list[0].part_user" id="part_user0" required="required"></td>
		<td><input type="text" name="list[0].education" id="education0" required="required"></td>
		<td><input type="text" name="list[0].rating" id="rating0"></td>
		<td><input type="text" name="list[0].unit" id="unit0"></td>
		<td><input type="text" name="list[0].effect" id="effect0" required="required"></td>
		</tr>
		
		<tr>
		<td><input type="text" name="list[1].tea_id" id="tea_id1"></td>
		<td><input type="text" name="list[1].part_user" id="part_user1"></td>
		<td><input type="text" name="list[1].education" id="education1"></td>
		<td><input type="text" name="list[1].rating" id="rating1"></td>
		<td><input type="text" name="list[1].unit" id="unit1"></td>
		<td><input type="text" name="list[1].effect" id="effect1"></td>
		</tr>
		
		<tr>
		<td><input type="text" name="list[2].tea_id" id="tea_id2"></td>
		<td><input type="text" name="list[2].part_user" id="part_user2"></td>
		<td><input type="text" name="list[2].education" id="education2"></td>
		<td><input type="text" name="list[2].rating" id="rating2"></td>
		<td><input type="text" name="list[2].unit" id="unit2"></td>
		<td><input type="text" name="list[2].effect" id="effect2"></td>
		</tr>
		
		<tr>
		<td><input type="text" name="list[3].tea_id" id="tea_id3"></td>
		<td><input type="text" name="list[3].part_user" id="part_user3"></td>
		<td><input type="text" name="list[3].education" id="education3"></td>
		<td><input type="text" name="list[3].rating" id="rating3"></td>
		<td><input type="text" name="list[3].unit" id="unit3"></td>
		<td><input type="text" name="list[3].effect" id="effect3"></td>
		</tr>
		
		<tr>
		<td><input type="text" name="list[4].tea_id" id="tea_id4"></td>
		<td><input type="text" name="list[4].part_user" id="part_user4"></td>
		<td><input type="text" name="list[4].education" id="education4"></td>
		<td><input type="text" name="list[4].rating" id="rating4"></td>
		<td><input type="text" name="list[4].unit" id="unit4"></td>
		<td><input type="text" name="list[4].effect" id="effect4"></td>
		</tr>
		
		<tr><td align="center" colspan="7">
		<div align="center" class="layui-form-item layui-form-text">
     		<div align="center" class="layui-input-block">
     			<div align="center" class="editor">
     				<textarea id="content" name="res_content" placeholder="科研报告内容" style="width:890px;height:600px"></textarea>
  	 			</div>
     		</div>
    	</div>
		</td></tr>
		
		<tr>
			<td colspan="7" align=center><button align=center type="submit" name="request">确定</button></td>
		</tr>
	</table>
	</form>
	<style type="text/css">
		table,th,td{
			border:1px solid #328AA4;
		}
		td input{
			border:none;
			width:100%;
			font-size:25px;
		}
	</style>
<script type="text/javascript" charset="utf-8" src="js/kindeditor.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content',
		resizeMode : 1,
        cssPath : './index.css',
        items : [
        'fontname', 'fontsize', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
        'removeformat', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
        'insertunorderedlist']
   			 });
</script>
</body>
</html>