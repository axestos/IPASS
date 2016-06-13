<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	HttpSession ses = request.getSession();
	ses.getAttribute("gekozenOpdracht");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Keuze</title>
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
</style>
</head>
<body>
	<h1>OBS de Waayer - Feedback/Opdrachten</h1>
	<h1>${gekozenOpdracht}</h1>
	<br>
	<form
		action="http://ipass-v1wackw.rhcloud.com/leerling/leerlingopdrachten.jsp">
		<button type="submit">Andere opdracht kiezen</button></form>
		<h2>Maak je keuze:</h2>
		<form
			action="http://ipass-v1wackw.rhcloud.com/leerling/leerlinghuiswerk.jsp">
			<button>Ga door naar huiswerk</button>
		</form>
		<form action="/leerling/GetFeedbackServlet.do" method="post">
			<button>Ga door naar feedback</button>
		</form>
</body>
</html>