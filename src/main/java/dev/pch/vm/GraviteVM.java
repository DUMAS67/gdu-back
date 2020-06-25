/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Gravite;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe qui permet de construire un objet GraviteVM qui récupère les
 * informations d'un objet Gravite. Cette recopie assure une sécurité dans le
 * cas d'objet avec clef étrangères qui renseignent d'autres objets succeptibles
 * de changer
 */

public class GraviteVM {

	private int id;
	// identifiant de l'enregistrement de la table GRAVITE
	private int valeur;
	// récupère la valeur de l'enregistrement

	public GraviteVM(Gravite g) {
		super();
		this.id = g.getId();
		this.valeur = g.getValeur();
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
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur
	 *            the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
