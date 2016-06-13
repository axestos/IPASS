package DAO;

import service.Klas;
import service.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO{
	private List<User> selectUser(String query){//haalt een user uit de database
		List<User> users = new ArrayList<User>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			int persoonlijk_nummer = dbResultSet.getInt("persoonlijk_nummer");
			String naam_vol = dbResultSet.getString("naam_vol");
			String username = dbResultSet.getString("username");
			String password = dbResultSet.getString("password");
			String klas = dbResultSet.getString("klas");
			int isLeraar = dbResultSet.getInt("isLeraar");
			int leerjaar = dbResultSet.getInt("leerjaar");
			User user = new User(persoonlijk_nummer, naam_vol, username, password, klas, isLeraar, leerjaar);
			users.add(user);
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return users;
	}
	
	private List<Klas> selectKlas(String query){//haalt leerlingen uit een klas op
		List<Klas> klasUserList = new ArrayList<Klas>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			int persoonlijk_nummer = dbResultSet.getInt("persoonlijk_nummer");
			String naam_vol = dbResultSet.getString("naam_vol");
			String klas = dbResultSet.getString("klas");
		
			Klas klasLeerlingen = new Klas(klas, persoonlijk_nummer, naam_vol);
			klasUserList.add(klasLeerlingen);
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return klasUserList;
	}
	
	
	private String selectUserPassword(String query){//Haalt het wachtwoord uit de database
		String password = null;
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			String passwordUitDB = dbResultSet.getString("password");
			password = passwordUitDB;
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return password;
	}
	
	private List<String> selectVolledigeNaam(String query){//Haalt het wachtwoord uit de database
		List<String> naam_vol = new ArrayList<String>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			String volledigenaam  = dbResultSet.getString("naam_vol");
			naam_vol.add(volledigenaam);
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return naam_vol;
	}
	
	
	
	private int selectIsLeraar(String query){ // haalt bevoegdheid uit Database
		int isLeraar = 0;
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			int isLeraarUitDB = dbResultSet.getInt("isLeraar");
			isLeraar = isLeraarUitDB;
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return isLeraar;
	}
	
	
	public String getPassword(String username){//Haalt het wachtwoord op van iemand met een bapaalde username
		String password = selectUserPassword("SELECT password FROM users WHERE username = '"+username+"'");
		return password;
	}
	
	public int getBevoegdheid(String username){//Haalt de bevoegdheid op van iemand met een bepaalde username
		int isLeraar = selectIsLeraar("SELECT isLeraar FROM users WHERE username = '"+username+"'");
		return isLeraar;
	}
	
	public List<User> getUserInList(String username){//Probeerd de user op te halen die probeerd in te loggen om een index error te voorkomen.
		List<User> user = selectUser("SELECT * FROM users WHERE username = '"+username+"'"); 
		return user;
	}
	public User getUser(String username){//Haalt alles van de gebruiker op met een bepaalde username
		User user = selectUser("SELECT * FROM users WHERE username = '"+username+"'").get(0);
		return user;
	}
	
	public User getUserByName(String naam){//Haalt de user op doormiddel van de naam
		User user = selectUser("SELECT * FROM users WHERE naam_vol ='"+naam+"'").get(0);
		return user;
	}
	
	public List<Klas> allUsersUitKlas(String klas){//Haalt alle leerlingen op uit een klas met een bepaalde klascode
		List<Klas> heleKlas = selectKlas("SELECT * FROM users WHERE klas = '"+klas+"'"
				+ "AND isLeraar=0");
		return heleKlas;
	}
	
	public List<String> getVolledigeNaam(int persoonlijkecode){//Haalt alles van een gebruiker op met een bepaalde personlijke code
		return selectVolledigeNaam("SELECT naam_vol FROM users WHERE persoonlijk_nummer ="+persoonlijkecode);
	}
	
	public void veranderWachtwoord(String wachtwoord, String username){//Update het wachtwoord van een gebruiker
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE users SET password = ? WHERE username = ? ");
			ps.setString(1, wachtwoord);
			ps.setString(2, username);
			ps.executeUpdate();
			ps.close();
	}
		catch(SQLException se){
			se.printStackTrace();
		}
		}
}
