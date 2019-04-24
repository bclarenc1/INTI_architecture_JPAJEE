package com.infotel.service;

import java.util.List;

import com.infotel.dao.DaoImpl;
import com.infotel.dao.Idao;
import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class ServiceImpl implements Iservice {

	private Idao dao = new DaoImpl();

	@Override
	public int ajouterPersonne(Personne p) {
		return dao.ajouterPersonne(p);
	}

	@Override
	public Personne getPersonne(int id) {
		return dao.getPersonne(id);
	}

	@Override
	public Personne findPersonne(int id) {
		return dao.findPersonne(id);
	}

	@Override
	public int supprimerPersonne(Personne p) {
		return dao.supprimerPersonne(p);
	}

	@Override
	public int modifierPersonne(Personne p) {
		return dao.modifierPersonne(p);
	}

	@Override
	public List<Personne> findAllPeople() {
		return dao.findAllPeople();
	}

	@Override
	public List<Personne> searchPeopleFromKW(String kw) {
		return dao.searchPeopleFromKW(kw);
	}

	@Override
	public int ajouterAdresse(Adresse a) {
		return dao.ajouterAdresse(a);
	}

	@Override
	public Adresse getAdresse(int id) {
		return dao.getAdresse(id);
	}

	@Override
	public Adresse findAdresse(int id) {
		return dao.findAdresse(id);
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		return dao.supprimerAdresse(a);
	}

	@Override
	public int modifierAdresse(Adresse a) {
		return dao.modifierAdresse(a);
	}

	@Override
	public List<Adresse> findAllAddresses() {
		return dao.findAllAddresses();
	}

	@Override
	public List<Adresse> searchAddressesFromKW(String kw) {
		return dao.searchAddressesFromKW(kw);
	}

	@Override
	public int ajouterConnexion(Connexion c) {
		return dao.ajouterConnexion(c);
	}

	@Override
	public Connexion getConnexion(int id) {
		return dao.getConnexion(id);
	}

	@Override
	public Connexion findConnexion(int id) {
		return dao.findConnexion(id);
	}

	@Override
	public int supprimerConnexion(Connexion c) {
		return dao.supprimerConnexion(c);
	}

	@Override
	public int modifierConnexion(Connexion c) {
		return dao.modifierConnexion(c);
	}

	@Override
	public List<Connexion> findAllConnections() {
		return dao.findAllConnections();
	}

	@Override
	public List<Connexion> searchConnectionsFromKW(String kw) {
		return dao.searchConnectionsFromKW(kw);
	}

	@Override
	public List<Personne> findAllPersonnesConnexion() {
		return dao.findAllPersonnesConnexion();
	}

	@Override
	public List<Personne> findAllPersonnesAdresse() {
		return dao.findAllPersonnesAdresse();
	}

}
