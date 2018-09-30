package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.ItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;

public class ItemListAction extends ActionSupport implements SessionAware{

		public Map<String,Object> session;
		private ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();

		public String execute() throws SQLException{
			ItemDAO itemDAO=new ItemDAO();
			itemList=itemDAO.getItemInfo();
			/*Listだけを返す*/
			/*エラー時のコメントはitemList.jspに直記入済み*/
				String result=SUCCESS;
				return result;
			}


		@Override
		public void setSession(Map<String,Object> session) {
		    this.session = session;
		}
		public Map<String,Object> getSession() {
			    return session;
			}

		public ArrayList<ItemDTO> getItemList() {
		    return itemList;
		}
		public void setItemList(ArrayList<ItemDTO> itemList) {
		    this.itemList = itemList;
		}



}
