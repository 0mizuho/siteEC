package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.Map;

public class ItemUpdateConfirmAction extends ActionSupport implements SessionAware{

	public  Map<String,Object> session;
	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String message;

	public String execute() throws SQLException{
		String result=SUCCESS;
		if(!(itemName.equals("")) && !(itemPrice.equals("")) && !(itemStock.equals(""))){
			session.put("itemName",itemName);
			session.put("itemPrice",itemPrice);
			session.put("itemStock",itemStock);
		}else{
			setMessage("未入力項目あり。");
			result=ERROR;
		}
		return result;
	}


	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}

	public String getId() {
	    return id;
	}
	public void setId(String id) {
	    this.id = id;
	}

	public String getItemName() {
	    return itemName;
	}
	public void setItemName(String itemName) {
	    this.itemName = itemName;
	}

	public String getItemPrice() {
	    return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
	    this.itemPrice = itemPrice;
	}

	public String getItemStock() {
	    return itemStock;
	}
	public void setItemStock(String itemStock) {
	    this.itemStock = itemStock;
	}

	public String getMessage() {
	    return message;
	}
	public void setMessage(String message) {
	    this.message = message;
	}

}
