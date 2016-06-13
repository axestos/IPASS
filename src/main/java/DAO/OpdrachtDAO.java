package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import service.Huiswerk;
import service.Opdracht;
import service.User;
import service.Vak;

public class OpdrachtDAO extends BaseDAO {
	private List<Vak> selectVakken(String query){//haalt een user uit de database
		List<Vak> vakken = new ArrayList<Vak>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			String vaknaam = dbResultSet.getString("vaknaam");
			int leerjaar = dbResultSet.getInt("leerjaar");
			Vak vak = new Vak(vaknaam, leerjaar);
			vakken.add(vak);
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return vakken;
	}
	
	private List<Opdracht> selectOpdrachten(String query){//haalt een user op uit de database
		List<Opdracht> opdrachten = new ArrayList<Opdracht>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			String opdrachtcode = dbResultSet.getString("opdrachtcode");
			String vaknaam = dbResultSet.getString("vaknaam");
			int leerjaar = dbResultSet.getInt("leerjaar");
			Opdracht opdracht = new Opdracht(opdrachtcode, vaknaam, leerjaar);
			opdrachten.add(opdracht);
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return opdrachten;
	}
	
	private List<Huiswerk> selectHuiswerkvragen(String query){//haalt een user uit de database
		List<Huiswerk> huiswerkvragen = new ArrayList<Huiswerk>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			String opdrachtcode = dbResultSet.getString("opdrachtcode");
			String vraag = dbResultSet.getString("vraag");
			Huiswerk huiswerk = new Huiswerk(opdrachtcode, vraag);
			huiswerkvragen.add(huiswerk);
		}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return huiswerkvragen;
	}
	
	
	public List<Huiswerk> getVragen(String opdrachtcode){//Haalt alle vragen op met een bepaalde opdrachtcode
		List<Huiswerk> huiswerk = selectHuiswerkvragen("SELECT opdrachtcode, vraag FROM opdracht WHERE opdrachtcode='"+opdrachtcode+"'");
		return huiswerk;
	}
	
	
	public List<Vak> getVakken(int leerjaar){//Haalt alle vakken op uit een bepaald leerjaar.
		List<Vak> vakken = selectVakken("SELECT DISTINCT vaknaam, leerjaar FROM opdracht WHERE leerjaar="+leerjaar+"");
		return vakken;
	}
	
	public List<Opdracht> getOpdrachten(int leerjaar, String vaknaam){//Haalt de opdrachtcodes op van een leerjaar en vak
		List<Opdracht> opdrachten = selectOpdrachten("Select distinct opdrachtcode, vaknaam, leerjaar from opdracht "
				+ "WHERE leerjaar ="+leerjaar+" AND vaknaam = '"+vaknaam+"'");
		return opdrachten;
	}
}
