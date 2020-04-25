/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Criticite;
import dev.pch.domains.Frequence;
import dev.pch.domains.Gravite;
import dev.pch.domains.PreventionMiseEnOeuvre;

/**
 * @author Thierry Dumas
 *
 */
public class PreventionMiseEnOeuvreVM {

	private int id;
	private Gravite graviteOeuvre;
	private Frequence frequenceOeuvre;
	private Criticite criticiteOeuvre;
	private String details;

	public PreventionMiseEnOeuvreVM(PreventionMiseEnOeuvre prevO) {
		super();
		this.id = prevO.getId();
		this.graviteOeuvre = prevO.getGraviteOeuvre();
		this.frequenceOeuvre = prevO.getFrequenceOeuvre();
		this.criticiteOeuvre = prevO.getCriticiteOeuvre();
		this.details = prevO.getDetails();
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

}
