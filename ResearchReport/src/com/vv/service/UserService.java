package com.vv.service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.dao.UserDao;
import com.vv.domain.User;

public class UserService {
	public boolean findUser(User user) {
		System.out.println("userservice");
		UserDao userDao = new UserDao();
		User temp = userDao.findUser(user);
		ValueStack stack = ActionContext.getContext().getValueStack();
		stack.set("temp", temp);
		return temp == null?false:true;
	}
}
