/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Creation;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe qui permet de construire un objet CreationVM qui récupère les
 * informations d'un objet Creation. Cette recopie assure une sécurité dans le
 * cas d'objet avec clef étrangères qui renseignent d'autres objets succeptibles
 * de changer
 */
public class CreationVM {

	private int id;
	// identifiant récupéré de l'enregistrement de la table CREATION
	private String date;
	// Valeur récupérée de l'enregistrement de la table CREATION

	public CreationVM(Creation creat) {

		this.id = creat.getId();
		this.date = creat.getDate();
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
