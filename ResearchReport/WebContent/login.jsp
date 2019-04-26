<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri = "/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆页面</title>
</head>
<!-- css的外联接 -->
<link rel="stylesheet" href="css/login.css" />

<body background="images/bgground.jpg">
	<div class = "type">教师科研及项目信息管理系统</div>
	<div class = "a">
		<div class = "title">
			用户登录
		</div>
		<form action = "${pageContext.request.contextPath}/UserAction_login" method = "post">
			<table class="c">
			<tr><td>登陆身份</td>
				<td><select name ="permission" class = "select">
						<option value="teacher" <s:if test="permission=='teacher'">selected="selected"</s:if>>教师</option>
						<option value="admins" <s:if test="permission=='admins'">selected="selected"</s:if>>管理员</option>
					</select></td>
			</tr>
			</table>
				
			<table class = "b c">
			<tr><td>账号</td>
				<td><input class="text" type="text" name="username" placeholder="请输入账号">
				</td>
			</tr>
			</table>
			
			<table  class = "b c">
			<tr><td>密码</td>
				<td><input class="text" type="password" name="password" placeholder="请输入密码">
				</td>
			</tr>
			</table>
			<div class="updatepw">
				<a href="updatePw.jsp">修改密码</a>
			</div>
			<div class="text b">
				<button class="button" type="submit" id="submit_btn">立即登录</button>
			</div>
			<div style="color:red; margin-top:10px;font-size:25px">
			<s:property value = "#error"/>
			</div>
		</form>
	</div>
</body>
</html>