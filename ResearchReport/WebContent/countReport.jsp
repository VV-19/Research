<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css">
<title>统计科研项目信息</title>
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
	<div  style="padding-left:5px;padding-top:5px;font-size:18px">
		
			<form
				action="${pageContext.request.contextPath }/FindReportAction_countReport"
				method="post">
				<table>
				<tr>
					<td>学年：</td>
					<td><input class="layui-input" type="number" name="year" min="2004" max="2034"
						value="<s:property value="year"/>" placeholder="请输入查询的学年"
						required="required"></td>
					<td style="padding-left:10px">学期：</td>
					<td><select class="layui-input" name="semester">
							<option value="all"
								<s:if test="semester='all'">selected="selected"</s:if>>全部</option>
							<option value="first"
								<s:if test="semester='first'">selected="selected"</s:if>>第一学期</option>
							<option value="second"
								<s:if test="semester='second'">selected="selected"</s:if>>第二学期</option>
					</select></td>

					<td style="padding-left:10px">教师：</td>
					<td><input class="layui-input" type="text" name="tea_id"
						value="<s:property value="tea_id"/>" placeholder="请输入查询的教师名"></td>
					<td><button class="layui-btn" type="submit">查询</button></td>
				</tr>
		</table>
		</form>
		
		<div>
			<form
				action="${pageContext.request.contextPath}/FindReportAction_countXls"
				method="post">
				<table><tr>
					<td>
						报表名 
					</td>
					<td>
						<input class="layui-input" type="text" name="file_name" placeholder="请输入报表名"
							required="required">
					</td>
					<td style="padding-left:10px">
						<button type="submit" class="layui-btn layui-btn-sm">生成报表</button>
					</td>
				</tr>
				</table>
			</form>
		</div>


		<div style="color: red">
			<s:property value="#tips" />
		</div>

		<table>
			<tr>
				<td width="40">序号</td>
				<td width="100">教师工号</td>
				<td width="100">教师姓名</td>
				<td width="105">项目编号</td>
				<td width="150">项目名称</td>
				<td width="105">项目类型</td>
				<td width="100">项目经费</td>
				<td width="100">立项单位</td>
				<td width="105">立项时间</td>
				<td width="100">结题时间</td>
			</tr>
		</table>
		
		<s:iterator value="researchList">
			<form
				action="${pageContext.request.contextPath}/FindReportAction_find"
				name="form" method="post">
				<table style="padding-top:10px">
					<tr>
						<td><input class="layui-input" style="width: 35px" name="number"
							value="<s:property value="number"/>" readonly="readonly"></td>

						<td><input class="layui-input" style="width: 100px" name="tea_id"
							value="<s:property value="tea_id"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="part_user"
							value="<s:property value="part_user"/>" readonly="readonly"></td>

						<td><input class="layui-input" style="width: 100px" name="res_id"
							value="<s:property value="res_id"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 150px" name="res_name"
							value="<s:property value="res_name"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="res_type"
							value="<s:property value="res_type"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="res_fund"
							value="<s:property value="res_fund"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="unit"
							value="<s:property value="unit"/>" readonly="readonly"></td>

						<td><input class="layui-input" style="width: 100px" name="start_time"
							value="<s:property value="start_time"/>" readonly="readonly"></td>
						<td><input class="layui-input" style="width: 100px" name="end_time"
							value="<s:property value="end_time"/>" readonly="readonly"></td>
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