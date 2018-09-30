package com.internousdev.ecsite.dto;

public class UserDTO {

	public String id;
	public String loginId;
	public String loginUserId;
	public String loginPass;
	public String userName;
	public String insertDate;
	public String updatedDate;
	public String admin;


	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}

	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
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

	public String getInsertDate(){
		return insertDate;
	}
	public void setInsertDate(String insertDate){
		this.insertDate=insertDate;
	}

	public String getUpdatedDate(){
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate){
		this.updatedDate=updatedDate;
	}

	public String getAdmin(){
		return admin;
	}
	public void setAdmin(String admin){
		this.admin=admin;
	}
}
