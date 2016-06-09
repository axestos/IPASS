package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubmitAntwoordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession ses = req.getSession();
		User u = (User) ses.getAttribute("loggedUser");
		UserService service = ServiceProvider.getUserService();
		String vraag = req.getParameter("vraag");
		System.out.println(vraag);
		String antwoord = req.getParameter("textfield");
		int persoonlijkecode = u.getPersoonlijk_nummer();
		String gekozen_vakcode = (String) ses.getAttribute("gekozenVak");
		List<String> alGegevenAntwoord = service.getAntwoordBijVraag(gekozen_vakcode, persoonlijkecode, vraag);
		System.out.println(alGegevenAntwoord);

		if (!antwoord.equals("")) {
			if (alGegevenAntwoord.isEmpty()) {
				System.out.println("Er is nog geen antwoord gegeven");
				service.insertAntwoord(antwoord, persoonlijkecode, gekozen_vakcode, vraag);
				resp.sendRedirect("leerlinghuiswerk.jsp");
			} else {
				System.out.println("Antwoord veranderen");
				service.deleteAntwoord(persoonlijkecode, gekozen_vakcode, vraag);
				service.insertAntwoord(antwoord, persoonlijkecode, gekozen_vakcode, vraag);
				resp.sendRedirect("leerlinghuiswerk.jsp");
			}
		} 
		else {
			req.setAttribute("msgs", "Vul een antwoord in!");
			req.getRequestDispatcher("leerlinghuiswerk.jsp").forward(req, resp);
		}

	}
}