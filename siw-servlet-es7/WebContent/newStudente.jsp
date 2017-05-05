<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="foglioStile.css" />
<title>Nuovo studente</title>
</head>
<body>
	<hr>
	<h1>Nuovo studente</h1>
	<hr>
	<form action="studenteController" method="get">
		<div align="left">
			<p>
				Nome:<input type="text" name="nome" value="${nome}"/>${ErrorNome}
			</p>
			<p>
				Cognome:<input type="text" name="cognome" value="${cognome}"/>${ErrorCognome}
			</p>
			<p>
				Matricola:<input type="text" name="matricola" value="${matricola}"size="6" maxlength="6" required />
			</p>
			<input type="submit" value="INVIA" />
		</div>
	</form>
</body>
</html>