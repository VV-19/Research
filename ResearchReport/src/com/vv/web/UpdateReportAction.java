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
	//�޸ı���
	public String updateReport() throws Exception {
		System.out.println("�ѵ����޸ı���Action");
		System.out.println("rese_id==="+research.getRes_id());
		System.out.println("report_status==="+research.getRes_status());
		System.out.println("report_content==="+research.getRes_content());

		if("���ύ".equals(research.getRes_status())) {
			System.out.println("�޸�ʧ��");
			tips = "�޸�ʧ�ܣ����������޸�Ȩ��";
		}else if("���޸�".equals(research.getRes_status())){
			System.out.println("���޸�");
			UpdateReportService update = new UpdateReportService();
			success = update.updateReport(research);
			if(success) {
				tips="�޸ĳɹ�";
			}	
		}
		FindReportService findReportService = new FindReportService();
		findReportService.find(research);
		ActionContext.getContext().put("tips",tips);
		return "updateReport";
	}
	
	//����Ȩ��
	public String requestPermission() throws Exception {
		System.out.println("research.getRes_status()==="+research.getRes_status());
		if(research.getRes_status().equals("���޸�")) {
			tips="�ñ����ѻ��Ȩ�ޣ����޸�";
		}else {
			UpdateReportService update = new UpdateReportService();
			success = update.requestPermission(research);
			tips="�޸ı���Ȩ������ɹ����ȴ�����Ա���ͨ������޸�";
		}	
		ActionContext.getContext().put("tips", tips);
		return "findReport";
	}
	
	//�ύ��˽��
	public String updateRequest() throws Exception{
		System.out.println("resul==="+research.getResult());
		UpdateReportService update = new UpdateReportService();
		success = update.updateRequest(research);
		if(success) {
			tips = "��˽���ύ�ɹ�";
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
