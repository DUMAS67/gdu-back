/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Frequence;

/**
 * @author Thierry Dumas
 *
 */
public class FrequenceVM {
	private int id;
	private int valeur;

	public FrequenceVM(Frequence f) {
		super();
		this.id = f.getId();
		this.valeur = f.getValeur();
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
