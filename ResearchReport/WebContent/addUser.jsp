<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户信息</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/AddUserAction_addUser" method="post">
		<table>
			<tr>
				<td>用户权限</td>
				<td><select name="permission">
						<option value="teacher" <s:if test="permission=='teacher'">selected="selected"</s:if>>教师</option>
						<option value="admins" <s:if test="permission=='admins'">selected="selected"</s:if>>管理员</option>
				</select></td>
			</tr>
			<tr>
				<td>工号</td>
				<td><input type="text" name="id" required="required" placeholder="职工号或教师工号"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" required="required" placeholder="请输入姓名"></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" required="required" placeholder="请输入用户名"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password" required="required" placeholder="请输入密码"></td>
			</tr>
			<tr>
				<td>院系</td>
				<td><input type="text" name="college" required="required" placeholder="请输入院系"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="telephone" required="required" placeholder="请输入手机号"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="email" name="email"  placeholder="请输入邮箱"></td>
			</tr>
			<tr>
				<td>学历</td>
				<td><input type="text" name="education" required="required" placeholder="请输入学历：如本科"></td>
			</tr>
			<tr>
				<td>职称</td>
				<td><input type="text" name="rating" placeholder="请输入职称：如教授"></td>
			</tr>
		</table>
		<button type="submit" name="addUser">添加</button>
		<div class="tips" style = "color:red">
			<s:property value = "#tips"/>
		</div>
	</form>
</body>
</html>