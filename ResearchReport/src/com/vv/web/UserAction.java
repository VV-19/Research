package com.vv.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vv.domain.Teacher;
import com.vv.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<Teacher>{
	
	Teacher teacher = new Teacher();
	public String login() throws Exception {
		
		UserService userService = new UserService();
		boolean isSuccess = userService.findUser(teacher);
		System.out.println("teacher.getPermission()==="+teacher.getPermission());
		if(isSuccess) {
			if(teacher.getPermission().equals("admins")) {
				return "adm_index";
			}else {
				return "tea_index";
			}
		}else {
			ActionContext.getContext().put("error","用户名或密码错误" );
			return "login";
		}
	}

	@Override
	public Teacher getModel() {
		return teacher;
	}
	
}
