<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.UserService"%>
<%@ page import="service.User" %>
<%@ page import="service.ServiceProvider" %>
	<%@taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%User u = (User)request.getAttribute("loggedUser");
	int leerjaar = u.getLeerJaar();
	UserService service = ServiceProvider.getUserService(); 
	request.setAttribute("vaklijst", service.getVakken(leerjaar));%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leerling hoofdpagina</title>
</head>
<body>
<form action="/LogoutServlet.do" method="post">
		<button type="submit" name="submit" value="Submit">Log-Out</button>
	</form>
	<h1>OBS de Waayer - Leerling</h1>
	<h2> Welkom, ${loggedUser.name}</h2>
	<table>
	<c:forEach var="vakken" items="${vaklijst}">
	<tr><td>${vakken.vaknaam}</td></tr>
	</c:forEach> 
	</table>
</body>
</html>