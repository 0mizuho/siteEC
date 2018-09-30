package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.ItemDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.Map;

public class ItemUpdateCompleteAction extends ActionSupport implements SessionAware{

	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private Map<String,Object> session;

	public String execute() throws SQLException{
		ItemDAO itemDAO=new ItemDAO();
		itemDAO.itemUpdate(
				session.get("itemName").toString(),
				session.get("itemPrice").toString(),
				session.get("itemStock").toString(),
				session.get("id").toString());
		String result=SUCCESS;
		return result;
	}

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}

	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}

	public String getItemStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock=itemStock;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}


}
