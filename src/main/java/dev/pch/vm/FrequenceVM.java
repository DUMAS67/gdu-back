/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Frequence;

/**
 * @author Thierry Dumas
 *
 */
/*
 * Classe qui permet de construire un objet FrequenceVM qui récupère les
 * informations d'un objet Frequence. Cette recopie assure une sécurité dans le
 * cas d'objet avec clef étrangères qui renseignent d'autres objets succeptibles
 * de changer
 */
public class FrequenceVM {
	private int id;
	// identifiant d'un enregistrement de la table FREQUENCE
	private int valeur;
	// récupère la valeur de l'enregistrement

	public FrequenceVM(Frequence f) {
		super();
		this.id = f.getId();
		this.valeur = f.getValeur();
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
