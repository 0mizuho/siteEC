package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;


public class LoginDAO {

	DBConnector dbConnector=new DBConnector();
	Connection connection=dbConnector.getConnection();
	LoginDTO loginDTO=new LoginDTO();

	/*ログインに必要な情報*/
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		String sql="SELECT * FROM login_user_transaction where login_id=? AND login_pass=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,loginUserId);
			preparedStatement.setString(2,loginPassword);

			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setAdmin(resultSet.getString("admin"));
				/*ログインIDがnullではなかったらtrue*/
				if(!(resultSet.getString("login_id").equals(null))){
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
	}

	public LoginDTO getLoginDTO(){
		return loginDTO;
	}

	/*ログインに必要な情報*/
	public LoginDTO getUserInfo(String userName,String loginId){
		String sql="SELECT * FROM login_user_transaction where user_name=? AND login_id=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,loginId);

			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setAdmin(resultSet.getString("admin"));
				/*ログインIDがnullではなかったらtrue*/
				if(!(resultSet.getString("login_id").equals(null))){
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
	}

	/*パスワード再設定用メソッド(今回はloginIdで紐付け)*/
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
