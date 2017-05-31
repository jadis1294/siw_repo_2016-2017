<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.uniroma3.servlet.Studente" errorPage="errore.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="foglioStile.css" />
<title>Mostra Dati</title>
</head>
<body>
	<h1>È stato registrato il seguente studente</h1>
	<%
		Studente studente = (Studente) session.getAttribute("studente");
	%>
	<ul>
		<li>Nome: <b><%=studente.getNome()%></b></li>
		<li>Cognome: <b><%=studente.getCognome()%></b></li>
		<li>Matricola: <b><%=studente.getMatricola()%></b></li>
	</ul>
	<hr>

	<hr>
	<h2>netInfo</h2>
	<%
		String address = (String) request.getRemoteAddr();
		String host = (String) request.getRemoteHost();
		String userAgent = request.getHeader("User-Agent");
	%>
	<br />IP:
	<b><%=address%></b>
	<br />Host:
	<b><%=host%></b>
	<br />userAgent:
	<b><%=userAgent%></b>
</body>
</html>