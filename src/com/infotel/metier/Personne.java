package com.infotel.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  // type d'héritage
@DiscriminatorColumn(name="TYPE_PERS")		         // nom de la colonne de discrimination
@DiscriminatorValue("PER")							 // valeur de la colonne
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // a commenter si TALBE_PER_CLASS
	private int id;
	private String nom;
	private String prenom;
	private int age;
	@ManyToOne//cascade={CascadeType.PERSIST})
	private Adresse adresse;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Connexion connexion;
	@ManyToMany
	private List<Club> clubs = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Connexion getConnexion() {
		return connexion;
	}
	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}
	public List<Club> getClubs() {
		return clubs;
	}
	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ",\t nom=" + nom + ",\t prenom=" + prenom + ",\t age=" + age + "]";
	}
	
	
}
