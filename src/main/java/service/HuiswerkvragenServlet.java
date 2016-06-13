package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HuiswerkvragenServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = ServiceProvider.getUserService();
		String opdrachtcode = req.getParameter("opdracht_klik");
		System.out.println(opdrachtcode);
		HttpSession ses = req.getSession();
		ses.setAttribute("gekozenOpdracht", opdrachtcode);
		List<Huiswerk> huiswerkvragen = service.getVragen(opdrachtcode);
		System.out.println(huiswerkvragen.toString());
		ses.setAttribute("huiswerkLijst", huiswerkvragen);
		req.getRequestDispatcher("/leerling/leerlinghuiswerk.jsp").forward(req, resp);
		//Haalt de vragen op via de UserService en zet deze in attributen zodat ze op de volgende pagina 
		//opgehaald kunnen worden
	}
}
