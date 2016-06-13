package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteFeedback extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserService service = ServiceProvider.getUserService();
	HttpSession ses = req.getSession();
	List<String> opgevraagdeleerling = (List<String>) ses.getAttribute("opgevraagdeLeerling");
	String naam = opgevraagdeleerling.get(0);
	User user = service.getUserByName(naam);
	String username = user.getUsername();
	User leerling = service.getUser(username);
	int leerlingcode = leerling.getPersoonlijk_nummer();
	String opdrachtcode = (String) ses.getAttribute("gekozenOpdracht");
	service.deleteFeedback(leerlingcode, opdrachtcode);
	req.getRequestDispatcher("leraarantwoorden.jsp").forward(req, resp);
	//Haalt de gegeven feedback weg uit de table.
}}
