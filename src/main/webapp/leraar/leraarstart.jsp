<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="service.UserService"%>
<%@ page import="service.User" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leraar hoofdpagina</title>
</head>
<body>
<h1>OBS de Waayer - Leraar</h1>
<h2> Welkom, ${loggedUser.name}</h2>
<form action="/LogoutServlet.do" method="post">
		<button type="submit" name="submit" value="Submit">Log-Out</button>
	</form>
</body>
</html>