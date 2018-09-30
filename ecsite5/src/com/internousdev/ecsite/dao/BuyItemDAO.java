package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	/*商品購入に必要な情報*/
	public BuyItemDTO getBuyItemInfo(){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		BuyItemDTO buyItemDTO=new BuyItemDTO();

		String sql="SELECT id,item_name,item_price FROM item_info_transaction";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			/*Select文でDBから取得した情報をDTOに収納*/
			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		/*ActionクラスにDTOクラスを返す*/
		return buyItemDTO;
	}

}
