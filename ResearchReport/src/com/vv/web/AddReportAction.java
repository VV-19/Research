package com.vv.web;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vv.domain.Participant;
import com.vv.domain.Research;
import com.vv.service.AddReportService;

public class AddReportAction extends ActionSupport implements ModelDriven<Research>{
	Research research = new Research();
//	Participant participant = new Participant();
	String tips;
	boolean success;
	
	private List<Participant> list;          //参与者集合
	public List<Participant> getList() {
		return list;
	}
	public void setList(List<Participant> list) {
		this.list = list;
	}
	
	public String addReport() throws Exception {
		  System.out.println("Participant0===="+list.get(0).getTea_id());
		  System.out.println("Participant1===="+list.get(1).getTea_id());
		  System.out.println("Participant2===="+list.get(2).getTea_id());
		  System.out.println("Participant3===="+list.get(3).getTea_id());
		  System.out.println("Participant4===="+list.get(4).getTea_id());
		  ActionContext.getContext().getSession().put("list", list);
		  AddReportService addReportService = new AddReportService();
		  success = addReportService.addReport(research);
		  if(!success) {
			  tips="科研报告录入失败，该项目已录入";
		  }else {
			  tips="科研报告录入成功";
		  }
		  ActionContext.getContext().put("tips", tips);
		  return "addReport";
	}

	public Research getModel() {
		// TODO Auto-generated method stub
		return research;
	}

}
