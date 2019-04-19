package com.vv.service;

import com.vv.dao.ReportDao;
import com.vv.domain.Research;

public class UpdateReportService {
	//�޸Ŀ��б���
	public boolean updateReport(Research research) {
		ReportDao reportDao = new ReportDao();
		int result = reportDao.updateReport(research);
		if(result==0) {
			return false;
		}else {
			return true;
		}
	}
	//�����޸�Ȩ��
	public boolean requestPermission(Research research) {
		ReportDao reportDao = new ReportDao();
		int result = reportDao.requestPermission(research);
		if(result==0) {
			return false;
		}else {
			return true;
		}

	}
	//�ύ��˽��
	public boolean updateRequest(Research research) {
		System.out.println("����updateRequestService");
		ReportDao reportDao = new ReportDao();
		int result = reportDao.updateRequest(research);
		if(result==0) {
			return false;
		}else{
			return true;
		}
	}

}
