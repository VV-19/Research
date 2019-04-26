<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css">
<title>修改个人信息</title>
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
    <div class="layui-logo">科研管理系统教师界面</div>
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
            <dd><a href="FindUserAction_findUserById">我的信息</a></dd>
            <dd><a href="FindUserAction_updateUserById">修改信息</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">科研信息管理</a>
          <dl class="layui-nav-child">
            <dd><a href="addReport.jsp">新建科研项目</a></dd>
            <dd><a href="findReportById.jsp">查询科研项目</a></dd>
            <dd><a href="countReportById.jsp">统计科研项目</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<!--查找用户表单  -->
			<div style="padding: 15px;">

				<!--显示查询结果表  -->
				<div>
					<form
						action="${pageContext.request.contextPath}/UpdateUserAction_updateTeacher"
						method="post">
						<table>
							<tr>
								<td>工号</td>
								<td><input class="layui-input" type="text" name="id" readonly="readonly"
									value="<s:property value="id"/>"></td>
							</tr>
							<tr>
								<td>姓名</td>
								<td><input class="layui-input" type="text" name="name" readonly="readonly"
									value="<s:property value="name"/>"></td>
							</tr>
							<tr>
								<td>用户名</td>
								<td><input class="layui-input" type="text" name="username" readonly="readonly"
									value="<s:property value="username"/>"></td>
							</tr>
							<tr>
								<td>密码</td>
								<td><input class="layui-input" type="text" name="password" readonly="readonly"
									value="<s:property value="password"/>"></td>
							</tr>
							<tr>
								<td>院系</td>
								<td><input class="layui-input" type="text" name="college"
									value="<s:property value="college"/>"></td>
							</tr>
							<tr>
								<td>电话</td>
								<td><input class="layui-input" type="number" name="telephone"
									value="<s:property value="telephone"/>"></td>
							</tr>
							<tr>
								<td>邮箱</td>
								<td><input class="layui-input" type="email" name="email"
									value="<s:property value="email"/>"></td>
							</tr>
							<tr>
								<td>学历</td>
								<td><input class="layui-input" type="text" name="education"
									value="<s:property value="education"/>"></td>
							</tr>
							<tr>
								<td>职称</td>
								<td><input class="layui-input" type="text" name="rating"
									value="<s:property value="rating"/>"></td>
							</tr>
						</table>
						<div>
							修改用户信息：
							<button class="layui-btn layui-btn-lg" type="submit" name="update">修改</button>
						</div>
						<div style="color: red">
							<s:property value="tips" />
						</div>
					</form>
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