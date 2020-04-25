/**
 * 
 */
package dev.pch.vm;

import java.util.Date;

import dev.pch.domains.Duer;
import dev.pch.domains.PlanActionSpecifique;

/**
 * @author Thierry Dumas
 *
 */
public class PlanActionSpecifiqueVM {

	private int id;
	private Duer idDuer;
	private String action;
	private float budget;
	private String qui;
	private Date delai;
	private boolean etat;

	public PlanActionSpecifiqueVM(PlanActionSpecifique pas) {
		super();
		this.id = pas.getId();
		this.idDuer = pas.getIdDuer();
		this.action = pas.getAction();
		this.budget = pas.getBudget();
		this.qui = pas.getQui();
		this.delai = pas.getDelai();
		this.etat = pas.isEtat();
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
	 * @return the idDuer
	 */
	public Duer getIdDuer() {
		return idDuer;
	}

	/**
	 * @param idDuer
	 *            the idDuer to set
	 */
	public void setIdDuer(Duer idDuer) {
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
	public Date getDelai() {
		return delai;
	}

	/**
	 * @param delai
	 *            the delai to set
	 */
	public void setDelai(Date delai) {
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
