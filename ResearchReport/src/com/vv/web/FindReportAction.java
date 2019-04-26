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
	//��ѯ���������Ϣ���޸�
	public String find() throws Exception{
		System.out.println("find()��"+research.getRes_id());
		FindReportService findReportService = new FindReportService();
		findReportService.find(research);
		return "updateReport";
	}
	//��ѯ���������Ϣ
	public String reportContent() throws Exception{
		System.out.println("find()��"+research.getRes_id());
		FindReportService findReportService = new FindReportService();
		findReportService.find(research);
		return "reportContent";
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
	//��ѯ��ʦ��ȫ������
	public String findReportById() throws Exception {
		Teacher teachers = (Teacher) ActionContext.getContext().getSession().get("user");
		System.out.println("teachers.getId()==="+teachers.getId());
		research.setTea_id(teachers.getId());
		FindReportService findReportService = new FindReportService();
		success = findReportService.findReportById(research);
		if(!success) {
			tips = "�ÿ�����Ŀ������";
		}
			ActionContext.getContext().put("tips", tips);
			return "findReportById";
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
	//��ʱ���ѯ
	public String findReportByTime() throws Exception{
		int year = research.getYear();
		String semester = research.getSemester();
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String lastYear = String.valueOf(year-1);
		//��һѧ�ڿ�ʼ����
		String first_start = lastYear+"-09-01";
		//��һѧ�ڽ������ڶ�ѧ�ڿ�ʼ����
		String first_stop = String.valueOf(year)+"-03-01";
		//�ڶ�ѧ�ڽ�������
		String second_stop = String.valueOf(year)+"-09-01";
		System.out.println("��һѧ�ڽ�ֹ����==="+first_stop);
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
			tips = "δ��ѯ��������Ҫ����Ŀ��Ϣ";
		}
		ActionContext.getContext().put("tips", tips);
		return "findReportByTime";				
	}
	//ͳ�ƿ�����Ŀ��Ϣ
	public String countReport() throws Exception{
		int year = research.getYear();
		String semester = research.getSemester();
		String lastYear = String.valueOf(year-1);
		//��һѧ�ڿ�ʼ����
		String first_start = lastYear+"-09-01";
		//��һѧ�ڽ������ڶ�ѧ�ڿ�ʼ����
		String first_stop = String.valueOf(year)+"-03-01";
		//�ڶ�ѧ�ڽ�������
		String second_stop = String.valueOf(year)+"-09-01";
		System.out.println("��һѧ�ڽ�ֹ����==="+first_stop);
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
			tips = "δ��ѯ��������Ҫ����Ŀ��Ϣ";
		}
		ActionContext.getContext().put("tips", tips);
		return "countReport";
	}
	//ͳ��ָ����ʦ������Ŀ��Ϣ
	public String countReportById() throws Exception {
		Teacher teachers = (Teacher) ActionContext.getContext().getSession().get("user");
		research.setTea_id(teachers.getId());
		int year = research.getYear();
		String semester = research.getSemester();
		String lastYear = String.valueOf(year - 1);
		// ��һѧ�ڿ�ʼ����
		String first_start = lastYear + "-09-01";
		// ��һѧ�ڽ������ڶ�ѧ�ڿ�ʼ����
		String first_stop = String.valueOf(year) + "-03-01";
		// �ڶ�ѧ�ڽ�������
		String second_stop = String.valueOf(year) + "-09-01";
		System.out.println("��һѧ�ڽ�ֹ����===" + first_stop);
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
			tips = "δ��ѯ��������Ҫ����Ŀ��Ϣ";
		}
		ActionContext.getContext().put("tips", tips);
		return "countReportById";
	}
	//����ָ����ʦ����
	public String countXlsById() throws Exception{
		System.out.println("��ʦ��research==="+research.getFile_name());
		FindReportService findReport = new FindReportService();
		success = findReport.count_xls(research);
		if(!success) {
			tips="��δ�鵽�κ���Ϣ";
		}else {
			tips=research.getFile_name()+"����������������";
		}
		ActionContext.getContext().put("tips", tips);
		return "countReportById";
	}
	//���ɱ���
	public String countXls() throws Exception{
		System.out.println("����Ա��research==="+research.getFile_name());
		FindReportService findReport = new FindReportService();
		success = findReport.count_xls(research);
		if(!success) {
			tips="��δ�鵽�κ���Ϣ";
		}else {
			tips=research.getFile_name()+"����������������";
		}
		ActionContext.getContext().put("tips", tips);
		return "countReport";
	}

	@Override
	public Research getModel() {
		return research;
	}
	
}
