/**
 * 
 */
package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Thierry Dumas
 *
 */
@Entity
public class Risques {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	/** id de la liste des risques */
	private String nom;

	/** nom du risque */

	public Risques() {
	}

	public Risques(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
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
