package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.Map;

public class UserUpdateCompleteAction extends ActionSupport implements SessionAware{

	private String loginId;
	private String loginPass;
	private String userName;
	private String admin;
	private String id;
	private Map<String,Object> session;

	public String execute() throws SQLException{
		UserDAO userDAO=new UserDAO();
		userDAO.userUpdate(
				session.get("loginId").toString(),
				session.get("loginPass").toString(),
				session.get("userName").toString(),
				session.get("admin").toString(),
				session.get("id").toString());
		String result=SUCCESS;
		return result;
	}

	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}

	public String getLoginPass(){
		return loginPass;
	}
	public void setLoginPass(String loginPass){
		this.loginPass=loginPass;
	}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
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

	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
