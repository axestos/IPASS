package service;

import java.util.List;

import DAO.AntwoordDAO;
import DAO.OpdrachtDAO;
import DAO.UserDAO;
//Implementeerd alle DAO's voor gebruik in andere klassen.
public class UserService {
	private UserDAO dao = new UserDAO();
	private OpdrachtDAO opdracht = new OpdrachtDAO();
	private AntwoordDAO ant = new AntwoordDAO();

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
	
	public List<Opdracht> getOpdrachten(int leerjaar, String vaknaam){
		return opdracht.getOpdrachten(leerjaar, vaknaam);
	}
	
	public List<Huiswerk> getVragen(String opdrachtcode){
		return opdracht.getVragen(opdrachtcode);
	}
	
	public List<String> getAntwoordBijVraag(String opdrachtcode, int persoonlijkecode, String vraag){
		return ant.getAntwoord(opdrachtcode, persoonlijkecode, vraag);
	}
	
	public List<String> getAntwoordenBijOpdracht(String opdrachtcode, int persoonlijkecode){
		return ant.getAntwoordenBijOpdracht(opdrachtcode, persoonlijkecode);
	}
	
	public void insertAntwoord(String antwoord, int persoonlijkecode, String opdrachtcode, String vraag){
		ant.insertAntwoord(antwoord, persoonlijkecode, opdrachtcode, vraag);	
	}
	
	public void deleteAntwoord(int persoonlijkecode, String opdrachtcode, String vraag){
		ant.deleteAntwoord(persoonlijkecode, opdrachtcode, vraag);	
	}
	
	public List<String> getVolledigeNaam(int persoonlijkecode){
		return dao.getVolledigeNaam(persoonlijkecode);
	}
}
