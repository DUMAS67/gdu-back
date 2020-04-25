/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Risques;

/**
 * @author Thierry Dumas
 *
 */
public class RisquesVM {

	private int id;
	private String nom;

	public RisquesVM(Risques ris) {
		super();
		this.id = ris.getId();
		this.nom = ris.getNom();

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
