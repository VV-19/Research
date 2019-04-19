package com.vv.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vv.domain.Research;

public class HibernateReportDao {

	public void addReport(Research research) {
		System.out.println("ReportDao======"+1);
		//����hibernate
		//�õ�������Ϣ
		Configuration config = new Configuration().configure();
		//����sessionFactory����
		System.out.println("ReportDao======"+3);
		SessionFactory sessionFactory = config.buildSessionFactory();
		//��ȡsession
		System.out.println("ReportDao======"+4);
		Session session = sessionFactory.openSession();
		//������
		System.out.println("ReportDao======"+5);
		Transaction transaction = session.beginTransaction();
		//�洢research����
		System.out.println("ReportDao======"+6);
		session.save(research);
		//�ύ����
		System.out.println("ReportDao======"+7);
		transaction.commit();
		//�ر���Դ
		System.out.println("ReportDao======"+8);
		session.close();
	}

}
