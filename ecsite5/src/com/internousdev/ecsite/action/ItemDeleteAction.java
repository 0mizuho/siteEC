package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.ItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;

public class ItemDeleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();
	private String deleteFlg;
	private String message;
	private String id;

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

	/*商品の削除*/
	public void delete() throws SQLException{
		ItemDAO itemDAO=new ItemDAO();
		int res=itemDAO.itemDelete(session.get("id").toString());
		if(res>0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}


	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}

	public ArrayList<ItemDTO> getItemList() {
	    return itemList;
	}
	public void setItemList(ArrayList<ItemDTO> itemList) {
	    this.itemList = itemList;
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

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}



}
