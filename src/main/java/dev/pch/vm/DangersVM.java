/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Dangers;

/**
 * @author Thierry Dumas
 *
 */
public class DangersVM {

	private int id;
	private String nom;

	public DangersVM(Dangers dg) {
		super();
		this.id = dg.getId();
		this.nom = dg.getNom();
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
