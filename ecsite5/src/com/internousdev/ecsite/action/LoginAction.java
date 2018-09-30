package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

	public String execute(){
		String result=ERROR;
		/*ログインに必要な情報をDAOから持ってくる*/
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);
		/*loginUserが入っていたら…*/
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			/*かつadminが0であれば次の画面に必要な商品情報を取得(通常画面)*/
			if(((LoginDTO) session.get("loginUser")).getAdmin().equals("0")){
			result=SUCCESS;
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
			return result;

			/*loginUserが入ってはいてadminが1であれば別に誘導する(管理者画面)*/
			}else if(((LoginDTO) session.get("loginUser")).getAdmin().equals("1")){
			result="admin";
			return result;
			}
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
