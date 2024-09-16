package vn.iostar.dao;

import vn.iostar.model.UserModel;

public interface UserDao {
	UserModel get(String username);

	void insert(UserModel user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	
	void update(String username,String password);

}
