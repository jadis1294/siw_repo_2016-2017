package it.uniroma3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controllerDati")
public class ControllerDati extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome= (String)request.getParameter("nome").toUpperCase();
		String cognome=(String)request.getParameter("cognome").toUpperCase();
		Integer matricola=Integer.parseInt(request.getParameter("matricola"));
		
		Studente studente=new Studente(nome, cognome, matricola);
		
		//metto i valori nella sessione
		HttpSession session= request.getSession();
		session.setAttribute("studente",studente);
		
		//inoltro la richiesta
		ServletContext application= getServletContext();
		RequestDispatcher rd= application.getRequestDispatcher("/confermaDati");
		rd.forward(request, response);
		return;
		
	}
}
