package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public List<Vak> getVakken(int leerjaar){//Haalt alle vakken op uit een bepaald leerjaar.
		List<Vak> vakken = selectVakken("select distinct vaknaam from opdracht WHERE leerjaar="+leerjaar+"");
		return vakken;
	}
}
