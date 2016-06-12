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
<%@ page import="java.util.List"%>
<%@taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	HttpSession ses = request.getSession();
	List<Klas> klas = (List<Klas>) ses.getAttribute("leerlingenLijst");
	ses.getAttribute("gekozenVak");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leraar Klas</title>
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
<body>
	<form action="/leraar/LogoutServlet.do" method="post">
		<button type="submit" name="submit" value="Submit">Log-Out</button>
	</form>
	<h1>OBS de Waayer - Leraar klas</h1>
	<h1>${gekozenOpdracht}</h1>
	<form action="http://ipass-v1wackw.rhcloud.com/leraar/leraaropdrachten.jsp">
		<button type="submit">Andere opdracht kiezen</button>
	</form>
	<div>
	<table>
		<tr>
			<td>Leerlingcode</td>
			<td>Leerling</td>
			<td>Klascode</td>
		</tr>
		<c:forEach var="leerling" items="${leerlingenLijst}">
			<tr>
				<td><form action="/leraar/VraagEnAntwoordServlet.do"
						method="post">
						<button name="leerling_klik" type="submit"
							value="${leerling.leerlingcode}">
							${leerling.leerlingcode}</button>
					</form></td>
				<td>${leerling.leerlingnaam}</td>
				<td>${leerling.klascode}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>