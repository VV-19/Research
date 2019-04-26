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
	//�޸��û���Ϣ
	public String updateUser() throws Exception{
		String permission = (String)ActionContext.getContext().getSession().get("permission");
		System.out.println("action�е�Ȩ��1"+teacher.getPermission());
		teacher.setPermission(permission);
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
	//��ʦ�޸���Ϣ
	public String updateTeacher() throws Exception{

		teacher.setPermission("teacher");
		UpdateUserService updateUserService = new UpdateUserService();
		boolean success = updateUserService.updateUser(teacher);
		if(!success) {
			tips="�޸�ʧ��";
		}else {
			tips="�޸ĳɹ�";
		}
		ActionContext.getContext().put("tips", tips);
		return "findUserById";
	}
	
	//ɾ���û���Ϣ
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
	//�޸��û�����
	public String updatePassword() throws Exception{

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
