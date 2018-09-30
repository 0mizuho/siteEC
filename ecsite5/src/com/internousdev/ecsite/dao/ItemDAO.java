package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.internousdev.ecsite.dto.ItemDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;


public class ItemDAO {

	/*商品一覧取得用メソッド*/
	public ArrayList<ItemDTO> getItemInfo() throws SQLException{

		ArrayList<ItemDTO> itemDTO=new ArrayList<ItemDTO>();
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="SELECT id,item_name,item_price,item_stock,insert_date,update_date FROM item_info_transaction";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			/*ループ文(複数件の情報を消さずに格納するため)にて１件ずつDTOに格納し、ArrayListにもあわせて格納*/
			while(resultSet.next()){
				ItemDTO dto=new ItemDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				itemDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return itemDTO;
	}

	/*商品一括削除用メソッド*/
	public int itemAllDelete() throws SQLException{

		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="DELETE FROM item_info_transaction";
		PreparedStatement preparedStatement;
		int result=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}

	/*商品詳細情報取得用メソッド(今回はidで紐付け)*/
	public ItemDTO getItemDetailInfo(String id){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql = "SELECT * FROM item_info_transaction WHERE id=?";
		ItemDTO itemDTO=new ItemDTO();
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				itemDTO.setId(resultSet.getString("id"));
				itemDTO.setItemName(resultSet.getString("item_name"));
				itemDTO.setItemPrice(resultSet.getString("item_price"));
				itemDTO.setItemStock(resultSet.getString("item_stock"));
				itemDTO.setInsertDate(resultSet.getString("insert_date"));
				itemDTO.setUpdateDate(resultSet.getString("update_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemDTO;
	}

	/*商品１件削除用メソッド(今回はidで紐付け*/
	public int itemDelete(String id) throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="DELETE FROM item_info_transaction WHERE id=?";
		PreparedStatement preparedStatement;
		int result=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,id);
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}

	/*商品更新用メソッド(今回はidで紐付け)*/
	public int itemUpdate(String itemName,String itemPrice,String itemStock,String id) throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		DateUtil dateUtil=new DateUtil();
		String sql=
				"UPDATE item_info_transaction SET item_name=?,item_price=?,item_stock=?,update_date=? WHERE id=?";
		PreparedStatement preparedStatement;
		int result=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,itemName);
			preparedStatement.setString(2,itemPrice);
			preparedStatement.setString(3,itemStock);
			preparedStatement.setString(4,dateUtil.getDate());
			preparedStatement.setString(5,id);
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}

}
