package com.vv.web.intercept;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.vv.domain.Teacher;

public class UserIntercept extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж�Session�����Ƿ���User����
		//��ȡSession
		Map<String, Object> session = ActionContext.getContext().getSession();
		Teacher user = (Teacher) session.get("user");
		if(user==null) {
			return "login";
		}else {
			return invocation.invoke();
		}
	}

}
