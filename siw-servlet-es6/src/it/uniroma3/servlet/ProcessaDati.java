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

@WebServlet("/processaDati")
public class ProcessaDati extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gestione della RICHIESTA
		Studente studente;

		Integer matricola = Integer.parseInt(request.getParameter("matricola"));

		// leggo e manipolo i parametri  
		studente = new Studente(
				request.getParameter("nome").toUpperCase(), 
				request.getParameter("cognome").toUpperCase(),
				matricola); 

		HttpSession session= request.getSession();
		session.setAttribute("studente", studente);
		
		ServletContext application= request.getServletContext();
		RequestDispatcher rd= application.getRequestDispatcher("/ConfermaDati.jsp");
		rd.forward(request, response);
		return;

	}

}
