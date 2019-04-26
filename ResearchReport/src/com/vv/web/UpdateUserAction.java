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
	//修改用户信息
	public String updateUser() throws Exception{
		String permission = (String)ActionContext.getContext().getSession().get("permission");
		System.out.println("action中的权限1"+teacher.getPermission());
		teacher.setPermission(permission);
		UpdateUserService updateUserService = new UpdateUserService();
		boolean success = updateUserService.updateUser(teacher);
		if(!success) {
			tips="修改失败";
		}else {
			tips="修改成功";
		}
		ActionContext.getContext().put("tips", tips);
		return "findUser";
	}
	//教师修改信息
	public String updateTeacher() throws Exception{

		teacher.setPermission("teacher");
		UpdateUserService updateUserService = new UpdateUserService();
		boolean success = updateUserService.updateUser(teacher);
		if(!success) {
			tips="修改失败";
		}else {
			tips="修改成功";
		}
		ActionContext.getContext().put("tips", tips);
		return "findUserById";
	}
	
	//删除用户信息
	public String deleteUser() throws Exception{

		teacher.setPermission((String)ServletActionContext.getRequest().getSession().getAttribute("permission"));
		System.out.println("确定删除的表格"+teacher.getPermission());
		UpdateUserService updateUserService = new UpdateUserService();
		boolean success = updateUserService.deleteUser(teacher);
		if(!success) {
			tips = "删除失败"; 
		}else {
			FindUserService findUserService = new FindUserService();
			success = findUserService.findAllUser(teacher);
			tips = "删除成功";
		}
		ActionContext.getContext().put("tips", tips);
		return "findAllUser";
	}
	//修改用户密码
	public String updatePassword() throws Exception{

		stack.set("permisssion", teacher.getPermission());
		UpdateUserService updatePw = new UpdateUserService();
		boolean success = updatePw.updatePassword(teacher);
		if(!success) {
			tips = "修改密码失败，检查你的账号或密码";
		}else {
			tips = "修改密码成功";
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
