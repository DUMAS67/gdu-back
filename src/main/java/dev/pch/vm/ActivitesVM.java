/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Activites;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe qui permet de construire un objet ActivitesVM qui récupère les
 * informations d'un objet Activites Cette recopie assure une sécurité dans le
 * cas d'objet avec clef étrangères qui renseignent d'autres objets succeptibles
 * de changer
 */
public class ActivitesVM {

	private int id;
	// identifiant récupéré de la table ACTIVITES
	private String nom;
	// Valeur récupérée de la table ACTIVITES

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
