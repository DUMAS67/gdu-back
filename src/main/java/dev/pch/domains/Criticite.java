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
public class Criticite {

	@Id
	private int id;
	/** Identifiant unique */
	private int valeur;

	/** Premère valeur = Première valeur Fréquence x Première valeur Gravité */

	public Criticite() {
	}

	public Criticite(int id, int valeur) {
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
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur
	 *            the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
