<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>科研项目信息</title>
<link rel="stylesheet" href="layui/css/layui.css">

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
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">用户信息</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="FindUserAction_findUserById">我的信息</a>
							</dd>
							<dd>
								<a href="FindUserAction_updateUserById">修改信息</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">科研信息管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="addReport.jsp">新建科研项目</a>
							</dd>
							<dd>
								<a href="findReportById.jsp">查询科研项目</a>
							</dd>
							<dd>
								<a href="countReport.jsp">统计科研项目</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="color: red">
				<s:property value="tips" />
			</div>
			<div style="margin-top: 10px">
				<form
					action="${pageContext.request.contextPath}/UpdateReportAction_updateReport"
					name="reportform" method="post">
					<table style="table-layout:fixed; margin-top:10px; margin:auto;width:900px; font-size:20px">
						<tr align=center>
							<th colspan="7" style="height:40px;font-size:25px;">科研项目信息表</th>
						</tr>
						<tr align=center>
							<td colspan="1">项目名称:</td>
							<td colspan="6"><input type="text" name="res_name"
								value="<s:property value="#request.list[0].res_name"/>"
								readonly="readonly" /></td>
						</tr>
						<tr align=center>
							<td colspan="1">项目编号:</td>
							<td colspan="2"><input type="text" name="res_id"
								value="<s:property value="#request.list[0].res_id"/>"
								readonly="readonly" /></td>
							<td colspan="1">项目类别:</td>
							<td colspan="3"><input type="text" name="res_type"
								value="<s:property value="#request.list[0].res_type"/>"
								readonly="readonly" /></td>
						</tr>
						<tr align=center>
							<td colspan="1">项目经费:</td>
							<td colspan="2"><input type="text" name="res_fund"
								value="<s:property value="#request.list[0].res_fund"/>"
								readonly="readonly" /></td>
							<td colspan="1">项目填报人:</td>
							<td colspan="3"><input type="text" name="res_host"
								value="<s:property value="#request.list[0].res_host"/>"
								readonly="readonly" /></td>
						</tr>
						<tr align=center>
							<td colspan="1">立项时间:</td>
							<td colspan="2"><input type="text" name="start_time"
								value="<s:property value="#request.list[0].start_time"/>"
								readonly="readonly" /></td>
							<td colspan="1">验收时间:</td>
							<td colspan="3"><input type="text" name="end_time"
								value="<s:property value="#request.list[0].end_time"/>"
								readonly="readonly" /></td>
						</tr>
						<tr align=center>
							<td colspan="1">报告状态:</td>
							<td colspan="2"><input type="text" name="res_status"
								value="<s:property value="#request.list[0].res_status"/>"
								readonly="readonly" /></td>
							<td colspan="1">填表时间</td>
							<td colspan="3"><input type="text" name="report_time"
								value="<s:property value="#request.list[0].report_time"/>"
								readonly="readonly" /></td>
						</tr>
						<tr align=center>
							<td rowspan="6">项目主要参与人</td>
							<td>工号</td>
							<td>姓名</td>
							<td>学历</td>
							<td>职称</td>
							<td>单位</td>
							<td>主要贡献</td>
						</tr>

						<tr>
							<td><input type="text" name="list[0].tea_id"
								value="<s:property value="#request.list[0].tea_id"/>"
								id="tea_id0" readonly="readonly"></td>
							<td><input type="text" name="list[0].part_user"
								value="<s:property value="#request.list[0].part_user"/>"
								id="part_user0" readonly="readonly"></td>
							<td><input type="text" name="list[0].education"
								value="<s:property value="#request.list[0].education"/>"
								id="education0" readonly="readonly"></td>
							<td><input type="text" name="list[0].rating"
								value="<s:property value="#request.list[0].rating"/>"
								id="rating0" readonly="readonly"></td>
							<td><input type="text" name="list[0].unit"
								value="<s:property value="#request.list[0].unit"/>" id="unit0"
								readonly="readonly"></td>
							<td><input type="text" name="list[0].effect"
								value="<s:property value="#request.list[0].effect"/>"
								id="effect0" readonly="readonly"></td>
						</tr>
						<tr>
							<td><input type="text" name="list[1].tea_id"
								value="<s:property value="#request.list[1].tea_id"/>"
								id="tea_id1" readonly="readonly"></td>
							<td><input type="text" name="list[1].part_user"
								value="<s:property value="#request.list[1].part_user"/>"
								id="part_user1" readonly="readonly"></td>
							<td><input type="text" name="list[1].education"
								value="<s:property value="#request.list[1].education"/>"
								id="education1" readonly="readonly"></td>
							<td><input type="text" name="list[1].rating"
								value="<s:property value="#request.list[1].rating"/>"
								id="rating1" readonly="readonly"></td>
							<td><input type="text" name="list[1].unit"
								value="<s:property value="#request.list[1].unit"/>" id="unit1"
								readonly="readonly"></td>
							<td><input type="text" name="list[1].effect"
								value="<s:property value="#request.list[1].effect"/>"
								id="effect1" readonly="readonly"></td>
						</tr>
						<tr>
							<td><input type="text" name="list[2].tea_id"
								value="<s:property value="#request.list[2].tea_id"/>"
								id="tea_id2" readonly="readonly"></td>
							<td><input type="text" name="list[2].part_user"
								value="<s:property value="#request.list[2].part_user"/>"
								id="part_user2" readonly="readonly"></td>
							<td><input type="text" name="list[2].education"
								value="<s:property value="#request.list[2].education"/>"
								id="education2" readonly="readonly"></td>
							<td><input type="text" name="list[2].rating"
								value="<s:property value="#request.list[2].rating"/>"
								id="rating2" readonly="readonly"></td>
							<td><input type="text" name="list[2].unit"
								value="<s:property value="#request.list[2].unit"/>" id="unit2"
								readonly="readonly"></td>
							<td><input type="text" name="list[2].effect"
								value="<s:property value="#request.list[2].effect"/>"
								id="effect2" readonly="readonly"></td>
						</tr>
						<tr>
							<td><input type="text" name="list[3].tea_id"
								value="<s:property value="#request.list[3].tea_id"/>"
								id="tea_id3" readonly="readonly"></td>
							<td><input type="text" name="list[3].part_user"
								value="<s:property value="#request.list[3].part_user"/>"
								id="part_user3" readonly="readonly"></td>
							<td><input type="text" name="list[3].education"
								value="<s:property value="#request.list[3].education"/>"
								id="education3" readonly="readonly"></td>
							<td><input type="text" name="list[3].rating"
								value="<s:property value="#request.list[3].rating"/>"
								id="rating3" readonly="readonly"></td>
							<td><input type="text" name="list[3].unit"
								value="<s:property value="#request.list[3].unit"/>" id="unit3"
								readonly="readonly"></td>
							<td><input type="text" name="list[3].effect"
								value="<s:property value="#request.list[3].effect"/>"
								id="effect3" readonly="readonly"></td>
						</tr>
						<tr>
							<td><input type="text" name="list[4].tea_id"
								value="<s:property value="#request.list[4].tea_id"/>"
								id="tea_id4" readonly="readonly"></td>
							<td><input type="text" name="list[4].part_user"
								value="<s:property value="#request.list[4].part_user"/>"
								id="part_user4" readonly="readonly"></td>
							<td><input type="text" name="list[4].education"
								value="<s:property value="#request.list[4].education"/>"
								id="education4" readonly="readonly"></td>
							<td><input type="text" name="list[4].rating"
								value="<s:property value="#request.list[4].rating"/>"
								id="rating4" readonly="readonly"></td>
							<td><input type="text" name="list[4].unit"
								value="<s:property value="#request.list[4].unit"/>" id="unit4"
								readonly="readonly"></td>
							<td><input type="text" name="list[4].effect"
								value="<s:property value="#request.list[4].effect"/>"
								id="effect4" readonly="readonly"></td>
						</tr>

						<tr>
							<td align="center" colspan="7">
								<div class="layui-form-item layui-form-text">
									<div class="editor">
										<textarea id="content" name="res_content" placeholder="科研报告内容"
											style="width: 900px; height: 600px">
     								<s:property value="#request.list[0].res_content" />
     							</textarea>
									</div>
								</div>
							</td>
						</tr>

						<tr>
							<td colspan="7" align=center>
								<button class="layui-btn layui-btn-lg" type="submit" id="updateReport" align="center">修改</button>
								<button class="layui-btn layui-btn-lg" onclick="request()" id="requestPermission"
									align="center">申请修改</button>
							</td>
						</tr>

					</table>
				</form>
			</div>
			<style type="text/css">
table, th, td {
	border: 1px solid #328AA4;
}

td input {
	border: none;
	width: 95%;
	height:40px;
	font-size:25px;
	margin-left:2px;
}
</style>
			<script>
				function request() {
					document.reportform.action = "${pageContext.request.contextPath}/UpdateReportAction_requestPermission";
					document.reportform.submit();
				}
			</script>
			<script type="text/javascript" charset="utf-8" src="js/kindeditor.js"></script>
			<script type="text/javascript">
				KE.show({
					id : 'content',
					resizeMode : 1,
					cssPath : './index.css',
					items : [ 'fontname', 'fontsize', 'textcolor', 'bgcolor',
							'bold', 'italic', 'underline', 'removeformat',
							'justifyleft', 'justifycenter', 'justifyright',
							'insertorderedlist', 'insertunorderedlist' ]
				});
			</script>
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