package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.Map;

public class UserUpdateConfirmAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private String loginId;
	private String loginPass;
	private String userName;
	private String admin;
	private String id;
	private String message;

	public String execute() throws SQLException{
		String result = SUCCESS;
		if(!(userName.equals("")) &&!(loginId.equals("")) && !(loginPass.equals("")) &&!(admin.equals(""))){
			session.put("userName",userName);
			session.put("loginId",loginId);
			session.put("loginPass",loginPass);
			session.put("admin",admin);
		}else{
			setMessage("未入力項目あり。");
			result=ERROR;
		}
		return result;
	}

	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}

	public String getLoginId() {
	    return loginId;
	}
	public void setLoginId(String loginId) {
	    this.loginId = loginId;
	}

	public String getLoginPass() {
	    return loginPass;
	}
	public void setLoginPass(String loginPass) {
	    this.loginPass = loginPass;
	}

	public String getUserName() {
	    return userName;
	}
	public void setUserName(String userName) {
	    this.userName = userName;
	}

	public String getAdmin(){
		return admin;
	}
	public void setAdmin(String admin){
		this.admin=admin;
	}

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}

	public String getMessage() {
	    return message;
	}
	public void setMessage(String message) {
	    this.message = message;
	}



}
