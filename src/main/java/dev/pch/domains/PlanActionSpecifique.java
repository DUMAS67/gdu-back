/**
 * 
 */
package dev.pch.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Thierry Dumas
 *
 */
@Entity
public class PlanActionSpecifique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** id du Plan d'Actions Spécifique */
	@NotNull
	@OneToOne
	@JoinColumn(name = "duer_id")
	private Duer idDuer;
	/** id de la ligne d'EvRp du Duer où se fait le Plan d'Action Spécifique */
	private String action;
	/** Détails action à mettre en place */
	private float budget;
	/** Budget prévisionnel de l'action spécifique */
	private String qui;
	/** Décrit la personne responsable de l'action */
	private Date delai;
	/** Donne le délai de mise en place de l'Action */
	private boolean etat;

	/** indique si l'action a été entreprise */

	public PlanActionSpecifique() {
	}

	public PlanActionSpecifique(int id, Duer idDuer, String action, float budget, String qui, Date delai,
			boolean etat) {
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
	public int getId() {
		return id;
	}

	/**
	 * @return the id
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
