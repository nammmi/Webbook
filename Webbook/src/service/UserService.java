package service;

import model.User;

    /**
     * .....
     * @author sixin.li
     *
     */

public interface UserService {
    

     /**
     * 登录验证时用。
     * @param userName user name
     * @param Password pass word
     * @return User
     */
    public User findByUserNameAndPassword(String userName, String Password);
       

    /**
     * 注册时判断userName和email是否被占用
     * @param userName user name
     * @param email    email
     * @return         boolean
     */
    public boolean findByUserName(String userName, String email);
    
    /**
     * 添加新用户,createtime,status,level字段指定。
     * @param userName user name
     * @param Password pass word
     * @param email    email
     */
    public void insertUser(String userName, String Password, String email);

}
