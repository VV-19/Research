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
	//��ѯ���������Ϣ
	public String find() throws Exception{
		System.out.println("find()��"+research.getRes_id());
		FindReportService findReportService = new FindReportService();
		findReportService.find(research);
		return "updateReport";
	}
	//��ѯȫ������
	public String findReport() throws Exception {
		FindReportService findReportService = new FindReportService();
		success = findReportService.findReport(research);
		if(!success) {
			tips = "�ÿ�����Ŀ������";
		}
			ActionContext.getContext().put("tips", tips);
			return "findReport";
	}
	//��ѯ����˱���
	public String findUpdateReport() throws Exception{
		FindReportService findReportService = new FindReportService();
		success = findReportService.findUpdateReport(research);
		if(!success) {
			tips="û�д���˵Ŀ��б���";
		}
		return "findUpdateReport";
	}
	
	
	@Override
	public Research getModel() {
		return research;
	}
	
}
