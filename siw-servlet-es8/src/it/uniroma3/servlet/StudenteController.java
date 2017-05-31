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

@WebServlet("/studenteController")
public class StudenteController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer matricola = Integer.parseInt(request.getParameter("matricola"));
		String nome= (String)request.getParameter("nome");
		String cognome= (String)request.getParameter("cognome");
		String nextPage;
		HttpSession session= request.getSession();
		
		
		if(!nome.equals("") && !cognome.equals("") && nome!=null && cognome!=null){
			Studente studente= new Studente(nome,cognome,matricola);
			session.setAttribute("studente", studente);
			nextPage="/studente.jsp";
		}
		else {
			if(nome.equals("") || nome==null){
				request.setAttribute("ErrorNome", "Campo nome obbligatorio");
				session.setAttribute("cognome", cognome);
			}
			if(cognome.equals("") || cognome == null) {
				request.setAttribute("ErrorCognome", "Campo cognome obbligatorio");
				session.setAttribute("nome", nome);
			}
			nextPage="/newStudente.jsp";
			session.setAttribute("matricola", matricola);
		}

		//inoltro
		ServletContext application= request.getServletContext();
		RequestDispatcher rd= application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
	}
}
