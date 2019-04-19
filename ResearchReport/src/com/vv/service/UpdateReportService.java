package com.vv.service;

import com.vv.dao.ReportDao;
import com.vv.domain.Research;

public class UpdateReportService {
	//修改科研报告
	public boolean updateReport(Research research) {
		ReportDao reportDao = new ReportDao();
		int result = reportDao.updateReport(research);
		if(result==0) {
			return false;
		}else {
			return true;
		}
	}
	//申请修改权限
	public boolean requestPermission(Research research) {
		ReportDao reportDao = new ReportDao();
		int result = reportDao.requestPermission(research);
		if(result==0) {
			return false;
		}else {
			return true;
		}

	}
	//提交审核结果
	public boolean updateRequest(Research research) {
		System.out.println("到达updateRequestService");
		ReportDao reportDao = new ReportDao();
		int result = reportDao.updateRequest(research);
		if(result==0) {
			return false;
		}else{
			return true;
		}
	}

}
