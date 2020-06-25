/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Risques;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe qui permet de construire un objet RisqueVM qui récupère les
 * informations d'un objet Risque. Cette recopie assure une sécurité dans le cas
 * d'objet avec clef étrangères qui renseignent d'autres objets succeptibles de
 * changer
 */
public class RisquesVM {

	private int id;
	// récupère l'identifiant de l'enregistrement de la table RISQUES
	private String nom;
	// récupère la valeur nom

	public RisquesVM(Risques ris) {
		super();
		this.id = ris.getId();
		this.nom = ris.getNom();

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
