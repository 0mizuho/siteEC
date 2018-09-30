package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.UserDAO;
import com.internousdev.ecsite.dto.UserDTO;

public class UserListAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<UserDTO> userList=new ArrayList<UserDTO>();
	/*userListをそのまま持ってくる。*/
	public String execute() throws SQLException{
		UserDAO userDAO=new UserDAO();
		userList=userDAO.getUserInfo();
		String result=SUCCESS;
		return result;
	}


	@Override
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}
	public Map<String,Object> getSession() {
	    return session;
	}

	public ArrayList<UserDTO> getUserList() {
	    return userList;
	}
	public void setUserList(ArrayList<UserDTO> userList) {
	    this.userList = userList;
	}



}
