/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Activites;

/**
 * @author Thierry Dumas
 *
 */
public class ActivitesVM {

	private int id;
	private String nom;

	public ActivitesVM(Activites a) {
		super();
		this.id = a.getId();
		this.nom = a.getNom();

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
