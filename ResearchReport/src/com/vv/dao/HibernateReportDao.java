package com.vv.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vv.domain.Research;

public class HibernateReportDao {

	public void addReport(Research research) {
		System.out.println("ReportDao======"+1);
		//启动hibernate
		//得到配置信息
		Configuration config = new Configuration().configure();
		//创建sessionFactory对象
		System.out.println("ReportDao======"+3);
		SessionFactory sessionFactory = config.buildSessionFactory();
		//获取session
		System.out.println("ReportDao======"+4);
		Session session = sessionFactory.openSession();
		//打开事务
		System.out.println("ReportDao======"+5);
		Transaction transaction = session.beginTransaction();
		//存储research对象
		System.out.println("ReportDao======"+6);
		session.save(research);
		//提交事务
		System.out.println("ReportDao======"+7);
		transaction.commit();
		//关闭资源
		System.out.println("ReportDao======"+8);
		session.close();
	}

}
