/**
 * 
 */
package dev.pch.domains;

import java.time.LocalDateTime;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe décrivant un Duer par les nom des entités qui le renseignent Utilisé
 * pour l'affichage dans le module Front
 */
public class DuerFront {

	private Integer id;
	/** id de chaque ligne de l'EvRP du DUER */

	private String ut;
	/** renseigne l'Unité de Lieu */

	private String lieu;
	/** renseigne sur le lieu ùu se trouve le risque */

	private String activite;
	/** renseigne sur l'activité */

	private String danger;

	/** décrit le danger à analyser */

	private String risque;
	/** renseigne sur le risque engendré */

	private Integer gravite_Ex;
	/** indique la gravité du risque pour la prévention existante */

	private Integer frequence_Ex;
	/** indique la fréquence du risque pour la prévention existante */

	private String prevExistante;
	/** décrit la prévention existante */

	private Integer gravite_Mo;
	/** indique la gravité du risque pour la prévention existante */

	private Integer frequence_Mo;
	/** indique la fréquence du risque pour la prévention existante */

	private String prevMiseEnOeuvre;
	/** décrit la prévention à mettre en oeuvre */

	private Integer pas;

	/** décrit le plan d'action spécifique */

	private LocalDateTime dateEvrp;

	public DuerFront(Integer id, String ut, String lieu, String activite, String danger, String risque,
			Integer gravite_Ex, Integer frequence_Ex, String prevExistante, Integer gravite_Mo, Integer frequence_Mo,
			String prevMiseEnOeuvre, Integer pas, LocalDateTime dateEvrp) {
		super();
		this.id = id;
		this.ut = ut;
		this.lieu = lieu;
		this.activite = activite;
		this.danger = danger;
		this.risque = risque;
		this.gravite_Ex = gravite_Ex;
		this.frequence_Ex = frequence_Ex;
		this.prevExistante = prevExistante;
		this.gravite_Mo = gravite_Mo;
		this.frequence_Mo = frequence_Mo;
		this.prevMiseEnOeuvre = prevMiseEnOeuvre;
		this.pas = pas;
		this.dateEvrp = dateEvrp;
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
	 * @return the ut
	 */
	public String getUt() {
		return ut;
	}

	/**
	 * @param ut
	 *            the ut to set
	 */
	public void setUt(String ut) {
		this.ut = ut;
	}

	/**
	 * @return the lieu
	 */
	public String getLieu() {
		return lieu;
	}

	/**
	 * @param lieu
	 *            the lieu to set
	 */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	/**
	 * @return the activite
	 */
	public String getActivite() {
		return activite;
	}

	/**
	 * @param activite
	 *            the activite to set
	 */
	public void setActivite(String activite) {
		this.activite = activite;
	}

	/**
	 * @return the danger
	 */
	public String getDanger() {
		return danger;
	}

	/**
	 * @param danger
	 *            the danger to set
	 */
	public void setDanger(String danger) {
		this.danger = danger;
	}

	/**
	 * @return the risque
	 */
	public String getRisque() {
		return risque;
	}

	/**
	 * @param risque
	 *            the risque to set
	 */
	public void setRisque(String risque) {
		this.risque = risque;
	}

	/**
	 * @return the gravite_Ex
	 */
	public Integer getGravite_Ex() {
		return gravite_Ex;
	}

	/**
	 * @param gravite_Ex
	 *            the gravite_Ex to set
	 */
	public void setGravite_Ex(Integer gravite_Ex) {
		this.gravite_Ex = gravite_Ex;
	}

	/**
	 * @return the frequence_Ex
	 */
	public Integer getFrequence_Ex() {
		return frequence_Ex;
	}

	/**
	 * @param frequence_Ex
	 *            the frequence_Ex to set
	 */
	public void setFrequence_Ex(Integer frequence_Ex) {
		this.frequence_Ex = frequence_Ex;
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
	 * @return the gravite_Mo
	 */
	public Integer getGravite_Mo() {
		return gravite_Mo;
	}

	/**
	 * @param gravite_Mo
	 *            the gravite_Mo to set
	 */
	public void setGravite_Mo(Integer gravite_Mo) {
		this.gravite_Mo = gravite_Mo;
	}

	/**
	 * @return the frequence_Mo
	 */
	public Integer getFrequence_Mo() {
		return frequence_Mo;
	}

	/**
	 * @param frequence_Mo
	 *            the frequence_Mo to set
	 */
	public void setFrequence_Mo(Integer frequence_Mo) {
		this.frequence_Mo = frequence_Mo;
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
	public Integer getPas() {
		return pas;
	}

	/**
	 * @param pas
	 *            the pas to set
	 */
	public void setPas(Integer pas) {
		this.pas = pas;
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

}
