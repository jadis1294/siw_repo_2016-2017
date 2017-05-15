<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="it.uniroma3.servlet.Studente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="foglioStile.css" />
<title>studente</title>
</head>
<body>
	<h1>È stato registrato il seguente studente</h1>
	<%
		Studente studente = (Studente)session.getAttribute("studente");
	%>
	<ul>
		<li>Nome: <b>${studente.nome }</b></li>
		<li>Cognome: <b>${studente.cognome}</b></li>
		<li>Matricola: <b>${studente.matricola}</b></li>
	</ul>
	<hr>

	<hr>
	<h2>netInfo</h2>
	${header["host"]};
	${header["user-agent"]};
</body>
</html>