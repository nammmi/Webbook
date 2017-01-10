package serviceImpl;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao ud = new UserDaoImpl();

	@Override
	public User findByUserNameAndPassword(String userName, String Password) {
		// TODO Auto-generated method stub
		try {
			return this.ud.findByUserNameAndPassword(userName, Password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean findByUserName(String userName, String email) {
		// TODO Auto-generated method stub
		
			return this.ud.findByUserName(userName, email);
		
	}

	@Override
	public void insertUser(String userName, String Password, String email) {
		// TODO Auto-generated method stub
		
			this.ud.insertUser(userName, Password, email);
	
	}

}
