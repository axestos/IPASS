package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OpdrachtophaalServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String gekozenvak = req.getParameter("vak_klik");
		UserService service = ServiceProvider.getUserService();
		HttpSession ses = req.getSession();
		ses.setAttribute("gekozenVak", gekozenvak);
		User u = (User) ses.getAttribute("loggedUser");
		int isLeraar = u.getIsLeraar();
		int leerjaar = u.getLeerJaar();
		System.out.println(gekozenvak);
		List<Opdracht> opdrachten = service.getOpdrachten(leerjaar, gekozenvak);
		System.out.println(opdrachten.toString());
		ses.setAttribute("opdrachtenLijst", opdrachten);
		if (isLeraar == 0) {
			req.getRequestDispatcher("/leerling/leerlingopdrachten.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/leraar/leraaropdrachten.jsp").forward(req, resp);
		}
	}
}