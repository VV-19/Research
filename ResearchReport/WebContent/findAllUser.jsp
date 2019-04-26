<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- css的外联接 -->
	<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" href="layui/css/layui.css">
<title>查询全部用户</title>
  <style type="text/css">
	table {
		border-collapse: separate;
		border-spacing: 0px 5px;
	}
</style>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">科研管理系统管理员界面</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item"><a href="LogOutAction_logOut">注销</a></li>
    </ul>
		</div>

		<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">用户信息</a>
          <dl class="layui-nav-child">
            <dd><a href="findAllUser.jsp">查询全部用户</a></dd>
            <dd><a href="addUser.jsp">添加用户信息</a></dd>
            <dd><a href="findUser.jsp">修改用户信息</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">科研信息管理</a>
          <dl class="layui-nav-child">
            <dd><a href="findReport.jsp">查询科研信息</a></dd>
            <dd><a href="findReportByTime.jsp">按时间查询科研项目</a></dd>
            <dd><a href="countReport.jsp">统计科研项目信息</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
        <a href="FindReportAction_findUpdateReport">待审核科研项目</a>
        </li>
      </ul>
    </div>
  </div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
	<div style="padding:10px">
	<div>
	<form action="${pageContext.request.contextPath}/FindUserAction_findAllUser">
		<table>
			<tr>
			<td>
		<select name="permission" class="layui-input" style="width:100px">
			<option value="teacher" <s:if test="permission=='teacher'">selected="selected"</s:if>>教师</option>
			<option value="admins" <s:if test="permission=='admins'">selected="selected"</s:if>>管理员</option>
		</select>
			</td>
			<td style="padding-left:10px;">
			<button class="layui-btn" type="submit" name="findAll">查询全部</button>
			</td>
			</tr>
		<div style="color:red"><s:property value="#tips"/></div>
		</table>
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
		<td width="50">删除<td>
	</tr>
	</table>
	<s:iterator value="userList">
	<form action="${pageContext.request.contextPath}/UpdateUserAction_deleteUser" method="post">
	<table>
		<tr>
			<td><input class="layui-input" name="id" value="<s:property value="id"/>"></td>
			<td><input class="layui-input" name="name" value="<s:property value="name"/>"></td>
			<td><input class="layui-input" name="username" value="<s:property value="username"/>"></td>
			<td><input class="layui-input" name="password" value="<s:property value="password"/>"></td>
			<td><input class="layui-input" name="college" value="<s:property value="college"/>"></td>
			<td><input class="layui-input" name="telephone" value="<s:property value="telephone"/>"></td>
			<td><input class="layui-input" style="width:150px" name="email" value="<s:property value="email"/>"></td>
			<td><input class="layui-input" name="education" value="<s:property value="education"/>"></td>
			<td><input class="layui-input" name="rating" value="<s:property value="rating"/>"></td>
			<td><button class="layui-btn" type="submit">删除</button></td>
		</tr>
	</table>
	</form>
	</s:iterator>
	</div>
	</div>
				<div class="layui-footer">
				<!-- 底部固定区域 -->
			</div>
		</div>
	</div>
		<script src="layui/layui.js"></script>
		<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>