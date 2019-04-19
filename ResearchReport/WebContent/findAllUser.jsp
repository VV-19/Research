<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询全部用户</title>
</head>
</*css的外联接*/>
		<link rel="stylesheet" href="css/table.css" />
<body>
	<div>
	<form action="${pageContext.request.contextPath}/FindUserAction_findAllUser">
		<select name="permission">
			<option value="teacher" <s:if test="permission=='teacher'">selected="selected"</s:if>>教师</option>
			<option value="admins" <s:if test="permission=='admins'">selected="selected"</s:if>>管理员</option>
		</select>
		<button type="submit" name="findAll">查询全部</button>
		<div style="color:red"><s:property value="#tips"/></div>
	</form>
	</div>
	
	<div>
	<table>
	<tr>
		<td width="100">工号</td>
		<td width="100">姓名</td>
		<td width="100">用户名</td>
		<td width="100">密码</td>
		<td width="100">院系</td>
		<td width="100">电话</td>
		<td width="150">邮箱</td>
		<td width="100">学历</td>
		<td width="100">职称</td>
		<td width="100">删除<td>
	</tr>
		<s:iterator value="userList">
		<form action="${pageContext.request.contextPath}/UpdateUserAction_deleteUser" method="{1}">
		<tr>
			<td><input name="id" value="<s:property value="id"/>"></td>
			<td><input name="name" value="<s:property value="name"/>"></td>
			<td><input name="username" value="<s:property value="username"/>"></td>
			<td><input name="password" value="<s:property value="password"/>"></td>
			<td><input name="college" value="<s:property value="college"/>"></td>
			<td><input name="telephone" value="<s:property value="telephone"/>"></td>
			<td><input style="width:150px" name="email" value="<s:property value="email"/>"></td>
			<td><input name="education" value="<s:property value="education"/>"></td>
			<td><input name="rating" value="<s:property value="rating"/>"></td>
			<td><button type="submit">删除</button></td>
		</tr>
		</form>
		</s:iterator>
	</table>
	</div>
</body>
</html>