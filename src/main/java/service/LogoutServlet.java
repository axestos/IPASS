package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	HttpSession ses = req.getSession();
	ses.invalidate();
	resp.sendRedirect("index.jsp");
	}
	//Maakt de sessie invalid, hierdoor logt de user uit en stuurt de gebruiker naar de loginpagina
}
