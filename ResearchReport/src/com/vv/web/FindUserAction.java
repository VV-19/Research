package com.vv.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.domain.Teacher;
import com.vv.service.FindUserService;

public class FindUserAction extends ActionSupport implements ModelDriven<Teacher>{
	Teacher teacher = new Teacher();
	String tips;
	boolean success;
	//查询用户信息
	public String findMessage() throws Exception{
		System.out.println("表单提交的====="+teacher.getId());
		ActionContext.getContext().getSession().put("permission", teacher.getPermission());
		FindUserService findUserService = new FindUserService();
		success = findUserService.findMessage(teacher);
		if(!success) {
			tips = "没有查询到工号或姓名为"+teacher.getId()+"的用户";
			ActionContext.getContext().put("tips", tips);
		}
		System.out.println("返回findUser.jsp");
		return "findUser";
	}
	//全部用户信息列表
	public String findAllUser() throws Exception{
		ActionContext.getContext().getSession().put("permission", teacher.getPermission());
		teacher.setPermission((String)ServletActionContext.getRequest().getSession().getAttribute("permission"));
		System.out.println("权限是===="+teacher.getPermission());
		FindUserService findUserService = new FindUserService();
		success = findUserService.findAllUser(teacher);
		return "findAllUser";
	}
	//按ID查询
	public String findUserById() throws Exception{
		Teacher user = (Teacher) ActionContext.getContext().getSession().get("user");
		System.out.println("findUserById==="+user.getPermission());
		System.out.println("findUserById==="+user.getUsername());
		teacher.setPermission(user.getPermission());
		teacher.setId(user.getId());
		FindUserService findUserService = new FindUserService();
		success = findUserService.findMessage(teacher);
		return "findUserById";
	}
	//按ID先查再改
	public String updateUserById() throws Exception{
		Teacher user = (Teacher) ActionContext.getContext().getSession().get("user");
		System.out.println("findUserById==="+user.getPermission());
		System.out.println("findUserById==="+user.getUsername());
		teacher.setPermission(user.getPermission());
		teacher.setId(user.getId());
		FindUserService findUserService = new FindUserService();
		success = findUserService.findMessage(teacher);
		return "updateUserById";
	}
	
	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}

}
