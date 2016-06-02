package DAO;

import service.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO{
	private List<User> selectKlas(String query){
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
			User user = new User(persoonlijk_nummer, naam_vol, username, password, klas, isLeraar);
			users.add(user);
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return users;
	}
	public List<User> allUsersUitKlas(String klas){//Haalt alles op uit een klas met een bepaalde klascode
		List<User> heleKlas = selectKlas("SELECT * FROM users WHERE klas = '"+klas+"'");
		return heleKlas;
	}
	
	
	private String selectUserPassword(String query){
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
	
	public String getPassword(String username){//Haalt het wachtwoord op van iemand met een bapaalde username
		String password = selectUserPassword("SELECT password FROM users WHERE username = '"+username+"'");
		return password;
	}
	
	private int selectIsLeraar(String query){
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
	public int getBevoegdheid(String username){//Haalt de bevoegdheid op van iemand met een bepaalde username
		int isLeraar = selectIsLeraar("SELECT isLeraar FROM users WHERE username = '"+username+"'");
		return isLeraar;
	}
	
	
	public User getUser(String username){//Haalt alles van de gebruiker op met een bepaalde username
		User user = selectKlas("SELECT * FROM users WHERE username = '"+username+"'").get(0);
		return user;
	}
}
