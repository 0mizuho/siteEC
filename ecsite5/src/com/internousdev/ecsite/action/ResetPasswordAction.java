package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String userName;
	public Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();

	public String execute(){
		String result=ERROR;
		/*ログインに必要な情報をDAOから持ってくる*/
		loginDTO=loginDAO.getUserInfo(userName,loginUserId);
		session.put("loginUser",loginDTO);
		/*loginUserが入っていたら…*/
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;
			return result;
		}
		return result;

	}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}


	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
