package com.vv.web;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vv.domain.Research;
import com.vv.service.FindReportService;
import com.vv.service.UpdateReportService;

public class UpdateReportAction extends ActionSupport implements ModelDriven<Research>{
	Research research = new Research();
	String tips = "";
	boolean success ;
	//修改报告
	public String updateReport() throws Exception {
		System.out.println("已到达修改报告Action");
		System.out.println("rese_id==="+research.getRes_id());
		System.out.println("report_status==="+research.getRes_status());
		System.out.println("report_content==="+research.getRes_content());

		if("已提交".equals(research.getRes_status())) {
			System.out.println("修改失败");
			tips = "修改失败，请先申请修改权限";
		}else if("可修改".equals(research.getRes_status())){
			System.out.println("可修改");
			UpdateReportService update = new UpdateReportService();
			success = update.updateReport(research);
			if(success) {
				tips="修改成功";
			}	
		}
		FindReportService findReportService = new FindReportService();
		findReportService.find(research);
		ActionContext.getContext().put("tips",tips);
		return "updateReport";
	}
	
	//申请权限
	public String requestPermission() throws Exception {
		System.out.println("research.getRes_status()==="+research.getRes_status());
		if(research.getRes_status().equals("可修改")) {
			tips="该报告已获得权限，请修改";
		}else {
			UpdateReportService update = new UpdateReportService();
			success = update.requestPermission(research);
			tips="修改报告权限申请成功，等待管理员审核通过后可修改";
		}	
		ActionContext.getContext().put("tips", tips);
		return "findReport";
	}
	
	//提交审核结果
	public String updateRequest() throws Exception{
		System.out.println("resul==="+research.getResult());
		UpdateReportService update = new UpdateReportService();
		success = update.updateRequest(research);
		if(success) {
			tips = "审核结果提交成功";
		}
		FindReportService findReportService = new FindReportService();
		findReportService.findUpdateReport(research);
		ActionContext.getContext().put("tips", tips);
		return "findUpdateReport";
	}
	
	
	
	
	@Override
	public Research getModel() {
		return research;
	}

}
