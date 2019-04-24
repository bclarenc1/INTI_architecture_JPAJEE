package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/ModifierPersonne")
public class ModifierPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Iservice service = new ServiceImpl();   
	
    public ModifierPersonne() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cetteid = Integer.parseInt(request.getParameter("idPersonne")); // idPersonne est defini par le bouton dans la JSP
		Personne p = service.findPersonne(cetteid);
		
		request.setAttribute("id", p.getId());
		request.setAttribute("nom", p.getNom());
		request.setAttribute("prenom", p.getPrenom());
		request.setAttribute("age", p.getAge());
		request.setAttribute("login", p.getConnexion().getLogin());
		request.setAttribute("pwd", p.getConnexion().getMdp());
		
		request.setAttribute("people", service.findAllPeople());
		request.setAttribute("adresses", service.findAllAddresses());
		request.getRequestDispatcher("personnes.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
