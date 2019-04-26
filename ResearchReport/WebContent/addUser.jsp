<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css">
<title>添加用户</title>
<style type="text/css">
	table {
		border-collapse: separate;
		border-spacing: 0px 10px;
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
	<div style="padding-top:10px;padding-left:10px">
	<form action="${pageContext.request.contextPath}/AddUserAction_addUser" method="post">
		<table>
			<tr>
				<td>用户权限</td>
				<td><select name="permission" class="layui-input">
						<option value="teacher" <s:if test="permission=='teacher'">selected="selected"</s:if>>教师</option>
						<option value="admins" <s:if test="permission=='admins'">selected="selected"</s:if>>管理员</option>
				</select></td>
			</tr>
			<tr>
				<td>工号</td>
				<td><input class="layui-input" type="text" name="id" required="required" placeholder="职工号或教师工号"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input class="layui-input" type="text" name="name" required="required" placeholder="请输入姓名"></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input class="layui-input" type="text" name="username" required="required" placeholder="请输入用户名"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input class="layui-input" type="text" name="password" required="required" placeholder="请输入密码"></td>
			</tr>
			<tr>
				<td>院系</td>
				<td><input class="layui-input" type="text" name="college" required="required" placeholder="请输入院系"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input class="layui-input" type="text" name="telephone" required="required" placeholder="请输入手机号"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input class="layui-input" type="email" name="email"  placeholder="请输入邮箱"></td>
			</tr>
			<tr>
				<td>学历</td>
				<td><input class="layui-input" type="text" name="education" required="required" placeholder="请输入学历：如本科"></td>
			</tr>
			<tr>
				<td>职称</td>
				<td><input class="layui-input" type="text" name="rating" placeholder="请输入职称：如教授"></td>
			</tr>
		</table>
		<button class="layui-btn" type="submit" name="addUser">添加</button>
		<div class="tips" style = "color:red">
			<s:property value = "#tips"/>
		</div>
	</form>
	</div>
	</div>
	
	  <div class="layui-footer">
    <!-- 底部固定区域 -->

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