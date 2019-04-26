package com.vv.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.dao.ReportDao;
import com.vv.domain.Research;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FindReportService {
	Research findResearch = new Research();
	List<Research> researchList=null;
	ValueStack stack = ActionContext.getContext().getValueStack();
	Map<String, Object> session = ActionContext.getContext().getSession();
	//���Ҿ��屨��
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
	//����ȫ������
	public boolean findReport(Research research) {
		ReportDao reportDao = new ReportDao();
		researchList = reportDao.findReport(research);
		System.out.println("list�Ƿ�Ϊ��===="+researchList);
		if(researchList.isEmpty()) {
			return false;
		}else {
			stack.set("researchList", researchList);
			return true;
		}	
	}
	//��ѯָ����ʦȫ����Ŀ
	public boolean findReportById(Research research) {
		ReportDao reportDao = new ReportDao();
		researchList = reportDao.findReportById(research);
		System.out.println("list�Ƿ�Ϊ��===="+researchList);
		if(researchList.isEmpty()) {
			System.out.println("listΪ��===="+researchList);
			return false;
		}else {
			stack.set("researchList", researchList);
			return true;
		}	
	}
	//���Ҵ���˱���
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
	//�����ڼ������߲�ѯ
	public boolean findReportByTime(Research research) {
		ReportDao reportDao = new ReportDao();
		researchList = reportDao.findReportByTime(research);
		System.out.println("researchList==="+researchList);
		if(researchList.isEmpty()) {
			System.out.println("researchList(false)==="+researchList);
			return false;
		}else {
			System.out.println("researchList(true)==="+researchList);
			session.put("researchList", researchList);
			stack.set("researchList", researchList);
			return true;
		}
		
	}
	//���ɱ���
	@SuppressWarnings("unchecked")
	public boolean count_xls(Research research) throws IOException {
		researchList = (List<Research>) session.get("researchList");
		System.out.println("researchList==="+researchList);
		System.out.println("researchList.isEmpty()==="+researchList==null);
		if(researchList==null) {
			return false;
		}
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com= fsv.getHomeDirectory();    //����Ƕ�ȡ����·���ķ�����
		
		String fileName = research.getFile_name();
		String path = com.getPath()+"\\"+fileName+".xls"; 

		WritableWorkbook wwb = Workbook.createWorkbook(new File(path));
		WritableSheet ws = wwb.createSheet(fileName, 1);
		//д���ͷ
		try {
			ws.addCell(new Label(0,0,"��ʦ����"));
			ws.addCell(new Label(1,0,"��ʦ����"));
			ws.addCell(new Label(2,0,"��Ŀ���"));
			ws.addCell(new Label(3,0,"��Ŀ����"));
			ws.addCell(new Label(4,0,"��Ŀ����"));
			ws.addCell(new Label(5,0,"��Ŀ����")); 
			ws.addCell(new Label(6,0,"���λ"));
			ws.addCell(new Label(7,0,"����ʱ��"));
			ws.addCell(new Label(8,0,"����ʱ��"));
		} catch (WriteException e) {
			e.printStackTrace();
			return false;
		}
		 
		for(int i=0;i<researchList.size();i++) {
			try {
				ws.addCell(new Label(0,i+1,researchList.get(i).getTea_id()+""));
				ws.addCell(new Label(1,i+1,researchList.get(i).getPart_user()));
				ws.addCell(new Label(2,i+1,researchList.get(i).getRes_id()+""));
				ws.addCell(new Label(3,i+1,researchList.get(i).getRes_name()));
				ws.addCell(new Label(4,i+1,researchList.get(i).getRes_type()));
				ws.addCell(new Label(5,i+1,researchList.get(i).getRes_fund()+""));
				ws.addCell(new Label(6,i+1,researchList.get(i).getUnit()+""));
				ws.addCell(new Label(7,i+1,researchList.get(i).getStart_time()+""));
				ws.addCell(new Label(8,i+1,researchList.get(i).getEnd_time()+""));
			} catch (WriteException e) {
				e.printStackTrace();
				return false;
			}
		}
		try {
			wwb.write();
			wwb.close();
		} catch (WriteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//ͳ��ָ����ʦ������Ŀ
	public boolean countReportById(Research research) {
		ReportDao reportDao = new ReportDao();
		researchList = reportDao.countReportById(research);
		System.out.println("researchList==="+researchList);
		if(researchList.isEmpty()) {
			System.out.println("researchList(false)==="+researchList);
			return false;
		}else {
			System.out.println("researchList(true)==="+researchList);
			session.put("researchList", researchList);
			stack.set("researchList", researchList);
			return true;
		}
		
	}


}
