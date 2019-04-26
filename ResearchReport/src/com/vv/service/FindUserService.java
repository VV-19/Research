package com.vv.service;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.dao.UserDao;
import com.vv.domain.Teacher;

public class FindUserService {
	//查询用户信息
	public boolean findMessage(Teacher teacher) {
		System.out.println("Service中的===="+teacher.getId());
		UserDao userDao = new UserDao();
		Teacher tm = userDao.findUserMessage(teacher);
		ActionContext.getContext().getValueStack().push(tm);
		if(tm==null) {
			return false;
		}else {
			return true;
		}
		
	}
	//全部用户信息列表
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
	//按ID查询
	public boolean findUserById(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
