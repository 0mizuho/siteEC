package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.ItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class ItemDetailAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();
	public String id;

	public String execute() throws SQLException{

		String result=ERROR;
		ItemDAO itemDAO=new ItemDAO();
		ItemDTO itemDTO=new ItemDTO();
		itemDTO=itemDAO.getItemDetailInfo(id);

		if(!(itemDTO==null)){
			session.put("id",itemDTO.getId());
			session.put("itemName",itemDTO.getItemName());
			session.put("itemPrice",itemDTO.getItemPrice());
			session.put("itemStock",itemDTO.getItemStock());
			session.put("insertDate",itemDTO.getInsertDate());
			session.put("updateDate",itemDTO.getUpdateDate());
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

	public String getId() {
	    return id;
	}
	public void setId(String id) {
	    this.id = id;
	}

	public ArrayList<ItemDTO> getItemList(){
		return this.itemList;
	}

}
