<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
</head>
	<link rel="stylesheet" href="css/table.css"></link>
<body>
	<div>
	<form action="${pageContext.request.contextPath}/UpdateUserAction_updatePassword" method="post">
	<table>
		<tr><td>选择身份</td>
			<td>
			<select name="permission">
				
				<option value="teacher" <s:if test="permission=='teacher'">selected="selected"</s:if>>教师</option>
				<option value="admins" <s:if test="permission=='admins'">selected="selected"</s:if>>管理员</option>
			</select>
			</td>
		</tr>
		<div class="tip_color"><s:property value="tips"/></div>
		<tr><td>输入账号</td><td><input type="text" class="input_pw" name="username" placeholder="请输入账号" required="required"/></td></tr>
		<tr><td>输入旧密码</td><td><input type="password" class="input_pw" name="password" placeholder="请输入旧密码" required="required"/></td></tr>
		<tr><td>输入新密码</td><td><input type="password" class="input_pw" name="newpassword" placeholder="请输入新密码" required="required"/></td></tr>
		<tr><td>确认新密码</td><td><input type="password" class="input_pw" name="twopassword" placeholder="请再次输入新密码" required="required"/></td></tr>
		
			<tr>
			<td><button type="submit" name="update">修改密码</button></td>
			<td><a href="login.jsp">返回登陆</a></td>
			</tr>

	</table></form>	</div>
</body>
</html>