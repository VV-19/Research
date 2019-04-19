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
	public String findMessage() throws Exception{
		System.out.println("���ύ��====="+teacher.getId());
		ActionContext.getContext().getSession().put("permission", teacher.getPermission());
		FindUserService findUserService = new FindUserService();
		success = findUserService.findMessage(teacher);
		if(!success) {
			tips = "û�в�ѯ�����Ż�����Ϊ"+teacher.getId()+"���û�";
			ActionContext.getContext().put("tips", tips);
		}
		System.out.println("����findUser.jsp");
		return "findUser";
	}
	public String findAllUser() throws Exception{
		ActionContext.getContext().getSession().put("permission", teacher.getPermission());
		teacher.setPermission((String)ServletActionContext.getRequest().getSession().getAttribute("permission"));
		System.out.println("Ȩ����===="+teacher.getPermission());
		FindUserService findUserService = new FindUserService();
		success = findUserService.findAllUser(teacher);
		return "findAllUser";
	}
	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}

}
