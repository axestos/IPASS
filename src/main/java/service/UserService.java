package service;

import java.util.List;

import DAO.OpdrachtDAO;
import DAO.UserDAO;

public class UserService {
	private UserDAO dao = new UserDAO();
	private OpdrachtDAO opdracht = new OpdrachtDAO();

	public List<Klas> getAllLeerlingenKlas(String klas) {
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
	public List<User> getUserInList(String username){
		return dao.getUserInList(username);
	}
	
	public List<Vak> getVakken(int leerjaar){
		return opdracht.getVakken(leerjaar);
	}
	
	public void veranderWachtWoord(String wachtwoord, String username){
		dao.veranderWachtwoord(wachtwoord, username);
	}
}
