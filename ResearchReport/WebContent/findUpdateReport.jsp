<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>待审核的科研报告</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/FindReportAction_findUpdateReport" method="post">
			<button type="submit">查询</button>
		</form>
	
	</div>
	
	<div style="color:red"><s:property value="#tips"/></div>
	<div>
		<table>
			<td width="40">序号</td>
			<td width="110">项目编号</td>
			<td width="150">项目名称</td>
			<td width="105">项目类型</td>		
			<td width="105">提交人</td>
			<td width="100">提交时间</td>
			<td width="100">报告状态</td>
			<td width="100">审核进度</td>
			<td width="100">审核结果</td>
		</table>
	</div>

	<div>
	<s:iterator value="researchList">
		<form action="${pageContext.request.contextPath}/UpdateReportAction_updateRequest" name="form" method="post">
		<table>
		<tr>
			<td><input style="width:35px" name="number" value="<s:property value="number"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="res_id" value="<s:property value="res_id"/>" readonly="readonly"></td>
			<td><input style="width:150px" name="res_name" value="<s:property value="res_name"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="res_type" value="<s:property value="res_type"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="res_host" value="<s:property value="res_host"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="report_time" value="<s:property value="report_time"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="res_status" value="<s:property value="res_status"/>" readonly="readonly"></td>
			<td><input style="width:100px" name="upd_status" value="<s:property value="upd_status"/>" readonly="readonly"></td>
			<td><select style="width:80px" name="result">
					<option value="yes">通过</option>
					<option value="no">未通过</option>
				</select>
			</td>
			<td><button type="submit">提交</button></td>
		</tr>
		</table>
		</form>
	</s:iterator>
	</div>
</body>
</html>