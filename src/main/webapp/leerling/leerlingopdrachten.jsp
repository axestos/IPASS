<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.UserService"%>
<%@ page import="service.User"%>
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
	List<Opdracht> opdracht = (List<Opdracht>) ses.getAttribute("opdrachtenLijst");
	ses.getAttribute("gekozenVak");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Opdrachten</title>
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
	<form action="/leerling/LogoutServlet.do" method="post">
		<button type="submit" name="submit" value="Submit">Log-Out</button>
	</form>
	<h1>OBS de Waayer - Opdrachten</h1>
	<h1>${gekozenVak}</h1>
	<br>
	<div>
	<table>
		<tr>
			<td>Opdrachtcode</td>
			<td>Vaknaam</td>
			<td>Leerjaar</td>
		</tr>
		<c:forEach var="opdrachten" items="${opdrachtenLijst}">
			<tr>
				<td><form action="/leerling/HuiswerkvragenServlet.do" method="post">
				<button name="opdracht_klik" type="submit" value="${opdrachten.opdrachtcode}">
				${opdrachten.opdrachtcode}</button></form></td>
				<td>${opdrachten.vaknaam}</td>
				<td>${opdrachten.leerjaar}</td>
			</tr>
		</c:forEach>
			<form action="http://ipass-v1wackw.rhcloud.com/leerling/leerlingstart.jsp">
			<button type="submit">Ander vak kiezen</button>
			</form>
	</table>
</div>
</body>
</html>