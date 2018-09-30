package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.Map;

public class UserDeleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private String id;
	private String deleteFlg;
	private String message;

	/*削除がされているかの確認*/
	public String execute() throws SQLException{
		if(deleteFlg==null){
			session.put("id",id);
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	/*ユーザー情報の削除*/
	public void delete() throws SQLException{
		UserDAO userDAO=new UserDAO();
		int res=userDAO.userDelete(session.get("id").toString());
		if(res>0){
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res==0){
			setMessage("ユーザー情報の削除に失敗しました。");
		}
	}

	@Override
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}
	public Map<String,Object> getSession() {
	    return session;
	}

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}

	public String getDeleteFlg() {
	    return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
	    this.deleteFlg = deleteFlg;
	}

	public String getMessage() {
	    return message;
	}
	public void setMessage(String message) {
	    this.message = message;
	}

}
