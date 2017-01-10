package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.UserDao;
import jdbccon.MysqlCon2;
import model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User findByUserNameAndPassword(String userName, String Password) {
		// TODO Auto-generated method stub
		java.sql.Connection con = MysqlCon2.getConnection(); 
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet result = null;
		String sql = "select * from user where username = ? and password = ?";
		User user = new User();
		try{
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			pre.setString(2, Password);
			result = pre.executeQuery();
			while(result.next())
			{
				user = new User(result.getInt("id"), result.getString("username"), result.getString("password"), result.getString("email"), 
						result.getString("createtime"), result.getString("status"), result.getString("level"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MysqlCon2.close(result, pre, con);
		}
		return user;
	}

	@Override
	public boolean findByUserName(String userName, String email) {
		// TODO Auto-generated method stub
		java.sql.Connection con = MysqlCon2.getConnection(); 
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet result = null;
		String sql = "select * from user where username = ? or email = ?";
		
		try{
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			pre.setString(2, email);
			result = pre.executeQuery();
			while(result.next())              
			{
				return true;  //找到相同的，则返回true
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MysqlCon2.close(result, pre, con);
		}
		return false; //如果用户名和邮箱可以使用，则返回false
	}

	@Override
	public void insertUser(String userName, String Password, String email) {
		// TODO Auto-generated method stub
		java.sql.Connection con = MysqlCon2.getConnection(); 
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		String sql = "insert into user (username, password, email, createtime, status, level) values (?,?,?,now(),?,?)";
		try{
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			pre.setString(2, Password);
			pre.setString(3, email);
			pre.setString(4, "有效");
			pre.setString(5, "普通");
			pre.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			MysqlCon2.close(pre, con);
		}
		
	}

}
