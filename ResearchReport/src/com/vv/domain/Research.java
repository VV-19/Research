package com.vv.domain;

import java.util.Date;
import java.util.List;

public class Research {
	
	private String res_id;
	private String res_name;
	private String res_type;
	private String res_host;	//���
	private String res_content;
	private double res_fund;	//����
	private Date start_time;	//����ʱ��
	private Date end_time;		//����ʱ��
	private Date report_time;	//�ύʱ��
	private String res_status;	//����״̬
	private String upd_status;	//�޸�Ȩ��
	private int number;			//���б������
	
	private String tea_id;		//�����߹���
	private String part_user;	//������
	private String education;	//ѧ��
	private String rating;		//ְ��
	private String unit;		//��λ
	private String effect;		//����
	private String result;      //��˽��
	
	private int year;			//ѧ��
	private String semester;	//ѧ�ں�
	private String start_Date;	//ѧ�꿪ʼ
	private String stop_Date;	//ѧ�����
	private String file_name;	//xsl�ļ���

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	//�����ڲ�ѯ������
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}

	public String getStop_Date() {
		return stop_Date;
	}

	public void setStop_Date(String stop_Date) {
		this.stop_Date = stop_Date;
	}
	
	//���б�������
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_type() {
		return res_type;
	}
	public void setRes_type(String res_type) {
		this.res_type = res_type;
	}
	public String getRes_host() {
		return res_host;
	}
	public void setRes_host(String res_host) {
		this.res_host = res_host;
	}
	public String getRes_content() {
		return res_content;
	}
	public void setRes_content(String res_content) {
		this.res_content = res_content;
	}
	public double getRes_fund() {
		return res_fund;
	}
	public void setRes_fund(double res_fund) {
		this.res_fund = res_fund;
	}
	//����ʱ��
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getReport_time() {
		return report_time;
	}
	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}
	//����״̬
	public String getRes_status() {
		return res_status;
	}
	public void setRes_status(String res_status) {
		this.res_status = res_status;
	}
	public String getUpd_status() {
		return upd_status;
	}
	public void setUpd_status(String upd_status) {
		this.upd_status = upd_status;
	}
	
	//��������Ϣ
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getPart_user() {
		return part_user;
	}
	public void setPart_user(String part_user) {
		this.part_user = part_user;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	
}
