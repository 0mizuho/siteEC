package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String message;

	public String execute() throws SQLException{
		String result=SUCCESS;
		LoginDAO loginDAO=new LoginDAO();
		int res=loginDAO.resetPass(session.get("loginPass").toString(),session.get("loginId").toString());
		if(res>0){
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res==0){
			setMessage("ユーザー情報の削除に失敗しました。");
		}
		return result;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}

	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
}