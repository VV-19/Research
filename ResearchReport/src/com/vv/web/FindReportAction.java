package com.vv.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vv.domain.Research;
import com.vv.domain.Teacher;
import com.vv.service.FindReportService;

public class FindReportAction extends ActionSupport implements ModelDriven<Research>{
	Research research = new Research();
	String tips="";
	boolean success;
	//查询报告具体信息并修改
	public String find() throws Exception{
		System.out.println("find()的"+research.getRes_id());
		FindReportService findReportService = new FindReportService();
		findReportService.find(research);
		return "updateReport";
	}
	//查询报告具体信息
	public String reportContent() throws Exception{
		System.out.println("find()的"+research.getRes_id());
		FindReportService findReportService = new FindReportService();
		findReportService.find(research);
		return "reportContent";
	}
	
	//查询全部报告
	public String findReport() throws Exception {
		FindReportService findReportService = new FindReportService();
		success = findReportService.findReport(research);
		if(!success) {
			tips = "该科研项目不存在";
		}
			ActionContext.getContext().put("tips", tips);
			return "findReport";
	}
	//查询教师的全部报告
	public String findReportById() throws Exception {
		Teacher teachers = (Teacher) ActionContext.getContext().getSession().get("user");
		System.out.println("teachers.getId()==="+teachers.getId());
		research.setTea_id(teachers.getId());
		FindReportService findReportService = new FindReportService();
		success = findReportService.findReportById(research);
		if(!success) {
			tips = "该科研项目不存在";
		}
			ActionContext.getContext().put("tips", tips);
			return "findReportById";
	}
	//查询待审核报告
	public String findUpdateReport() throws Exception{
		FindReportService findReportService = new FindReportService();
		success = findReportService.findUpdateReport(research);
		if(!success) {
			tips="没有待审核的科研报告";
		}
		return "findUpdateReport";
	}
	//按时间查询
	public String findReportByTime() throws Exception{
		int year = research.getYear();
		String semester = research.getSemester();
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String lastYear = String.valueOf(year-1);
		//第一学期开始日期
		String first_start = lastYear+"-09-01";
		//第一学期截至及第二学期开始日期
		String first_stop = String.valueOf(year)+"-03-01";
		//第二学期截至日期
		String second_stop = String.valueOf(year)+"-09-01";
		System.out.println("第一学期截止日期==="+first_stop);
		if(semester.equals("all")) {
			research.setStart_Date(first_start);
			research.setStop_Date(second_stop);
		}else if(semester.equals("first")) {
			research.setStart_Date(first_start);
			research.setStop_Date(first_stop);
		}else if(semester.equals("second")) {
			research.setStart_Date(first_stop);
			research.setStop_Date(second_stop);
		}
		FindReportService findReport = new FindReportService();
		success = findReport.findReportByTime(research);
		if(!success) {
			tips = "未查询到你所需要的项目信息";
		}
		ActionContext.getContext().put("tips", tips);
		return "findReportByTime";				
	}
	//统计科研项目信息
	public String countReport() throws Exception{
		int year = research.getYear();
		String semester = research.getSemester();
		String lastYear = String.valueOf(year-1);
		//第一学期开始日期
		String first_start = lastYear+"-09-01";
		//第一学期截至及第二学期开始日期
		String first_stop = String.valueOf(year)+"-03-01";
		//第二学期截至日期
		String second_stop = String.valueOf(year)+"-09-01";
		System.out.println("第一学期截止日期==="+first_stop);
		if(semester.equals("all")) {
			research.setStart_Date(first_start);
			research.setStop_Date(second_stop);
		}else if(semester.equals("first")) {
			research.setStart_Date(first_start);
			research.setStop_Date(first_stop);
		}else if(semester.equals("second")) {
			research.setStart_Date(first_stop);
			research.setStop_Date(second_stop);
		}
		FindReportService findReport = new FindReportService();
		success = findReport.findReportByTime(research);
		if(!success) {
			tips = "未查询到你所需要的项目信息";
		}
		ActionContext.getContext().put("tips", tips);
		return "countReport";
	}
	//统计指定教师科研项目信息
	public String countReportById() throws Exception {
		Teacher teachers = (Teacher) ActionContext.getContext().getSession().get("user");
		research.setTea_id(teachers.getId());
		int year = research.getYear();
		String semester = research.getSemester();
		String lastYear = String.valueOf(year - 1);
		// 第一学期开始日期
		String first_start = lastYear + "-09-01";
		// 第一学期截至及第二学期开始日期
		String first_stop = String.valueOf(year) + "-03-01";
		// 第二学期截至日期
		String second_stop = String.valueOf(year) + "-09-01";
		System.out.println("第一学期截止日期===" + first_stop);
		if (semester.equals("all")) {
			research.setStart_Date(first_start);
			research.setStop_Date(second_stop);
		} else if (semester.equals("first")) {
			research.setStart_Date(first_start);
			research.setStop_Date(first_stop);
		} else if (semester.equals("second")) {
			research.setStart_Date(first_stop);
			research.setStop_Date(second_stop);
		}
		FindReportService findReport = new FindReportService();
		success = findReport.countReportById(research);
		if (!success) {
			tips = "未查询到你所需要的项目信息";
		}
		ActionContext.getContext().put("tips", tips);
		return "countReportById";
	}
	//生成指定教师报表
	public String countXlsById() throws Exception{
		System.out.println("教师的research==="+research.getFile_name());
		FindReportService findReport = new FindReportService();
		success = findReport.count_xls(research);
		if(!success) {
			tips="你未查到任何信息";
		}else {
			tips=research.getFile_name()+"报表已在桌面生成";
		}
		ActionContext.getContext().put("tips", tips);
		return "countReportById";
	}
	//生成报表
	public String countXls() throws Exception{
		System.out.println("管理员的research==="+research.getFile_name());
		FindReportService findReport = new FindReportService();
		success = findReport.count_xls(research);
		if(!success) {
			tips="你未查到任何信息";
		}else {
			tips=research.getFile_name()+"报表已在桌面生成";
		}
		ActionContext.getContext().put("tips", tips);
		return "countReport";
	}

	@Override
	public Research getModel() {
		return research;
	}
	
}
