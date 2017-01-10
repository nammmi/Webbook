package dao;

import model.User;

public interface UserDao {
	
	public User findByUserNameAndPassword(String userName, String Password);//登录验证时用。
	
	public boolean findByUserName(String userName, String email);//注册时判断userName和email是否被占用
	
	public void insertUser(String userName, String Password, String email);//添加新用户,createtime,status,level字段指定。

}
