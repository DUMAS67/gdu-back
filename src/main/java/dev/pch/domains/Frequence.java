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
@Entity
public class Frequence {

	@Id
	private int id;
	/** Identifiant unique */
	private int valeur;

	/** Premère valeur = valeur de Fréquence */

	public Frequence() {
	}

	public Frequence(int id, int valeur) {
		super();
		this.id = id;
		this.valeur = valeur;

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
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
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
