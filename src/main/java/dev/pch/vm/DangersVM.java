/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Dangers;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe qui permet de construire un objet DangerVM qui récupère les
 * informations d'un objet Danger. Cette recopie assure une sécurité dans le cas
 * d'objet avec clef étrangères qui renseignent d'autres objets succeptibles de
 * changer
 */
public class DangersVM {

	private int id;
	// récupère l'identifiant de la table DANGERS
	private String nom;

	// récupère la valeur de l'enregistrement de la table DANGERS
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
