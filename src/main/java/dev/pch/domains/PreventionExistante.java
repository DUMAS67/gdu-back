/**
 * 
 */
package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Thierry Dumas
 *
 */
@Entity
public class PreventionExistante {

	@Id
	private int id;
	/** id de la liste de prévention */

	@NotNull
	@ManyToOne
	@JoinColumn(name = "gravite_id")
	private Gravite gravite;
	/** indique la gravité du risque pour la prévention existante */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "frequence_id")
	private Frequence frequence;
	/** indique la fréquence du risque pour la prévention existante */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "criticite_id")
	private Criticite criticite;
	/** indique la criticié du risque pour la prévention existante */
	private String details;

	/** décrit les détails de la prévention existante */

	public PreventionExistante() {
	}

	public PreventionExistante(int id, Gravite gravite, Frequence frequence, Criticite criticite, String details) {
		super();
		this.id = id;
		this.gravite = gravite;
		this.frequence = frequence;
		this.criticite = criticite;
		this.details = details;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the gravite
	 */
	public Gravite getGravite() {
		return gravite;
	}

	/**
	 * @param gravite
	 *            the gravite to set
	 */
	public void setGravite(Gravite gravite) {
		this.gravite = gravite;
	}

	/**
	 * @return the frequence
	 */
	public Frequence getFrequence() {
		return frequence;
	}

	/**
	 * @param frequence
	 *            the frequence to set
	 */
	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}

	/**
	 * @return the criticite
	 */
	public Criticite getCriticite() {
		return criticite;
	}

	/**
	 * @param criticite
	 *            the criticite to set
	 */
	public void setCriticite(Criticite criticite) {
		this.criticite = criticite;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}