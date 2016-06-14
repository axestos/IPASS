package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO extends BaseDAO {
	private List<String> selectFeedback(String query){
		List<String> feedback = new ArrayList<String>();
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
		while (dbResultSet.next()){
			String opgehaaldeFeedback = dbResultSet.getString("feedback");
			feedback.add(opgehaaldeFeedback);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return feedback;
	}
	
	public List<String> getFeedback(int leerlingcode, String opdrachtcode){//Zoekt de feedback op van een bepaalde persoon bij een opdracht
		return selectFeedback("SELECT feedback FROM feedback WHERE persoonlijkecode ="+leerlingcode+" AND opdrachtcode ='"+opdrachtcode+"'");
	}
	
	public void deleteFeedback(int leerlingcode, String opdrachtcode){//Haalt de feedback weg van een bepaalde persoon bij een opdracht
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM feedback WHERE persoonlijkecode = ? AND opdrachtcode = ?");
			ps.setInt(1, leerlingcode);
			ps.setString(2, opdrachtcode);
			ps.executeUpdate();
			ps.close();
	}
		catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	public void insertFeedback(int leerlingcode, String opdrachtcode, String feedback, String persoonlijkeopdrcode){//Zet de feedback in de tabel
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO feedback(persoonlijkecode,opdrachtcode,feedback,persopdrcode) VALUES(?,?,?,?)");
			String persopdrcode = leerlingcode + opdrachtcode;
			ps.setInt(1, leerlingcode);
			ps.setString(2, opdrachtcode);
			ps.setString(3, feedback);
			ps.setString(4, persopdrcode);
			ps.executeUpdate();
			ps.close();
	}
		catch(SQLException se){
			se.printStackTrace();
		}
		}
}
