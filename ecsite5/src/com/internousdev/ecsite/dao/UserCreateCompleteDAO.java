package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private DateUtil dateUtil=new DateUtil();

	private String sql=
			"INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin,insert_date) VALUES(?,?,?,?,?)";
	/*引数には入力する部分だけを入力*/
	public void createUser(String loginUserId,String loginPassword,String userName) throws SQLException{
		try{
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,loginUserId);
		preparedStatement.setString(2,loginPassword);
		preparedStatement.setString(3,userName);
		/*管理者かどうかの判断カラムadminの通常ユーザー判断の0をここで代入*/
		preparedStatement.setString(4,"0");
		/*現在時刻のデータ情報形式はDateUtilを参照*/
		preparedStatement.setString(5,dateUtil.getDate());

		preparedStatement.execute();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		connection.close();
	}

}
}
