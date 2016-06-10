package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerwijderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession ses = req.getSession();
		User u = (User) ses.getAttribute("loggedUser");
		UserService service = ServiceProvider.getUserService();
		String vraag = req.getParameter("delete");
		int persoonlijkecode = u.getPersoonlijk_nummer();
		String gekozen_vakcode = (String) ses.getAttribute("gekozenOpdracht");

		service.deleteAntwoord(persoonlijkecode, gekozen_vakcode, vraag);
		service.insertAntwoord("", persoonlijkecode, gekozen_vakcode, vraag);
		resp.sendRedirect("leerlinghuiswerk.jsp");
	}

}
