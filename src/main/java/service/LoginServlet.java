package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = ServiceProvider.getUserService();
		String gebruikersnaam = req.getParameter("gebruikersnaam_login");
		String wachtwoord = req.getParameter("wachtwoord_login");
		int isLeraar = service.isLeraar(gebruikersnaam);
		String passwordForCheck = service.getPassword(gebruikersnaam);		
		User user = service.getUser(gebruikersnaam);
		
		if (wachtwoord.equals(passwordForCheck)){
			if(isLeraar == 1){
				HttpSession ses = req.getSession();
				ses.setAttribute("loggedUser", user);
				Cookie cookie = new Cookie("gebruikersnaam", gebruikersnaam);
				cookie.setMaxAge(7 * 60 * 60 * 24);
				resp.addCookie(cookie);
				req.getRequestDispatcher("leraar/leraarstart.jsp").forward(req, resp);
			}
			else{
				HttpSession ses = req.getSession();
				ses.setAttribute("loggedUser", user);
				Cookie cookie = new Cookie("gebruikersnaam", gebruikersnaam);
				cookie.setMaxAge(7 * 60 * 60 * 24);
				resp.addCookie(cookie);
				req.getRequestDispatcher("leerling/leerlingstart.jsp").forward(req, resp);
			}
		}
		else{
			req.setAttribute("msg", "Gebruiker niet bekend");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	
	}
}
