package com.vv.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vv.domain.Teacher;
import com.vv.service.AddService;

public class AddUserAction extends ActionSupport implements ModelDriven<Teacher>{
	Teacher teacher = new Teacher();
	String tips;
	public String addUser() throws Exception {
		AddService addService = new AddService();
		boolean isSuccess = addService.addUser(teacher);
		if(isSuccess) {
			tips = "用户添加成功";
		}else {
			tips = "用户添加失败，该工号已注册";
		}
		ActionContext.getContext().put("tips", tips);
		return "addUser";
	}

	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}
	
}
