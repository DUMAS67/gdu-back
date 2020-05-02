/**
 * 
 */
package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Thierry Dumas
 *
 */
@Entity
public class Gravite {

	@Id
	private Integer id;
	/** id unique de la table de valeur de Gravité */
	private Integer valeur;

	public Gravite() {
	}

	public Gravite(Integer id, Integer valeur) {
		super();
		this.id = id;
		this.valeur = valeur;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the valeur
	 */
	public Integer getValeur() {
		return valeur;
	}

	/**
	 * @param valeur
	 *            the valeur to set
	 */
	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

}
