package vn.iostar.dao;

import java.util.List;

import vn.iostar.model.UserModel;

public interface UserDao {
	UserModel get(String username);
	
	UserModel findByUserName(String username);

	void insert(UserModel user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	
	void update(String username,String password);
	
	UserModel findByID(int id);
	
	List<UserModel> findAll();
}
