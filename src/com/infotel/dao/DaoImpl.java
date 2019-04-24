package com.infotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class DaoImpl implements Idao {

	EntityManagerFactory emf;  // unite de persistance
	EntityManager em;	       // porteur de requete
	
	@Override
	public int ajouterPersonne(Personne p) {
		// ouvertures de l'up, du pr et de la transaction
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			// 1. débuter la transaction
			// 2. effectuer la requête
			// 3. valider la transaction
			// 4. fermer l'unité de persistance
			tx.begin();
			em.persist(p);
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annulation de la transation
			System.out.println("ajouterpersonne exception1");
			tx.rollback();
			e.printStackTrace();
			System.out.println("ajouterpersonne exception2");
		}
		
		return p.getId();
	}

	@Override
	public Personne getPersonne(int id) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Personne p = new Personne();
		try {
			p = em.getReference(Personne.class, id);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	@Override
	public Personne findPersonne(int id) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Personne p = new Personne();
		try {
			p = em.find(Personne.class, id);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public int supprimerPersonne(Personne p) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		System.out.println("dans supp");
		try {
			tx.begin();
			em.remove(p);
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annulation de la transation
			tx.rollback();
			e.printStackTrace();
		}
		
		return p.getId();
	}

	@Override
	public int modifierPersonne(Personne p) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			System.out.println("in modif try 1");
			em.merge(p);
			System.out.println("in modif try 2");
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("in modif catch");
			e.printStackTrace();
		}
		
		return p.getId();
	}

	@Override
	public List<Personne> findAllPeople() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> list = new ArrayList<Personne>();
		
		try { 
			q = em.createQuery("SELECT p from Personne p");
			list = q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}

	@Override
	public List<Personne> searchPeopleFromKW(String kw) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> list = new ArrayList<Personne>();
		
		try {
			q = em.createQuery("select u from Personne u where lower(nom) like lower(:lenom)");
			q.setParameter("lenom", "%"+kw+"%");
			list = q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}


	@Override
	public int ajouterAdresse(Adresse a) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(a);
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			tx.rollback();
		}
		
		return a.getIdAdresse();
	}
	

	@Override
	public Adresse getAdresse(int id) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Adresse a = new Adresse();
		try {
			a = em.getReference(Adresse.class, id);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
	

	@Override
	public Adresse findAdresse(int id) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Adresse a = new Adresse();
		try {
			a = em.find(Adresse.class, id);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
	

	@Override
	public int supprimerAdresse(Adresse a) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.remove(a);
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			tx.rollback();
		}
		
		return a.getIdAdresse();
	}
	

	@Override
	public int modifierAdresse(Adresse a) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.merge(a);
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			tx.rollback();
		}
		
		return a.getIdAdresse();
	}
	

	@Override
	public List<Adresse> findAllAddresses() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Adresse> list = new ArrayList<Adresse>();
		
		try {
			q = em.createQuery("SELECT a from Adresse a");
			list = q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	

	@Override
	public List<Adresse> searchAddressesFromKW(String kw) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Adresse> list = new ArrayList<Adresse>();
		
		try {
			q = em.createQuery("select a from Adresse a where lower(ville) like lower(:var)");
			q.setParameter("var", "%"+kw+"%");
			list = q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}

	@Override
	public int ajouterConnexion(Connexion c) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(c);
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			tx.rollback();
		}
		
		return c.getIdConnexion();
	}
	

	@Override
	public Connexion getConnexion(int id) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Connexion c = new Connexion();
		try {
			c = em.getReference(Connexion.class, id);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	

	@Override
	public Connexion findConnexion(int id) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Connexion c = new Connexion();
		try {
			c = em.find(Connexion.class, id);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	

	@Override
	public int supprimerConnexion(Connexion c) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.remove(c);
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			tx.rollback();
		}
		
		return c.getIdConnexion();
	}
	

	@Override
	public int modifierConnexion(Connexion c) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.merge(c);
			tx.commit();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			tx.rollback();
		}
		
		return c.getIdConnexion();
	}
	

	@Override
	public List<Connexion> findAllConnections() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Connexion> list = new ArrayList<Connexion>();
		
		try {
			q = em.createQuery("select c from Connexion c");
			list = q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	

	@Override
	public List<Connexion> searchConnectionsFromKW(String kw) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Connexion> list = new ArrayList<Connexion>();
		
		try {
			q = em.createQuery("select c from Connexion c where lower(login) like lower(concat('%',:var,'%'))");
			q.setParameter("var", kw);
			list = q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}

	
	@Override
	public List<Personne> findAllPersonnesConnexion() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> list = new ArrayList<Personne>();
		
		try {
			q = em.createQuery("SELECT p from Personne p JOIN p.connexion");
			list = q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
	@Override
	public List<Personne> findAllPersonnesAdresse() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q = null;
		List<Personne> list = new ArrayList<Personne>();
		
		try {
			q = em.createQuery("SELECT p from Personne p FULL JOIN p.adresse");  // equijointure
			list = q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
	
}
