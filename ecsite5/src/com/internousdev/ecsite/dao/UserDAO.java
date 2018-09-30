package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserDAO {

	/*ユーザー情報一覧取得用メソッド*/
	public ArrayList<UserDTO> getUserInfo() throws SQLException{
		ArrayList<UserDTO> userDTO=new ArrayList<UserDTO>();
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql=
				"SELECT id,login_id,login_pass,user_name,admin,insert_date,updated_date FROM login_user_transaction";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			ResultSet resultSet=preparedStatement.executeQuery();
			/*ループ文(複数件の情報を消さずに格納するため)にて１件ずつDTOに格納し、ArrayListにもあわせて格納*/
			while(resultSet.next()){
				UserDTO dto=new UserDTO();
				dto.setId(resultSet.getString("id"));
				dto.setLoginId(resultSet.getString("login_id"));
				dto.setLoginPass(resultSet.getString("login_pass"));
				dto.setUserName(resultSet.getString("user_name"));
				dto.setAdmin(resultSet.getString("admin"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				dto.setUpdatedDate(resultSet.getString("updated_date"));
				userDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}

		return userDTO;
	}

	/*ユーザー情報一括削除(今回は管理者は削除されないように設定)用メソッド*/
	public int userAllDelete() throws SQLException{

		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="DELETE FROM login_user_transaction WHERE admin=0";
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

	/*ユーザー詳細情報取得用メソッド(今回はidで紐付け)*/
	public UserDTO getUserDetailInfo(String id){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="SELECT * FROM login_user_transaction WHERE id=?";
		UserDTO userDTO=new UserDTO();
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				userDTO.setId(resultSet.getString("id"));
				userDTO.setLoginId(resultSet.getString("login_id"));
				userDTO.setLoginPass(resultSet.getString("login_pass"));
				userDTO.setUserName(resultSet.getString("user_name"));
				userDTO.setAdmin(resultSet.getString("admin"));
				userDTO.setInsertDate(resultSet.getString("insert_date"));
				userDTO.setUpdatedDate(resultSet.getString("updated_date"));
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

	/*ユーザー情報１件削除用メソッド(今回はidで紐付け)*/
	public int userDelete(String id) throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="DELETE FROM login_user_transaction WHERE id=?";
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

	/*ユーザー情報更新用メソッド(今回はidで紐付け)*/
	public int userUpdate(String loginId,String loginPass,String userName,String admin,String id) throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		DateUtil dateUtil=new DateUtil();
		String sql=
				"UPDATE login_user_transaction SET "
				+ "login_id=?,login_pass=?,user_name=?,admin=?,updated_date=? WHERE id=?";
		PreparedStatement preparedStatement;
		int result=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,loginId);
			preparedStatement.setString(2,loginPass);
			preparedStatement.setString(3,userName);
			preparedStatement.setString(4,admin);
			preparedStatement.setString(5,dateUtil.getDate());
			preparedStatement.setString(6,id);
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}

	/*ログインパスワード再設定用メソッド(今回はloginIdで紐付け)*/
	public int resetPass(String loginPass,String loginId) throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql=
				"UPDATE login_user_transaction SET "
				+ "login_pass=? WHERE login_id=?";
		PreparedStatement preparedStatement;
		int result=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,loginPass);
			preparedStatement.setString(2,loginId);
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}
}
