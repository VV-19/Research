package com.vv.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vv.domain.Research;
import com.vv.service.FindReportService;

public class FindReportAction extends ActionSupport implements ModelDriven<Research>{
	Research research = new Research();
	String tips="";
	boolean success;
	//查询报告具体信息
	public String find() throws Exception{
		System.out.println("find()的"+research.getRes_id());
		FindReportService findReportService = new FindReportService();
		findReportService.find(research);
		return "updateReport";
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
	//查询待审核报告
	public String findUpdateReport() throws Exception{
		FindReportService findReportService = new FindReportService();
		success = findReportService.findUpdateReport(research);
		if(!success) {
			tips="没有待审核的科研报告";
		}
		return "findUpdateReport";
	}
	
	
	@Override
	public Research getModel() {
		return research;
	}
	
}
