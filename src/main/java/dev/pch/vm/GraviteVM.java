/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Gravite;

/**
 * @author Thierry Dumas
 *
 */
public class GraviteVM {

	private int id;
	private int valeur;

	public GraviteVM(Gravite g) {
		super();
		this.id = g.getId();
		this.valeur = g.getValeur();
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
