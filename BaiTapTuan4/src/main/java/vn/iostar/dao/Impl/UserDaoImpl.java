package vn.iostar.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.dao.UserDao;
import vn.iostar.model.UserModel;
import vn.iostar.connection.DBConnection;
import vn.iostar.model.UserModel;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	// Viết hàm xử lý DAO tại đây
	public UserModel get(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(email, username, fullname, password, avatar, roleid,phone, createddate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getAvatar());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreatedDate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from users where email = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where username = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(String username, String password) {
		String sql = "UPDATE users SET password = ? WHERE username = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public UserModel findByID(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {	
				list.add(new UserModel(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("avatar"),
						rs.getString("fullname"),
						rs.getString("email"),
						rs.getInt("roleid"),
						rs.getString("phone"),
						rs.getDate("createdDate")));
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		try {
			UserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findByUserName("nhathuan"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
