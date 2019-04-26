<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css">
<title>待审核的科研报告</title>
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
			<div style="padding: 10px;">

				<div style="color: red">
					<s:property value="#tips" />
				</div>
				<div>
					<table>
					<tr>
						<td width="40">序号</td>
						<td width="110">项目编号</td>
						<td width="150">项目名称</td>
						<td width="105">项目类型</td>
						<td width="105">提交人</td>
						<td width="100">提交时间</td>
						<td width="100">报告状态</td>
						<td width="105">审核进度</td>
						<td width="100">是否通过</td>
						</tr>
					</table>
				</div>

				<div style="padding-top:10px">
					<s:iterator value="researchList">
						<form
							action="${pageContext.request.contextPath}/UpdateReportAction_updateRequest"
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
									<td><input class="layui-input" style="width: 100px" name="report_time"
										value="<s:property value="report_time"/>" readonly="readonly"></td>
									<td><input class="layui-input" style="width: 100px" name="res_status"
										value="<s:property value="res_status"/>" readonly="readonly"></td>
									<td><input class="layui-input" style="width: 100px" name="upd_status"
										value="<s:property value="upd_status"/>" readonly="readonly"></td>
									<td style="padding-left:5px;"><select class="layui-input" style="width: 80px" name="result">
											<option value="yes">通过</option>
											<option value="no">未通过</option>
									</select></td>
									<td style="padding-left:5px;"><button class="layui-btn" type="submit">提交</button></td>
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