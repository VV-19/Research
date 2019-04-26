<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>科研项目信息</title>
  <%
   String path = request.getContextPath();
   String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
  <link rel="stylesheet" href="layui/css/layui.css">
  <style type="text/css">
	table {
		border-collapse: separate;
		border-spacing: 0px 5px;
	}
</style>
</head>		
				   
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
	<!-- 头部div -->
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
  
  <!-- 右侧div -->
  <div class="layui-body" style="padding-left:5px;padding-top:5px">
    <!-- 内容主体区域 -->
		<form
			action="pageAction.request.actionPath/FindReportAction_findReportById"
			method="post">
			<table>
				<tr>
					<td>查询科研项目</td>
					<td style="padding-left:5px;"><input class="layui-input" type="text" name="res_id" placeholder="项目编号或项目名"></td>
					<td style="padding-left:5px;"><button class="layui-btn layui-btn-sm" type="submit" name="find">查询</button>
					<td>
				</tr>
			</table>
		</form>
		<div style="color: red">
			<s:property value="#tips" />
		</div>

		<table>
			<tr>
				<td width="40">序号</td>
				<td width="100">项目编号</td>
				<td width="150">项目名称</td>
				<td width="105">项目类型</td>
				<td width="105">提交人</td>
				<td width="100">教师姓名</td>
				<td width="100">结题时间</td>
				<td width="100">报告状态</td>
				<td width="100">审核进度</td>
			</tr>
		</table>

	<div>
		<s:iterator value="researchList">
			<form
				action="${pageContext.request.contextPath}/FindReportAction_find"
				name="form" method="post">
				<table>
					<tr>
						<td><input class="layui-input" style="width: 35px" name="number"
							value="<s:property value="number"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="res_id"
							value="<s:property value="res_id"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 150px" name="res_name"
							value="<s:property value="res_name"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="res_type"
							value="<s:property value="res_type"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="res_host"
							value="<s:property value="res_host"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="part_user"
							value="<s:property value="part_user"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="end_time"
							value="<s:property value="end_time"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="res_status"
							value="<s:property value="res_status"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="upd_status"
							value="<s:property value="upd_status"/>" readonly="readonly"></td>
						<td style="padding-left:10px"><button class="layui-btn" type="submit">详细</button></td>
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
<script src="layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>