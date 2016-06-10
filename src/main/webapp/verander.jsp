<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wachtwoord weizigen</title>
<style type="text/css">
input {
	border: 0;
	outline: 0;
	background: transparent;
	border-bottom: 1px solid black;
	width: 150px;
}
</style>
</head>
<body>

	<h1>OBS de Waayer - Wachtwoord Weizigen</h1>
	<br>
	<img src="http://waayer-tiel.nl/file/50174">
	<div>
		<table>
			<form action="WachtwoordServlet.do" method="post">
				<tr>
					<td>Gebruikersnaam:</td>
					<td><input type="text" name="gebruikersnaam_verander"></td>
				</tr>
				<tr>
					<td>Huidig wachtwoord:</td>
					<td><input maxlength="20" type="password" name="wachtwoord_verander"></td>
				</tr>
				<tr>
					<td>Nieuw wachtwoord:</td>
					<td><input maxlength="20" type="password" name="wachtwoord_nieuw"></td><td>(Maximaal 20 tekens)</td>

				<tr>
					<td>Herhaal nieuw wachtwoord:</td>
					<td><input maxlength="20" type="password" name="wachtwoord_herhaal"></td>
				</tr>
				<tr>
					<td><button type="submit" name="submit" value="Submit">Verander wachtwoord</button></td>
					<td>
						<%
							Object msgs = request.getAttribute("msgs");
							if (msgs != null) {
								out.println(msgs);
							}
						%>
					</td>
				</tr>
			</form>
			<form action="http://localhost:8080/ipass/index.jsp">
				<tr>
					<td><button type="submit">Login Pagina</button></td>
				</tr>
			</form>
		</table>
	</div>


</body>
</html>