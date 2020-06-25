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
 * Classe décrivant une Action spécifique présentable pour l'utilisateur dans la
 * partie Front
 */
public class PlanActionSpecifiqueFront {

	private Integer id;
	private Integer idDuer;
	private String action;
	private float budget;
	private String qui;
	private LocalDateTime delai;
	private boolean etat;

	public PlanActionSpecifiqueFront() {
	}

	public PlanActionSpecifiqueFront(Integer id, Integer idDuer, String action, float budget, String qui,
			LocalDateTime delai, boolean etat) {
		super();
		this.id = id;
		this.idDuer = idDuer;
		this.action = action;
		this.budget = budget;
		this.qui = qui;
		this.delai = delai;
		this.etat = etat;
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