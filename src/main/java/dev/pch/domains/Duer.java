/**
 * 
 */
package dev.pch.domains;

import java.time.LocalDateTime;

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
	private Integer id;
	/** id de chaque ligne de l'EvRP du DUER */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ut_id")
	private Ut ut;
	/** renseigne l'Unité de Lieu */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "lieu_id")
	private Lieu lieu;
	/** renseigne sur le lieu ùu se trouve le risque */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "activite_id")
	private Activites activite;
	/** renseigne sur l'activité */
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
	@ManyToOne
	@JoinColumn(name = "graviteEx_id")
	private Gravite gravite_Ex;
	/** indique la gravité du risque pour la prévention existante */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "frequenceEx_id")
	private Frequence frequence_Ex;
	/** indique la fréquence du risque pour la prévention existante */

	@NotNull
	@JoinColumn(name = "prevExistante_id")
	private String prevExistante;
	/** décrit la prévention existante */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "graviteMo_id")
	private Gravite gravite_Mo;
	/** indique la gravité du risque pour la prévention existante */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "frequenceMo_id")
	private Frequence frequence_Mo;
	/** indique la fréquence du risque pour la prévention existante */

	@NotNull
	@JoinColumn(name = "prevOeuvre_id")
	private String prevMiseEnOeuvre;
	/** décrit la prévention à mettre en oeuvre */

	@OneToOne
	@JoinColumn(name = "pas_id")
	private PlanActionSpecifique pas;

	/** décrit le plan d'action spécifique */

	@JoinColumn(name = "date_jour")
	private LocalDateTime dateEvrp;

	public Duer() {
	}

	/**
	 * @PostLoad private void postLoad() {
	 *           this.criticite_Ex.setValeur(this.gravite_Mo.getValeur() *
	 *           this.frequence_Ex.getValeur()); }
	 */

	public Duer(Integer id, @NotNull Ut ut, @NotNull Lieu lieu, @NotNull Activites activite, @NotNull Dangers danger,
			@NotNull Risques risque, @NotNull Gravite gravite_Ex, @NotNull Frequence frequence_Ex,
			@NotNull String prevExistante, @NotNull Gravite gravite_Mo, @NotNull Frequence frequence_Mo,
			@NotNull String prevMiseEnOeuvre, PlanActionSpecifique pas, LocalDateTime dateEvrp) {
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

	public Duer(@NotNull Ut ut, @NotNull Lieu lieu, @NotNull Activites activite, @NotNull Dangers danger,
			@NotNull Risques risque, @NotNull Gravite gravite_Ex, @NotNull Frequence frequence_Ex,
			@NotNull String prevExistante, @NotNull Gravite gravite_Mo, @NotNull Frequence frequence_Mo,
			@NotNull String prevMiseEnOeuvre, LocalDateTime dateEvrp) {
		super();
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
	 * @return the gravite_Ex
	 */
	public Gravite getGravite_Ex() {
		return gravite_Ex;
	}

	/**
	 * @param gravite_Ex
	 *            the gravite_Ex to set
	 */
	public void setGravite_Ex(Gravite gravite_Ex) {
		this.gravite_Ex = gravite_Ex;
	}

	/**
	 * @return the frequence_Ex
	 */
	public Frequence getFrequence_Ex() {
		return frequence_Ex;
	}

	/**
	 * @param frequence_Ex
	 *            the frequence_Ex to set
	 */
	public void setFrequence_Ex(Frequence frequence_Ex) {
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
	public Gravite getGravite_Mo() {
		return gravite_Mo;
	}

	/**
	 * @param gravite_Mo
	 *            the gravite_Mo to set
	 */
	public void setGravite_Mo(Gravite gravite_Mo) {
		this.gravite_Mo = gravite_Mo;
	}

	/**
	 * @return the frequence_Mo
	 */
	public Frequence getFrequence_Mo() {
		return frequence_Mo;
	}

	/**
	 * @param frequence_Mo
	 *            the frequence_Mo to set
	 */
	public void setFrequence_Mo(Frequence frequence_Mo) {
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