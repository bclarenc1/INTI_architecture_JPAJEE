package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Iservice service = new ServiceImpl();

    public ServletPersonne() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id;
		String nom;
		String prenom;
		int age;
		int adr;
		String login;
		String pwd;
		
		if (request.getParameter("nom") != null) {
			Personne p = new Personne();
			Connexion c = new Connexion();

			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			age = Integer.parseInt(request.getParameter("age"));
			adr = Integer.parseInt(request.getParameter("idadresse")); // idadresse defini par le select dans la JSP
			login = request.getParameter("login");
			pwd = request.getParameter("pwd");

			c.setLogin(login);
			c.setMdp(pwd);
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setAge(age);
			p.setConnexion(c);
			
			if (adr!=0) {
				p.setAdresse(service.getAdresse(adr));
			}
		
			if (request.getParameter("ajouter") != null) {
				service.ajouterPersonne(p);
			} else if (request.getParameter("modifier") != null) {
				id = Integer.parseInt(request.getParameter("id"));				
				p.setId(id);
				service.modifierPersonne(p);
			}
		}

		request.setAttribute("people", service.findAllPeople());
		request.setAttribute("adresses", service.findAllAddresses());
		request.getRequestDispatcher("personnes.jsp").forward(request, response);
	}

	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
