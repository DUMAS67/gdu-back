/**
 * 
 */
package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Thierry Dumas
 *
 */

/* Définition de la Table ACTIVITES */

@Entity
public class Activites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** Identifiant de l'activité */
	private String nom;

	/** Nom de l'activité */

	public Activites() {
	}

	public Activites(String nom) {
		super();
		this.nom = nom;
	}

	public Activites(Integer id, String nom) {
		super();
		this.id = id;
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
