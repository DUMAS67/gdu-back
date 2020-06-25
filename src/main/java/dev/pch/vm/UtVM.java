/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Ut;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe qui permet de construire un objet UtVM qui récupère les informations
 * d'un objet UT. Cette recopie assure une sécurité dans le cas d'objet avec
 * clef étrangères qui renseignent d'autres objets succeptibles de changer
 */
public class UtVM {

	private int id;
	// récupère l'identifiant de l'enregistrement de la table UT
	private String nom;
	// récupère la valeur nom

	public UtVM(Ut ut) {
		super();
		this.id = ut.getId();
		this.nom = ut.getNom();
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
