package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WachtwoordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = ServiceProvider.getUserService();
		String gebruikersnaam = req.getParameter("gebruikersnaam_verander");
		String wachtwoord = req.getParameter("wachtwoord_verander");
		String wachtwoord_nieuw = req.getParameter("wachtwoord_nieuw");
		String passwordForCheck = service.getPassword(gebruikersnaam);
		List<User> userlist = service.getUserInList(gebruikersnaam);
		
		if(!userlist.isEmpty()){
			if(wachtwoord.equals(passwordForCheck)){
				service.veranderWachtWoord(wachtwoord_nieuw, gebruikersnaam);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
			else{
				req.setAttribute("msgs", "Wachtwoord klopt niet");
				req.getRequestDispatcher("/verander.jsp").forward(req, resp);
			}
		}
		else{
			req.setAttribute("msgs", "Gebruiker niet bekend");
			req.getRequestDispatcher("/verander.jsp").forward(req, resp);
		}
		
		
}
}