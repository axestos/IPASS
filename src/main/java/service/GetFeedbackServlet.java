package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetFeedbackServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = ServiceProvider.getUserService();
		HttpSession ses = req.getSession();
		User u = (User) ses.getAttribute("loggedUser");
		int leerlingcode = u.getPersoonlijk_nummer();
		String opdrachtcode = (String)ses.getAttribute("gekozenOpdracht");
		
		List<String> feedback = service.getFeedback(leerlingcode, opdrachtcode);
		ses.setAttribute("feedback", feedback);
		req.getRequestDispatcher("/leerling/leerlingfeedback.jsp").forward(req, resp);
		//Haalt de feedback van een leerling bij een opdracht op.
}
}