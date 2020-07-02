/**
 * 
 */
package dev.pch.vm;

import java.time.LocalDateTime;

import dev.pch.domains.PlanActionSpecifique;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Classe qui permet de construire un objet PlanActionSpecifiqueFrontVM qui
 * récupère les informations d'un objet PlanActionSpecifiqueFront. Cette recopie
 * assure une sécurité dans le cas d'objet avec clef étrangères qui renseignent
 * d'autres objets succeptibles de changer
 */
public class PlanActionSpecifiqueFrontVM {

	private Integer id;
	// récupère l'identifiant de la table PLAN_ACTION_SPECIFIQUE
	private Integer idDuer;
	// récupère l'identifiant de la table DUER
	private String danger;
	// récupère la valeur danger du PlanActionSpecifique
	private String risque;
	// récupère la valeur risque du PlanActionSpecifique
	private String action;
	// récupère la valeur action du PlanActionSpecifique
	private float budget;
	// récupère la valeur budget du PlanActionSpecifique
	private String qui;
	// récupère la valeur qui du PlanActionSpecifique
	private LocalDateTime delai;
	// récupère la valeur deai du PlanActionSpecifique
	private boolean etat;
	// récupère la valeur etat du PlanActionSpecifique

	public PlanActionSpecifiqueFrontVM() {
	}

	public PlanActionSpecifiqueFrontVM(Integer id, Integer idDuer, String danger, String risque, String action,
			float budget, String qui, LocalDateTime delai, boolean etat) {
		super();
		this.id = id;
		this.idDuer = idDuer;
		this.danger = danger;
		this.risque = risque;
		this.action = action;
		this.budget = budget;
		this.qui = qui;
		this.delai = delai;
		this.etat = etat;
	}

	public PlanActionSpecifiqueFrontVM(PlanActionSpecifique pas) {

		super();
		this.id = pas.getId();
		this.idDuer = pas.getIdDuer().getId();
		this.danger = pas.getIdDuer().getDanger().getNom();
		this.risque = pas.getIdDuer().getRisque().getNom();
		this.action = pas.getAction();
		this.budget = pas.getBudget();
		this.qui = pas.getQui();
		this.delai = pas.getDelai();
		this.etat = pas.isEtat();
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
	 * @return the idDuer
	 */
	public Integer getIdDuer() {
		return idDuer;
	}

	/**
	 * @param idDuer
	 *            the idDuer to set
	 */
	public void setIdDuer(Integer idDuer) {
		this.idDuer = idDuer;
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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the budget
	 */
	public float getBudget() {
		return budget;
	}

	/**
	 * @param budget
	 *            the budget to set
	 */
	public void setBudget(float budget) {
		this.budget = budget;
	}

	/**
	 * @return the qui
	 */
	public String getQui() {
		return qui;
	}

	/**
	 * @param qui
	 *            the qui to set
	 */
	public void setQui(String qui) {
		this.qui = qui;
	}

	/**
	 * @return the delai
	 */
	public LocalDateTime getDelai() {
		return delai;
	}

	/**
	 * @param delai
	 *            the delai to set
	 */
	public void setDelai(LocalDateTime delai) {
		this.delai = delai;
	}

	/**
	 * @return the etat
	 */
	public boolean isEtat() {
		return etat;
	}

	/**
	 * @param etat
	 *            the etat to set
	 */
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

}
