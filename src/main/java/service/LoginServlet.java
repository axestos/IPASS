package service;

import java.io.IOException;
import java.util.List;

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
		List<User> userlist = service.getUserInList(gebruikersnaam);

		if (!userlist.isEmpty()) {
			User user = service.getUser(gebruikersnaam);
			if (wachtwoord.equals(passwordForCheck)) {
				if (isLeraar == 1) {
					HttpSession ses = req.getSession();
					ses.setAttribute("loggedUser", user);
					Cookie cookie = new Cookie("gebruikersnaam", gebruikersnaam);
					cookie.setMaxAge(7 * 60 * 60 * 24);
					resp.addCookie(cookie);
					req.getRequestDispatcher("leraar/leraarstart.jsp").forward(req, resp);
				} else {
					HttpSession ses = req.getSession();
					ses.setAttribute("loggedUser", user);
					Cookie cookie = new Cookie("gebruikersnaam", gebruikersnaam);
					cookie.setMaxAge(7 * 60 * 60 * 24);
					resp.addCookie(cookie);
					User u = (User)ses.getAttribute("loggedUser");
					System.out.println(u.toString());
					req.getRequestDispatcher("leerling/leerlingstart.jsp").forward(req, resp);
				}
			} else {
				
				req.setAttribute("msgs", "Verkeerd wachtwoord");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		} else {
			
			req.setAttribute("msgs", "Gebruiker niet bekend");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}

	}
}
