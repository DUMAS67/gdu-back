/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Criticite;
import dev.pch.domains.Frequence;
import dev.pch.domains.Gravite;
import dev.pch.domains.PreventionExistante;

/**
 * @author Thierry Dumas
 *
 */

public class PreventionExistanteVM {

	private int id;

	private Gravite gravite;
	private Frequence frequence;
	private Criticite criticite;
	private String details;

	public PreventionExistanteVM(PreventionExistante prev) {
		super();
		this.id = prev.getId();
		this.gravite = prev.getGravite();
		this.frequence = prev.getFrequence();
		this.criticite = prev.getCriticite();
		this.details = prev.getDetails();
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
