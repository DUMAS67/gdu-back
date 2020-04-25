/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Dangers;
import dev.pch.domains.Duer;
import dev.pch.domains.Lieu;
import dev.pch.domains.PlanActionSpecifique;
import dev.pch.domains.PreventionExistante;
import dev.pch.domains.PreventionMiseEnOeuvre;
import dev.pch.domains.Risques;
import dev.pch.domains.Ut;

/**
 * @author Thierry Dumas
 *
 */
public class DuerVM {

	private int id;
	private Ut uniteLieu;
	private Lieu lieu;
	private Dangers danger;
	private Risques risque;
	private PreventionExistante prevExistante;
	private PreventionMiseEnOeuvre prevMiseEnOeuvre;
	private PlanActionSpecifique pas;

	public DuerVM(Duer duer) {
		super();
		this.id = duer.getId();
		this.uniteLieu = duer.getUniteLieu();
		this.lieu = duer.getLieu();
		this.danger = duer.getDanger();
		this.risque = duer.getRisque();
		this.prevExistante = duer.getPrevExistante();
		this.prevMiseEnOeuvre = duer.getPrevMiseEnOeuvre();
		this.pas = duer.getPas();
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
