package com.infotel.service;

import java.util.List;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public interface Iservice {
	public int ajouterPersonne(Personne p);
	public Personne getPersonne(int id);
	public Personne findPersonne(int id);
	public int supprimerPersonne(Personne p);
	public int modifierPersonne(Personne p);
	
	public List<Personne> findAllPeople();
	public List<Personne> searchPeopleFromKW(String kw);
	
	public int ajouterAdresse(Adresse a);
	public Adresse getAdresse(int id);
	public Adresse findAdresse(int id);
	public int supprimerAdresse(Adresse a);
	public int modifierAdresse(Adresse a);
	
	public List<Adresse> findAllAddresses();
	public List<Adresse> searchAddressesFromKW(String kw);

	public int ajouterConnexion(Connexion c);
	public Connexion getConnexion(int id);
	public Connexion findConnexion(int id);
	public int supprimerConnexion(Connexion c);
	public int modifierConnexion(Connexion c);
	
	public List<Connexion> findAllConnections();
	public List<Connexion> searchConnectionsFromKW(String kw);
	
	public List<Personne> findAllPersonnesConnexion();
	public List<Personne> findAllPersonnesAdresse();

}
