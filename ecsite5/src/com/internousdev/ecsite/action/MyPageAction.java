package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.dto.UserDTO;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private MyPageDAO myPageDAO=new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("id")){
			return ERROR;
		}

		/*履歴の削除がされているかの確認*/
		/*もしdeleFlgがnullだったらmyPageListにDBから取得した情報を収納*/
		if(deleteFlg==null){
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
			myPageList=myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
		}else if(deleteFlg.equals("1"))/*そうでなければdeleteメソッド実行*/{
			delete();
		}

		String result=SUCCESS;
		return result;
	}

	/*商品購入履歴の削除メソッド(delete)*/
	public void delete() throws SQLException{
		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();
		/*resにbuyItemHistoryDeleteの履歴件数を格納*/
		int res=myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);
		/*格納された件数によって処理のメッセージを分ける*/
		if(res>0){
			myPageList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	/*ユーザー情報詳細*/
	public void detail() throws SQLException{
/*		String result = ERROR;*/
		UserDTO userDTO=new UserDTO();
		userDTO=myPageDAO.myPageDetail(session.get("loginId").toString());
		if(userDTO!=null){
			session.put("userName",userDTO.getUserName());
			session.put("loginId",userDTO.getLoginId());
			session.put("loginPass",userDTO.getLoginPass());
/*			String resule=SUCCESS;*/
		}
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}

	public ArrayList<MyPageDTO> getMyPageList(){
		return myPageList;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}


}
