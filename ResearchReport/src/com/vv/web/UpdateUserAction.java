package com.vv.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.vv.domain.Teacher;
import com.vv.service.FindUserService;
import com.vv.service.UpdateUserService;

public class UpdateUserAction extends ActionSupport implements ModelDriven<Teacher>{
	Teacher teacher = new Teacher();
	String tips;
	ValueStack stack = ActionContext.getContext().getValueStack();
	public String updateUser() throws Exception{
		stack.set("permisssion", teacher.getPermission());
		UpdateUserService updateUserService = new UpdateUserService();
		boolean success = updateUserService.updateUser(teacher);
		if(!success) {
			tips="�޸�ʧ��";
		}else {
			tips="�޸ĳɹ�";
		}
		ActionContext.getContext().put("tips", tips);
		return "findUser";
	}
	public String deleteUser() throws Exception{

		teacher.setPermission((String)ServletActionContext.getRequest().getSession().getAttribute("permission"));
		System.out.println("ȷ��ɾ���ı��"+teacher.getPermission());
		UpdateUserService updateUserService = new UpdateUserService();
		boolean success = updateUserService.deleteUser(teacher);
		if(!success) {
			tips = "ɾ��ʧ��"; 
		}else {
			FindUserService findUserService = new FindUserService();
			success = findUserService.findAllUser(teacher);
			tips = "ɾ���ɹ�";
		}
		ActionContext.getContext().put("tips", tips);
		return "findAllUser";
	}
	public String updatePassword() throws Exception{
		System.out.println("Username==="+teacher.getUsername());
		System.out.println("Password==="+teacher.getPassword());
		System.out.println("Newpassword==="+teacher.getNewpassword());
		stack.set("permisssion", teacher.getPermission());
		UpdateUserService updatePw = new UpdateUserService();
		boolean success = updatePw.updatePassword(teacher);
		if(!success) {
			tips = "�޸�����ʧ�ܣ��������˺Ż�����";
		}else {
			tips = "�޸�����ɹ�";
		}
		ActionContext.getContext().put("tips", tips);
		return "updatePw";
	}
	
	@Override	
public Teacher getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}

}
