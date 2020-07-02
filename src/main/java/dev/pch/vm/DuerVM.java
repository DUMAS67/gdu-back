/**
 * 
 */
package dev.pch.vm;

import java.time.LocalDateTime;

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

/*
 * Classe qui permet de construire un objet DuerVM qui récupère les informations
 * d'un objet Duer. Cette recopie assure une sécurité dans le cas d'objet avec
 * clef étrangères qui renseignent d'autres objets succeptibles de changer
 */
public class DuerVM {

	private int id;
	// récupère l'identifiant de la table DUER
	private Ut ut;
	// récupère l'objet ut du Duer
	private Lieu lieu;
	// récupère l'objet lieu du Duer
	private Activites activite;
	// récupère l'objet activite du Duer
	private Dangers danger;
	// récupère l'objet danger du Duer
	private Risques risque;
	// récupère l'objet risque du Duer
	private Gravite graviteEx;
	// récupère l'objet graviteEx du Duer
	private Frequence frequenceEx;
	// récupère l'objet frequenceEx du Duer
	private String prevExistante;
	// récupère la valeur de prevExistante du Duer
	private Gravite graviteMo;
	// récupère l'objet graviteMo du Duer
	private Frequence frequenceMo;
	// récupère l'objet frequenceMo du Duer
	private String prevMiseEnOeuvre;
	// récupère la valeur de prevMiseEnOeuvre du Duer
	private PlanActionSpecifique pas;
	// récupère l'objet pas du Duer
	private LocalDateTime dateEvrp;
	// récupère l'objet dateEvrp du Duer

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
		this.dateEvrp = duer.getDateEvrp();
	}

	/**
	 * @return the dateEvrp
	 */
	public LocalDateTime getDateEvrp() {
		return dateEvrp;
	}

	/**
	 * @param dateEvrp
	 *            the dateEvrp to set
	 */
	public void setDateEvrp(LocalDateTime dateEvrp) {
		this.dateEvrp = dateEvrp;
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