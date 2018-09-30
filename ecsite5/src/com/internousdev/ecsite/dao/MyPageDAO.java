package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.dto.UserDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

	/*購入履歴を取得するためのメソッド(MyPageUserInfo)*/
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();
		/*LEFT JOINによる左外部接合でuser_buy_item_transactionを主としてitem_info_transactionの任意のものを付属させる*/
		String sql=
				"SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY insert_date DESC";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,user_master_id);
			ResultSet resultSet=preparedStatement.executeQuery();

			/*取得した情報をループ文(while)で１件ずつDTOに格納し、さらにArrayListに格納*/
			/*これにより複数件の購入履歴を消さずに格納可能*/
			while(resultSet.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				myPageDTO.add(dto);
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				connection.close();
			}
		return myPageDTO;
	}

	/*購入履歴を削除するためのメソッド(buyItemHistoryDelete)*/
	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{
		String sql=
				"DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id=?";
		PreparedStatement preparedStatement;
		/*resultの初期値件数に0を代入しておく*/
		int result=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,user_master_id);
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		/*MyPageActionのresに件数を返す*/
		return result;
	}

	//製作途中　詳細個人//
	public UserDTO myPageDetail(String loginId){

		UserDTO userDTO=new UserDTO();
		String sql=
				"SELECT id,login_id,login_pass,user_name FROM login_user_transaction WHERE login_id=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,loginId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				userDTO.setId(resultSet.getString("id"));
				userDTO.setLoginId(resultSet.getString("login_id"));
				userDTO.setLoginPass(resultSet.getString("login_pass"));
				userDTO.setUserName(resultSet.getString("user_name"));

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userDTO;

	}

}
