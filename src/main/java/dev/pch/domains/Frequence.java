/**
 * 
 */
package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Thierry Dumas
 *
 */

/* Définition de la Table FREQUENCE */

@Entity
public class Frequence {

	@Id
	private Integer id;
	/** Identifiant unique */
	private Integer valeur;

	/** valeur de Fréquence */

	public Frequence() {
	}

	public Frequence(Integer id, Integer valeur) {
		super();
		this.id = id;
		this.valeur = valeur;

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the valeur1
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur1
	 *            the valeur1 to set
	 */
	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

}
