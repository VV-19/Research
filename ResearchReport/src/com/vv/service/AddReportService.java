package com.vv.service;

import com.vv.dao.HibernateReportDao;
import com.vv.dao.ReportDao;
import com.vv.domain.Research;

public class AddReportService {

	public boolean addReport(Research research) {
		ReportDao reportDao = new ReportDao();
		
		int success = reportDao.addReoprt(research); 
		if(success==0) {
			return false;
		}
		return true;
	}

//	public void addReport(Research research) {
//		 System.out.println("service======"+1);
//		HibernateReportDao reportDao = new HibernateReportDao();
//		System.out.println("service======"+2);
//		reportDao.addReport(research);
//		System.out.println("service======"+3);
//		Research res = reportDao.addReport(research);
//		if(res!=null) {
//			return true;
//		}else {
//			return false;
//		}
//	}

}
