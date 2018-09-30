package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.UserDAO;
import com.internousdev.ecsite.dto.UserDTO;

public class UserAllDeleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private UserDAO userDAO=new UserDAO();
	private ArrayList<UserDTO> userList=new ArrayList<UserDTO>();
	private String deleteFlg;
	private String message;

	/*一覧の削除がされているかの確認*/
	public String execute() throws SQLException{
		if(deleteFlg==null){
			userList=userDAO.getUserInfo();
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	/*ユーザー情報一覧の全削除*/
	public void delete() throws SQLException{
		int res=userDAO.userAllDelete();
		if(res>0){
			userList=null;
			setMessage("管理者以外のユーザー情報を正しく削除しました。");
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

	public UserDAO getUserDAO() {
	    return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
	    this.userDAO = userDAO;
	}

	public ArrayList<UserDTO> getUserList() {
	    return userList;
	}
	public void setUserList(ArrayList<UserDTO> userList) {
	    this.userList = userList;
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
