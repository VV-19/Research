package com.vv.service;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.dao.UserDao;
import com.vv.domain.Teacher;

public class UserService {
	public boolean findUser(Teacher teacher) {
		System.out.println("userservice");
		UserDao userDao = new UserDao();
		Teacher teachers = userDao.findUser(teacher);
		if(teachers == null) {
			System.out.println("µÇÂ½¼´½«Ê§°Ü");
			return false;
		}else {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("user", teachers);
			return true;
		}
		
	}
}
