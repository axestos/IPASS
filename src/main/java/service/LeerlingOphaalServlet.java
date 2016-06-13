package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LeerlingOphaalServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = ServiceProvider.getUserService();
		HttpSession ses = req.getSession();
		User u = (User) ses.getAttribute("loggedUser");
		String klascode = u.getKlas();
		String opdrachtcode = req.getParameter("opdracht_klik");
		ses.setAttribute("gekozenOpdracht", opdrachtcode);
		List<Klas> klas = service.getAllLeerlingenKlas(klascode);
		ses.setAttribute("leerlingenLijst", klas);
		req.getRequestDispatcher("/leraar/leraarklas.jsp").forward(req, resp);
	//Haalt alle leerlingen op uit een bepaalde klas met behulp van de UserService en zet deze in een attribuut
		//zodat deze opgehaald kunnen worden op de volgende pagina
	
	}}
