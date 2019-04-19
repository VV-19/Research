package com.vv.service;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.dao.UserDao;
import com.vv.domain.Teacher;

public class FindUserService {

	public boolean findMessage(Teacher teacher) {
		System.out.println("ServiceÖÐµÄ===="+teacher.getId());
		UserDao userDao = new UserDao();
		Teacher tm = userDao.findUserMessage(teacher);

		ActionContext.getContext().getValueStack().push(tm);
		if(tm==null) {
			return false;
		}else {
			return true;
		}
		
	}

	public boolean findAllUser(Teacher teacher) {
		UserDao userDao = new UserDao();
		List<Teacher> userList = userDao.findAllUser(teacher);
		System.out.println("userList===="+userList);
		if(userList.isEmpty()) {
			return false;
		}else {
			ValueStack stack = ActionContext.getContext().getValueStack();
			stack.set("userList", userList);
			return true;
		}
	}
	
}
