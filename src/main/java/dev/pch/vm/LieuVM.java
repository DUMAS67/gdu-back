/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Lieu;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe qui permet de construire un objet LieuVM qui récupère les informations
 * d'un objet Lieu. Cette recopie assure une sécurité dans le cas d'objet avec
 * clef étrangères qui renseignent d'autres objets succeptibles de changer
 */

public class LieuVM {
	private int id;
	// identifiant de l'enregistrement de la table LIEU
	private String nom;
	// récupère la valeur de l'eenregistrement

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
