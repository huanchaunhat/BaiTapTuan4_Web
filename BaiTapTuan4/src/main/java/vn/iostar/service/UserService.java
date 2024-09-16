package vn.iostar.service;

import vn.iostar.model.UserModel;

public interface UserService {
	UserModel login(String username, String password);

	UserModel get(String username);

	void insert(UserModel user);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	
	boolean forgetPass(String username,String password);

}
