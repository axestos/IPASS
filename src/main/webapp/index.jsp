<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Inloggen</title>

</head>
<body>
	<h1>OBS de Waayer - Login</h1>
	<br>
	<img src="http://waayer-tiel.nl/file/50174">
	<div>
		<table>
			<form action="LoginServlet.do" method="post">
				<tr>
					<td>Gebruikersnaam:</td>
					<td><input type="text" name="gebruikersnaam_login"
						value="${cookie.gebruikersnaam.value}"></td>
				</tr>
				<tr>
					<td>Wachtwoord:</td>
					<td><input type="password" name="wachtwoord_login"></td>
				</tr>
				<tr>
					<td><button type="submit" name="submit" value="Submit">Log-In</button></td>
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
		</table>
	</div>


</body>
</html>
