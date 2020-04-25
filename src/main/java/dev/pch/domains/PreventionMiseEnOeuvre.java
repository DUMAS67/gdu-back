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
public class PreventionMiseEnOeuvre {

	@Id
	private int id;
	/** id de la liste de préventionà mettre en oeuvre */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "graviteOeuvre_id")
	private Gravite graviteOeuvre;
	/** indique la gravité du risque pour la prévention à mettre en oeuvre */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "frequenceOeuvre_id")
	private Frequence frequenceOeuvre;
	/** indique la gravité du risque pour la prévention à mettre en oeuvre */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "CriticiteOeuvre_id")
	private Criticite criticiteOeuvre;
	/** indique la gravité du risque pour la prévention à mettre en oeuvre */
	private String details;

	public PreventionMiseEnOeuvre() {
	}

	public PreventionMiseEnOeuvre(int id, Gravite graviteOeuvre, Frequence frequenceOeuvre, Criticite criticiteOeuvre,
			String details) {
		super();
		this.id = id;
		this.graviteOeuvre = graviteOeuvre;
		this.frequenceOeuvre = frequenceOeuvre;
		this.criticiteOeuvre = criticiteOeuvre;
		this.details = details;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the graviteOeuvre
	 */
	public Gravite getGraviteOeuvre() {
		return graviteOeuvre;
	}

	/**
	 * @param graviteOeuvre
	 *            the graviteOeuvre to set
	 */
	public void setGraviteOeuvre(Gravite graviteOeuvre) {
		this.graviteOeuvre = graviteOeuvre;
	}

	/**
	 * @return the frequenceOeuvre
	 */
	public Frequence getFrequenceOeuvre() {
		return frequenceOeuvre;
	}

	/**
	 * @param frequenceOeuvre
	 *            the frequenceOeuvre to set
	 */
	public void setFrequenceOeuvre(Frequence frequenceOeuvre) {
		this.frequenceOeuvre = frequenceOeuvre;
	}

	/**
	 * @return the criticiteOeuvre
	 */
	public Criticite getCriticiteOeuvre() {
		return criticiteOeuvre;
	}

	/**
	 * @param criticiteOeuvre
	 *            the criticiteOeuvre to set
	 */
	public void setCriticiteOeuvre(Criticite criticiteOeuvre) {
		this.criticiteOeuvre = criticiteOeuvre;
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

	/** détails de la prévention à mettre en oeuvre */

}
