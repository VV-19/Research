<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询用户信息</title>
</head>
<body>
	<!--查找用户表单  -->
	<div>
	<form action="${pageContext.request.contextPath}/FindUserAction_findMessage" method = "post">
		<table>
			<tr>
				<td>请输入用户身份</td>
				<td><select name="permission">
						<option value="teacher" <s:if test="permission=='teacher'">selected="selected"</s:if>>教师</option>
						<option value="admins" <s:if test="permission=='admins'">selected="selected"</s:if>>管理员</option>
					</select>
				</td>
			</tr>
			<tr><td>输入工号或姓名</td>
				<td><input type="text" name="id"></td>
				<td><button type="sumbit" name="find">查询</button></td>
			</tr>
		</table>
	</form>
	</div>
	
	<!--显示查询结果表  -->
	<div>
		<form action="${pageContext.request.contextPath}/UpdateUserAction_updateUser" method="post">
		<table>
			<tr><td>工号</td><td><input type="text"  name="id" readonly="readonly" value="<s:property value="id"/>"></td></tr>
			<tr><td>姓名</td><td><input type="text" name="name" readonly="readonly" value="<s:property value="name"/>"></td></tr>
			<tr><td>用户名</td><td><input type="text" name="username" readonly="readonly" value="<s:property value="username"/>"></td></tr>
			<tr><td>密码</td><td><input type="password" name="password" style="width:150px" readonly="readonly" value="<s:property value="password"/>"></td></tr>
			<tr><td>院系</td><td><input type="text" name="college" value="<s:property value="college"/>"></td></tr>
			<tr><td>电话</td><td><input type="text" name="telephone" value="<s:property value="telephone"/>"></td></tr>
			<tr><td>邮箱</td><td><input type="email" name="email" value="<s:property value="email"/>"></td></tr>
			<tr><td>学历</td><td><input type="text" name="education" value="<s:property value="education"/>"></td></tr>
			<tr><td>职称</td><td><input type="text" name="rating" value="<s:property value="rating"/>"></td></tr>
			<tr><td><button type="submit" name="update">修改</button></td>
			<div style="color:red">
				<s:property value="tips"/>
			</div>
		</table>
		</form>
		
	</div>
</body>
</html>