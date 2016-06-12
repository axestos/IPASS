package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import service.Antwoord;
import service.Vak;

public class AntwoordDAO extends BaseDAO {

	private List<Antwoord> selectAntwoorden(String query){
		List<Antwoord> antwoorden = new ArrayList<Antwoord>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
				String gegevenAntwoord = dbResultSet.getString("antwoord");
				int persoonlijkecode = dbResultSet.getInt("persoonlijkecode");
				String vraag = dbResultSet.getString("opdrachtvraag");
				String opdrachtcode = dbResultSet.getString("opdrachtcode");
				Antwoord antwoord = new Antwoord(gegevenAntwoord, persoonlijkecode, vraag, opdrachtcode);
				antwoorden.add(antwoord);
			}}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return antwoorden;
		}
	
	private List<String> selectAntwoordBijVraag(String query){
		List<String> antwoord = new ArrayList<String>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			String opgehaaldAntwoord = dbResultSet.getString("antwoord");
			antwoord.add(opgehaaldAntwoord);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return antwoord;
	}
	
	public List<String> getAntwoord(String opdrachtcode, int persoonlijkecode, String vraag){//haalt het antwoord op van een bepaalde vraag
		return selectAntwoordBijVraag("SELECT antwoord FROM antwoord WHERE persoonlijkecode='"+persoonlijkecode+"' AND opdrachtvraag='"+vraag+"' "
				+ "AND opdrachtcode='"+opdrachtcode+"'");
	}
	
	public List<String> getAntwoordenBijOpdracht(String opdrachtcode, int persoonlijkecode){//haalt het antwoord op van een bepaalde vraag
		return selectAntwoordBijVraag("SELECT * FROM antwoord WHERE persoonlijkecode='"+persoonlijkecode+"' AND opdrachtcode='"+opdrachtcode+"'");
	}
	
	public void insertAntwoord(String antwoord, int persoonlijkecode, String opdrachtcode, String vraag){//Zet een antwoord in de tabel.
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO antwoord(antwoord, persoonlijkecode, opdrachtvraag, opdrachtcode) VALUES(?,?,?,?)");
			ps.setString(1, antwoord);
			ps.setInt(2, persoonlijkecode);
			ps.setString(3, vraag);
			ps.setString(4, opdrachtcode);
			ps.executeUpdate();
			ps.close();
	}
		catch(SQLException se){
			se.printStackTrace();
		}
		}
	
	public void deleteAntwoord(int persoonlijkecode, String opdrachtcode, String vraag){//Delete een antwoord bij een bepaalde vraag van een persoon.
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM antwoord WHERE persoonlijkecode = ? AND opdrachtvraag = ? AND opdrachtcode = ?");
			ps.setInt(1, persoonlijkecode);
			ps.setString(2, vraag);
			ps.setString(3, opdrachtcode);
			ps.executeUpdate();
			ps.close();
	}
		catch(SQLException se){
			se.printStackTrace();
		}
		}
	
}
