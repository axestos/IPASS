<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.UserService"%>
<%@ page import="service.User"%>
<%@ page import="service.Huiswerk"%>
<%@ page import="service.Antwoord"%>
<%@ page import="service.ServiceProvider"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="service.Opdracht"%>
<%@ page import="java.util.List"%>
<%@taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	HttpSession ses = request.getSession();
	ses.getAttribute("feedback");
	ses.getAttribute("gekozenOpdracht");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
<style type="text/css">
h1 {
	font-size: 250%;
}

p {
	font-size: 175%;
}
p.text {
	font-size: 150%
}

button {
	font-size: 105%;
}
</style>
</head>
<body>
<form action="/leerling/LogoutServlet.do" method="post">
		<button type="submit" name="submit" value="Submit">Log-Out</button>
	</form>
<h1>OBS de Waayer - Feedback Leerling</h1>
	<h1>${gekozenOpdracht}</h1>
	<form
		action="http://ipass-v1wackw.rhcloud.com/leerling/leerlingkeuze.jsp">
		<button type="submit">Andere keuze maken</button>
	</form>
	<c:if test="${empty feedback}">
		<p>Er is geen feedback gevonden voor deze opdracht.</p>
	</c:if>
	<c:if test="${not empty feedback}">
	<p>Feedback van de leraar:</p>
	<p class="text">${feedback}</p>
	</c:if>	
</body>
</html>