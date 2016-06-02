package service;

import java.util.List;

import DAO.UserDAO;

public class UserService {
	private UserDAO dao = new UserDAO();

	public List<User> getAllKlas(String klas) {
		return dao.allUsersUitKlas(klas);
	}

	public String getPassword(String username) {
		return dao.getPassword(username);
	}

	public int isLeraar(String username) {
		return dao.getBevoegdheid(username);
	}

	public User getUser(String username) {
		return dao.getUser(username);
	}

}
