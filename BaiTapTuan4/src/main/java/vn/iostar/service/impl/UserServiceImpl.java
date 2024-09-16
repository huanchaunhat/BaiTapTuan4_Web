package vn.iostar.service.impl;

import vn.iostar.model.UserModel;
import vn.iostar.service.UserService;
import vn.iostar.dao.Impl.UserDaoImpl;
import vn.iostar.dao.UserDao;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	public UserModel get(String username) {
		return userDao.get(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(0, email, username, fullname, password, null, 5, phone, date));
		return true;

	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean forgetPass(String username, String password) {
		try {
			userDao.update(username, password);
			return true;
		}catch(Exception e) {
			return false;
		  }
	}

}
