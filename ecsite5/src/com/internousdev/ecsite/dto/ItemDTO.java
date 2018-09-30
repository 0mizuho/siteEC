package com.internousdev.ecsite.dto;

public class ItemDTO {

	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String insertDate;
	private String updateDate;


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

	public String getInsertDate() {
	    return insertDate;
	}
	public void setInsertDate(String insertDate) {
	    this.insertDate = insertDate;
	}

	public String getUpdateDate() {
	    return updateDate;
	}
	public void setUpdateDate(String updateDate) {
	    this.updateDate = updateDate;
	}



}
