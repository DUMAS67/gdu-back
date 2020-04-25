package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dangers {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** Id de la liste des dangers */

	private String nom;

	/** Nom du Danger */

	public Dangers() {
	}

	public Dangers(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
