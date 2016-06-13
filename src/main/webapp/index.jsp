<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Inloggen</title>
<style type="text/css">
h2{
	font-size: 225%;
}

h1 {
 font-size: 250%;
}
input {
	border: 0;
	outline: 0;
	background: transparent;
	border-bottom: 1px solid black;
	width: 250px;
	font-size : 125%;
}

td.data {
	font-size : 125%;
}

button {
	font-size: 105%;
}
</style>
</head>
<body>
	<h1>OBS de Waayer - Login</h1>
	<br>
	<img src="http://waayer-tiel.nl/file/50174">
	<div>
		<table>
			<form action="/LoginServlet.do" method="post">
				<tr>
					<td class="data">Gebruikersnaam:</td>
					<td><input type="text" name="gebruikersnaam_login"
						value="${cookie.gebruikersnaam.value}"></td>
				</tr>
				<tr>
					<td class="data">Wachtwoord:</td>
					<td><input maxlength="20" type="password" name="wachtwoord_login"></td>
				</tr>
				<tr>
					<td><button type="submit" name="submit" value="Submit">Log-In</button></td>
				<td class="data">
						<%
							Object msgs = request.getAttribute("msgs");
							if (msgs != null) {
								out.println(msgs);
							}
						%>
					</td>
				</tr>
				</form>
				<form action="http://ipass-v1wackw.rhcloud.com/verander.jsp"><tr><td><button type="submit">Wachtwoord weizigen</button></td></tr></form>
		
		</table>
	</div>


</body>
</html>
