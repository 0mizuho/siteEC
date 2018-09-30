package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.ItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;

public class ItemAllDeleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ItemDAO itemDAO=new ItemDAO();
	private ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();
	private String deleteFlg;
	private String message;

	/*一覧の削除がされているかの確認*/
	public String execute() throws SQLException{
		if(deleteFlg==null){
			itemList=itemDAO.getItemInfo();
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	/*商品一覧の全削除*/
	public void delete() throws SQLException{
		int res=itemDAO.itemAllDelete();
		if(res>0){
			itemList=null;
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

	public ItemDAO getItemDAO() {
	    return itemDAO;
	}
	public void setItemDAO(ItemDAO itemDAO) {
	    this.itemDAO = itemDAO;
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



}
