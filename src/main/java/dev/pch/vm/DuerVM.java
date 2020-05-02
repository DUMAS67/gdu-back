/**
 * 
 */
package dev.pch.vm;

import dev.pch.domains.Activites;
import dev.pch.domains.Dangers;
import dev.pch.domains.Duer;
import dev.pch.domains.Frequence;
import dev.pch.domains.Gravite;
import dev.pch.domains.Lieu;
import dev.pch.domains.PlanActionSpecifique;
import dev.pch.domains.Risques;
import dev.pch.domains.Ut;

/**
 * @author Thierry Dumas
 *
 */
public class DuerVM {

	private int id;
	private Ut ut;
	private Lieu lieu;
	private Activites activite;
	private Dangers danger;
	private Risques risque;
	private Gravite graviteEx;
	private Frequence frequenceEx;
	private String prevExistante;
	private Gravite graviteMo;
	private Frequence frequenceMo;
	private String prevMiseEnOeuvre;
	private PlanActionSpecifique pas;

	public DuerVM(Duer duer) {
		super();
		this.id = duer.getId();
		this.ut = duer.getUt();
		this.lieu = duer.getLieu();
		this.activite = duer.getActivite();
		this.danger = duer.getDanger();
		this.risque = duer.getRisque();
		this.graviteEx = duer.getGravite_Ex();
		this.frequenceEx = duer.getFrequence_Ex();
		this.prevExistante = duer.getPrevExistante();
		this.graviteMo = duer.getGravite_Mo();
		this.frequenceMo = duer.getFrequence_Mo();
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
	 * @return the ut
	 */
	public Ut getUt() {
		return ut;
	}

	/**
	 * @param ut
	 *            the ut to set
	 */
	public void setUt(Ut ut) {
		this.ut = ut;
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
	 * @return the activite
	 */
	public Activites getActivite() {
		return activite;
	}

	/**
	 * @param activite
	 *            the activite to set
	 */
	public void setActivite(Activites activite) {
		this.activite = activite;
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
	 * @return the graviteEx
	 */
	public Gravite getGraviteEx() {
		return graviteEx;
	}

	/**
	 * @param graviteEx
	 *            the graviteEx to set
	 */
	public void setGraviteEx(Gravite graviteEx) {
		this.graviteEx = graviteEx;
	}

	/**
	 * @return the frequenceEx
	 */
	public Frequence getFrequenceEx() {
		return frequenceEx;
	}

	/**
	 * @param frequenceEx
	 *            the frequenceEx to set
	 */
	public void setFrequenceEx(Frequence frequenceEx) {
		this.frequenceEx = frequenceEx;
	}

	/**
	 * @return the prevExistante
	 */
	public String getPrevExistante() {
		return prevExistante;
	}

	/**
	 * @param prevExistante
	 *            the prevExistante to set
	 */
	public void setPrevExistante(String prevExistante) {
		this.prevExistante = prevExistante;
	}

	/**
	 * @return the graviteMo
	 */
	public Gravite getGraviteMo() {
		return graviteMo;
	}

	/**
	 * @param graviteMo
	 *            the graviteMo to set
	 */
	public void setGraviteMo(Gravite graviteMo) {
		this.graviteMo = graviteMo;
	}

	/**
	 * @return the frequenceMo
	 */
	public Frequence getFrequenceMo() {
		return frequenceMo;
	}

	/**
	 * @param frequenceMo
	 *            the frequenceMo to set
	 */
	public void setFrequenceMo(Frequence frequenceMo) {
		this.frequenceMo = frequenceMo;
	}

	/**
	 * @return the prevMiseEnOeuvre
	 */
	public String getPrevMiseEnOeuvre() {
		return prevMiseEnOeuvre;
	}

	/**
	 * @param prevMiseEnOeuvre
	 *            the prevMiseEnOeuvre to set
	 */
	public void setPrevMiseEnOeuvre(String prevMiseEnOeuvre) {
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