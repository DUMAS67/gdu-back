/**
 * 
 */
package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Stagiaire
 *
 */

/* Définition de la Table UT */

@Entity
public class Ut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** id de la liste des Unité de Travail */
	private String nom;

	/** nom de l'Unité de travail */

	public Ut() {
	}

	public Ut(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Ut(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}