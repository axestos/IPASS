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
	UserService service = ServiceProvider.getUserService();
	ses.getAttribute("huiswerkLijst");
	ses.getAttribute("opgevraagdeLeerling");
	ses.getAttribute("antwoordenLijst");
	List<String> opgevraagdeleerling = (List<String>) ses.getAttribute("opgevraagdeLeerling");
	String naam = opgevraagdeleerling.get(0);
	User user = service.getUserByName(naam);
	String username = user.getUsername();
	User leerling = service.getUser(username);
	int leerlingcode = leerling.getPersoonlijk_nummer();
	String opdrachtcode = (String) ses.getAttribute("gekozenOpdracht");
	List<String> feedbackList = service.getFeedback(leerlingcode, opdrachtcode);
	if (!feedbackList.isEmpty()) {
		String feedback = feedbackList.get(0);
		ses.setAttribute("feedback", feedback);
	} else {
		ses.setAttribute("feedback", "");
	}
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

td.data {
	font-size: 125%;
}

button {
	font-size: 105%;
}

textarea {
	font-size: 125%
}
</style>
</head>

<body>
	<form action="/leraar/LogoutServlet.do" method="post">
		<button type="submit" name="submit" value="Submit">Log-Out</button>
	</form>
	<h1>OBS de Waayer - Antwoorden van leerling:</h1>
	<h1>${opgevraagdeLeerling}</h1>
	<form action="http://ipass-v1wackw.rhcloud.com/leraar/leraarklas.jsp">
		<button type="submit">Andere leerling kiezen</button>
	</form>
	<table>
		<c:forEach var="vraag" items="${huiswerkLijst}" varStatus="status">
			<tr>
				<td class="data">${vraag.vraag}</td>
			</tr>
			<tr>
				<td class="data"><b>${antwoordenLijst[status.index]}</b></td>
			</tr>
		</c:forEach>
		<tr></tr>
		<tr>
			<td>
				<form action="/leraar/InsertFeedbackServlet.do" method="post">
					<textarea maxlength="500" cols="45" rows="5" name="textfield">${feedback}</textarea>
					<button type="submit" name="submit" value="Submit">Sla
						Feedback op</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="/leraar/DeleteFeedback.do" method="post">
					<button type="submit" name="submit" value="Submit">Verwijder
						Feedback</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>