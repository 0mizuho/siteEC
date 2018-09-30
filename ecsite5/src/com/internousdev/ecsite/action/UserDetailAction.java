package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.UserDAO;
import com.internousdev.ecsite.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class UserDetailAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<UserDTO> userList=new ArrayList<UserDTO>();
	public String id;

	public String execute() throws SQLException{

		String result=ERROR;
		UserDAO userDAO=new UserDAO();
		UserDTO userDTO=new UserDTO();
		userDTO=userDAO.getUserDetailInfo(id);

		if(!(userDTO==null)){
			session.put("id",userDTO.getId());
			session.put("loginId",userDTO.getLoginId());
			session.put("loginPass",userDTO.getLoginPass());
			session.put("userName",userDTO.getUserName());
			session.put("admin",userDTO.getAdmin());
			session.put("insertDate",userDTO.getInsertDate());
			session.put("updatedDate",userDTO.getUpdatedDate());
			result=SUCCESS;
		}
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

	public String getId() {
	    return id;
	}
	public void setId(String id) {
	    this.id = id;
	}



}
