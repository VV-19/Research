<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科研信息管理</title>
</head>
<body>
	<div>
	<form action="pageAction.request.actionPath/FindReportAction_findReport" method="post">
		<table>
			<tr>
				<td>查询科研项目</td>
				<td><input type="text" name="res_id" placeholder="项目编号或项目名"></td>
				<td><button type="submit" name="find">查询</button><td>
			</tr>
		</table>
	</form>
	<div style="color:red"><s:property value="#tips"/></div>
	</div>
	
	<div>
		<table>
			<td width="40">序号</td>
			<td width="110">项目编号</td>
			<td width="150">项目名称</td>
			<td width="105">项目类型</td>		
			<td width="105">提交人</td>
			<td width="100">结题时间</td>
			<td width="100">报告状态</td>
			<td width="100">审核进度</td>
		</table>
	</div>
	
	<div>
	<s:iterator value="researchList">
		<form action="${pageContext.request.contextPath}/FindReportAction_find" name="form" method="post">
		<table>
		<tr>
			<td><input style="width:35px" name="number" value="<s:property value="number"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="res_id" value="<s:property value="res_id"/>" readonly="readonly"></td>
			<td><input style="width:150px" name="res_name" value="<s:property value="res_name"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="res_type" value="<s:property value="res_type"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="res_host" value="<s:property value="res_host"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="end_time" value="<s:property value="end_time"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="res_status" value="<s:property value="res_status"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="upd_status" value="<s:property value="upd_status"/>" readonly="readonly"></td>
			<td><button type="submit">详细</button></td>

		</tr>
		</table>
		</form>
	</s:iterator>
	</div>	
	
</body>
</html>