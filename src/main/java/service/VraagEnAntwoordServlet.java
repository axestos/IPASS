package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VraagEnAntwoordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = ServiceProvider.getUserService();
		HttpSession ses = req.getSession();
		String opdrachtcode = (String) ses.getAttribute("gekozenOpdracht");
		List<Huiswerk> huiswerkvragen = service.getVragen(opdrachtcode);
		ses.setAttribute("huiswerkLijst", huiswerkvragen);
		
		String leerlingcode_string = req.getParameter("leerling_klik");
		int leerlingcode = Integer.parseInt(leerlingcode_string);
		List<String> opgevraagde_leerling = service.getVolledigeNaam(leerlingcode);
		ses.setAttribute("opgevraagdeLeerling", opgevraagde_leerling);

		List<String> antwoorden = service.getAntwoordenBijOpdracht(opdrachtcode, leerlingcode);
		ses.setAttribute("antwoordenLijst", antwoorden);
		
		req.getRequestDispatcher("/leraar/leraarantwoorden.jsp").forward(req, resp);
	}
}
