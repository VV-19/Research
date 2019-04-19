package com.vv.service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.dao.UserDao;
import com.vv.domain.Teacher;

public class UpdateUserService {
	

	public boolean updateUser(Teacher teacher) {
		UserDao userDao = new UserDao();
		int result = userDao.updateUser(teacher);
		if(result==0) {
			return false;
		}else {
			return true;
		}
	}

	public boolean deleteUser(Teacher teacher) {
		UserDao userDao = new UserDao();
		int result = userDao.deleteUser(teacher);
		if(result==0) {
			return false;
		}else {
			return true;
		}
	}

	public boolean updatePassword(Teacher teacher) {
		UserDao userDao = new UserDao();
		int result = userDao.updatePw(teacher);
		System.out.println("·µ»Ø½á¹û==="+result);
		if(result==0) {
			return false;
		}else {
			return true;
		}
	}

}
