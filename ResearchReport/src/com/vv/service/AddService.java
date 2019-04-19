package com.vv.service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.dao.UserDao;
import com.vv.domain.Teacher;

public class AddService {

	public boolean addUser(Teacher teacher) {
		UserDao userDao = new UserDao();
		int success = userDao.addUser(teacher);
		ValueStack stack=ActionContext.getContext().getValueStack();
		stack.set("teacher", teacher);
		if(success==1) {
			return true;
		}
			return false;
	}
}
