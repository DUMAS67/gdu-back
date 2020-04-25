/**
 * 
 */
package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Thierry Dumas
 *
 */

@Entity
public class Duer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** id de chaque ligne de l'EvRP du DUER */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ut_id")
	private Ut uniteLieu;
	/** renseigne l'Unité de Lieu */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "lieu_id")
	private Lieu lieu;
	/** renseigne sur le lieu ùu se trouve le risque */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "danger_id")
	private Dangers danger;

	/** décrit le danger à analyser */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "risque_id")
	private Risques risque;
	/** renseigne sur le risque engendré */
	@NotNull
	@OneToOne
	@JoinColumn(name = "prevExistante_id")
	private PreventionExistante prevExistante;
	/** décrit la prévention existante */
	@NotNull
	@OneToOne
	@JoinColumn(name = "prevOeuvre_id")
	private PreventionMiseEnOeuvre prevMiseEnOeuvre;
	/** décrit la prévention à mettre en oeuvre */
	@NotNull
	@OneToOne
	@JoinColumn(name = "pas_id")
	private PlanActionSpecifique pas;

	/** décrit le plan d'action spécifique */

	public Duer() {
	}

	public Duer(int id, Ut uniteLieu, Lieu lieu, Dangers danger, Risques risque, PreventionExistante prevExistante,
			PreventionMiseEnOeuvre prevMiseEnOeuvre, PlanActionSpecifique pas) {
		super();
		this.id = id;
		this.uniteLieu = uniteLieu;
		this.lieu = lieu;
		this.danger = danger;
		this.risque = risque;
		this.prevExistante = prevExistante;
		this.prevMiseEnOeuvre = prevMiseEnOeuvre;
		this.pas = pas;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the uniteLieu
	 */
	public Ut getUniteLieu() {
		return uniteLieu;
	}

	/**
	 * @param uniteLieu
	 *            the uniteLieu to set
	 */
	public void setUniteLieu(Ut uniteLieu) {
		this.uniteLieu = uniteLieu;
	}

	/**
	 * @return the lieu
	 */
	public Lieu getLieu() {
		return lieu;
	}

	/**
	 * @param lieu
	 *            the lieu to set
	 */
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	/**
	 * @return the danger
	 */
	public Dangers getDanger() {
		return danger;
	}

	/**
	 * @param danger
	 *            the danger to set
	 */
	public void setDanger(Dangers danger) {
		this.danger = danger;
	}

	/**
	 * @return the risque
	 */
	public Risques getRisque() {
		return risque;
	}

	/**
	 * @param risque
	 *            the risque to set
	 */
	public void setRisque(Risques risque) {
		this.risque = risque;
	}

	/**
	 * @return the prevExistante
	 */
	public PreventionExistante getPrevExistante() {
		return prevExistante;
	}

	/**
	 * @param prevExistante
	 *            the prevExistante to set
	 */
	public void setPrevExistante(PreventionExistante prevExistante) {
		this.prevExistante = prevExistante;
	}

	/**
	 * @return the prevMiseEnOeuvre
	 */
	public PreventionMiseEnOeuvre getPrevMiseEnOeuvre() {
		return prevMiseEnOeuvre;
	}

	/**
	 * @param prevMiseEnOeuvre
	 *            the prevMiseEnOeuvre to set
	 */
	public void setPrevMiseEnOeuvre(PreventionMiseEnOeuvre prevMiseEnOeuvre) {
		this.prevMiseEnOeuvre = prevMiseEnOeuvre;
	}

	/**
	 * @return the pas
	 */
	public PlanActionSpecifique getPas() {
		return pas;
	}

	/**
	 * @param pas
	 *            the pas to set
	 */
	public void setPas(PlanActionSpecifique pas) {
		this.pas = pas;
	}

}
