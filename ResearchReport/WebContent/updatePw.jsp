<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>修改密码</title>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="css/table.css"></link>
</head>

<body>
<!-- 内容主体区域 -->
<div style="padding: 10px">
	<h2>修改密码</h2>
	<hr>
	<form 
		action="${pageContext.request.contextPath}/UpdateUserAction_updatePassword"
		method="post">
		<table>
			<tr>
				<td>选择身份</td>
				<td><select name="permission" class="layui-input">
						<option value="teacher"
							<s:if test="permission=='teacher'">selected="selected"</s:if>>教师</option>
						<option value="admins"
							<s:if test="permission=='admins'">selected="selected"</s:if>>管理员</option>
				</select></td>
			</tr>
			<div class="tip_color">
				<s:property value="tips" />
			</div>
			<tr>
				<td >输入账号</td>
				<td><input class="layui-input" type="text" class="input_pw" name="username"
					placeholder="请输入账号" required="required" /></td>
			</tr>
			<tr>
				<td>输入旧密码</td>
				<td><input class="layui-input" type="password" class="input_pw" name="password"
					placeholder="请输入旧密码" required="required" /></td>
			</tr>
			<tr>
				<td>输入新密码</td>
				<td><input class="layui-input" type="password" name="newpassword"
					placeholder="请输入新密码" required="required" /></td>
			</tr>
			<tr>
				<td>确认新密码</td>
				<td><input class="layui-input" type="password" name="twopassword"
					placeholder="请再次输入新密码" required="required" /></td>
			</tr>
			<tr>
				<td><button class="layui-btn" type="submit" name="update">修改密码</button></td>
				<td style="padding-left:10px;"><a href="login.jsp">返回登陆</a></td>
			</tr>
		</table>
	</form>
</div>
</body>

</html>