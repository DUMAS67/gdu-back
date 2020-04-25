/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Lieu;

/**
 * @author Thierry Dumas
 *
 */
public class LieuVM {
	private int id;
	private String nom;

	public LieuVM(Lieu l) {
		super();
		this.id = l.getId();
		this.nom = l.getNom();

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
