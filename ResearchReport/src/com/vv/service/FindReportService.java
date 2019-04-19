package com.vv.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.dao.ReportDao;
import com.vv.domain.Research;

public class FindReportService {
	Research findResearch = new Research();
	List<Research> researchList=null;
	ValueStack stack = ActionContext.getContext().getValueStack();
	//查找具体报告
	public boolean findReport(Research research) {
		ReportDao reportDao = new ReportDao();
		researchList = reportDao.findReport(research);
		System.out.println("list是否为空===="+researchList);
		if(researchList.isEmpty()) {
			return false;
		}else {
//			Map<String, Object> session = ActionContext.getContext().getSession();
//			session.put("researchList", list);
//			ValueStack stack = ActionContext.getContext().getValueStack();
			stack.set("researchList", researchList);
			return true;
		}	
	}
	//查找全部报告
	public boolean find(Research research) {
		int number = research.getNumber();
		ReportDao reportDao = new ReportDao();
		List<Research> list = reportDao.find(research);
//		Map<String, Object> session = ServletActionContext.getContext().getSession();
//		session.put("list", list);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		System.out.println("findResearch===="+list);
		return true;
	}
	//查找待审核报告
	public boolean findUpdateReport(Research research) {
		ReportDao reportDao = new ReportDao();
		researchList = reportDao.findUpdateReport(research);
		if(researchList.isEmpty()) {
			return false;
		}else {
			stack.set("researchList", researchList);
			return true;
		}	
	}

	
	
}
