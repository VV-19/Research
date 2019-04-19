package com.vv.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vv.domain.User;
import com.vv.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	User user = new User();
	public String login() throws Exception {
		
		UserService userService = new UserService();
		boolean isSuccess = userService.findUser(user);
		if(isSuccess) {
			return "index";
		}else {
			ActionContext.getContext().put("error","用户名或密码错误" );
			return "login";
		}
	}

	@Override
	public User getModel() {
		return user;
	}
	
}
