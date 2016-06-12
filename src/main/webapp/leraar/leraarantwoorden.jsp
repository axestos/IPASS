<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.UserService"%>
<%@ page import="service.User"%>
<%@ page import="service.ServiceProvider"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="service.Klas"%>
<%@ page import="service.Huiswerk"%>
<%@ page import="service.Antwoord"%>
<%@ page import="java.util.List"%>
<%@taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	HttpSession ses = request.getSession();
	List<Huiswerk> huiswerkvragen = (List<Huiswerk>) ses.getAttribute("huiswerkLijst");
	List<String> opgevraagdeleerling = (List<String>) ses.getAttribute("opgevraagdeLeerling");
	List<String> antwoorden = (List<String>) ses.getAttribute("antwoordenLijst");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leraar antwoorden</title>
<style type="text/css">
h1 {
 font-size: 250%;
}

div {
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
	<h1>OBS de Waayer - Antwoorden van leerling:</h1>
	<h1>${opgevraagdeLeerling}</h1>
	<form
		action="http://ipass-v1wackw.rhcloud.com/leraar/leraarklas.jsp">
		<button type="submit">Andere leerling kiezen</button>
	</form>
	<table>
		<c:forEach var="vraag" items="${huiswerkLijst}" varStatus="status">
			<div>
			<tr>
				<td>${vraag.vraag}</td>
			</tr>
			<tr>
				<td><b>${antwoordenLijst[status.index]}</b></td>
			</tr>
			</div>
		</c:forEach>
	</table>
</body>
</html>