package com.vv.web;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vv.domain.Participant;
import com.vv.domain.Research;
import com.vv.service.AddReportService;

public class AddReportAction extends ActionSupport implements ModelDriven<Research>{

	String tips;
	boolean success;
	Research research = new Research();
	private List<Participant> list;          //�����߼���
	public List<Participant> getList() {
		return list;
	}
	public void setList(List<Participant> list) {
		this.list = list;
	}

	public String addReport() throws Exception {

		  ActionContext.getContext().getSession().put("list", list);
		  AddReportService addReportService = new AddReportService();
		  success = addReportService.addReport(research);
		  if(!success) {
			  tips="����Ŀ����Ѵ��ڣ����б���¼��ʧ��";
		  }else {
			  tips="���б���¼��ɹ�";
		  }
		  ActionContext.getContext().put("tips", tips);
		  return "addReport";
	}

	public Research getModel() {
		// TODO Auto-generated method stub
		return research;
	}

}
