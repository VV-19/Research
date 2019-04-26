package com.vv.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vv.domain.Teacher;

public class LogOutAction extends ActionSupport{

	//注销session中的用户信息
	public String logOut() throws Exception {
		Teacher teacher = (Teacher) ActionContext.getContext().getSession().get("user");
		System.out.println("teacher.id==="+teacher.getId());
		ActionContext.getContext().getSession().remove("user");
		return "login";
	}

}
