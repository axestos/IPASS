package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import service.User;

public class LeraarFilter implements Filter{
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)//Filtert alle verkeer naar /leerling/
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		User u = (User) request.getSession().getAttribute("loggedUser");
		if(u.getIsLeraar()==0){
			request.getRequestDispatcher("/leerling/leerlingstart.jsp").forward(req, resp);
				}
		else {
			chain.doFilter(req, resp);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
