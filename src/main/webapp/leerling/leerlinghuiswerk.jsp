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
	List<Huiswerk> huiswerk = (List<Huiswerk>) ses.getAttribute("huiswerkLijst");
	UserService service = ServiceProvider.getUserService();
	String gekozen_vakcode = (String) ses.getAttribute("gekozenOpdracht");
	User u = (User) ses.getAttribute("loggedUser");
	int persoonlijkecode = u.getPersoonlijk_nummer();
	List<String> alleAntwoorden = service.getAntwoordenBijOpdracht(gekozen_vakcode, persoonlijkecode);
	ses.setAttribute("antwoordenLijst", alleAntwoorden);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Huiswerk Opdracht</title>
</head>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<style>
div.container {
	border-radius: 31px;
	width: 250px;
	height: 138px;
	margin: 30px 0;
	padding: 16px;
	font-size : 125%;
}
h1 {
 font-size: 250%;
}

div.text{
	font-size : 125%
}

button {
	font-size: 105%;
}
</style>

<body>
	<h1>OBS de Waayer - Opdrachten</h1>
	<h1>${gekozenOpdracht}</h1>
	<br>
	<form
		action="http://ipass-v1wackw.rhcloud.com/leerling/leerlingopdrachten.jsp">
		<button type="submit">Andere opdracht kiezen</button>
	</form>
	<div class="w3-card-2 w3-red" class="container">
		Foutmeldingen:<br>
		<%
			Object msgs = request.getAttribute("msgs");
			if (msgs != null) {
				out.println(msgs);
			}
		%>
	</div>
	<div class="text">
	<table>
		<c:forEach var="vraag" items="${huiswerkLijst}" varStatus="status">
			<form action="/leerling/SubmitAntwoordServlet.do" method="post">
				<tr>
					<td>${vraag.vraag}</td>
				</tr>
				<tr>
					<td><textarea maxlenght="500" cols="45" rows="5"
							name="textfield">${antwoordenLijst[status.index]}</textarea></td>
				</tr>
				<tr>
					<td><button type="submit" name="submit" value="${vraag.vraag}">
							Sla antwoord op</button></td>
			</form>
			</tr>
			<tr>
			<td><form action="/leerling/VerwijderServlet.do"
					method="post">
					<button type="submit" name="delete" value="${vraag.vraag}">Verwijder
						antwoord</button>
				</form></td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>