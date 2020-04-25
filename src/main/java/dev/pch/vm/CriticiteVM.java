/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Criticite;

/**
 * @author Thierry Dumas
 *
 */
public class CriticiteVM {
	private int id;
	private int valeur;

	public CriticiteVM(Criticite c) {
		super();
		this.id = c.getId();
		this.valeur = c.getValeur();
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
