<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.UserService"%>
<%@ page import="service.User"%>
<%@ page import="service.ServiceProvider"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	HttpSession ses = request.getSession();
	User u = (User) ses.getAttribute("loggedUser");
	int leerjaar = u.getLeerJaar();
	UserService service = ServiceProvider.getUserService();
	request.setAttribute("vaklijst", service.getVakken(leerjaar));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leraar hoofdpagina</title>
<style type="text/css">
h1 {
 font-size: 250%;
}

h2{
	font-size: 225%;
}

td.data {
	font-size : 125%;
}

button {
	font-size: 105%;
}
</style>
</head>
<body>
	<form action="/leraar/LogoutServlet.do" method="post">
		<button type="submit" name="submit" value="Submit">Log-Out</button>
	</form>
	<h1>OBS de Waayer - Leraar</h1>
	<h2>Welkom, ${loggedUser.name}</h2>
	<div>
	<table>
		<tr>
			<td class="data">Vaknaam</td>
			<td class="data">Leerjaar</td>
		</tr>
		<c:forEach var="vakken" items="${vaklijst}">
			<tr>
				<td>
					<form action="/leraar/OpdrachtophaalServlet.do" method="post">
						<button name="vak_klik" type="submit" value="${vakken.vaknaam}">
							${vakken.vaknaam}</button>
					</form>
				</td>
				<td class="data">${vakken.leerjaar}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>