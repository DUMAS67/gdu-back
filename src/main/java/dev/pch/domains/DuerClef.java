/**
 * 
 */
package dev.pch.domains;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Définition d'une Classe décrivant un Objet Duer par le renseignement de clef
 * étrangère
 */
public class DuerClef {

	public Integer id_ut;
	/** renseigne l'Unité de Lieu */

	public Integer id_lieu;
	/** renseigne sur le lieu où se trouve le risque */

	public Integer id_activite;
	/** renseigne sur l'activité */

	public Integer id_danger;

	/** décrit le danger à analyser */

	public Integer id_risque;
	/** renseigne sur le risque engendré */

	public Integer id_gravEx;
	/** indique la gravité du risque pour la prévention existante */

	public Integer id_FreqEx;
	/** indique la fréquence du risque pour la prévention existante */

	public String prevEx;
	/** décrit la prévention existante */

	public Integer id_gravMo;
	/** indique la gravité du risque pour la prévention existante */

	public Integer id_FreqMo;
	/** indique la fréquence du risque pour la prévention existante */

	public String prevMo;

	public DuerClef() {
	}

	public DuerClef(Integer id_ut, Integer id_lieu, Integer id_activite, Integer id_danger, Integer id_risque,
			Integer id_gravEx, Integer id_FreqEx, String prevEx, Integer id_gravMo, Integer id_FreqMo, String prevMo) {
		super();
		this.id_ut = id_ut;
		this.id_lieu = id_lieu;
		this.id_activite = id_activite;
		this.id_danger = id_danger;
		this.id_risque = id_risque;
		this.id_gravEx = id_gravEx;
		this.id_FreqEx = id_FreqEx;

		this.prevEx = prevEx;
		this.id_gravMo = id_gravMo;
		this.id_FreqMo = id_FreqMo;

		this.prevMo = prevMo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DuerClef [id_ut=" + id_ut + ", id_lieu=" + id_lieu + ", id_activite=" + id_activite + ", id_danger="
				+ id_danger + ", id_risque=" + id_risque + ", id_gravEx=" + id_gravEx + ", id_FreqEx=" + id_FreqEx
				+ ", prevEx=" + prevEx + ", id_gravMo=" + id_gravMo + ", id_FreqMo=" + id_FreqMo + ", prevMo=" + prevMo
				+ "]";
	}

	/**
	 * @return the id_ut
	 */
	public Integer getId_ut() {
		return id_ut;
	}

	/**
	 * @param id_ut
	 *            the id_ut to set
	 */
	public void setId_ut(Integer id_ut) {
		this.id_ut = id_ut;
	}

	/**
	 * @return the id_lieu
	 */
	public Integer getId_lieu() {
		return id_lieu;
	}

	/**
	 * @param id_lieu
	 *            the id_lieu to set
	 */
	public void setId_lieu(Integer id_lieu) {
		this.id_lieu = id_lieu;
	}

	/**
	 * @return the id_activite
	 */
	public Integer getId_activite() {
		return id_activite;
	}

	/**
	 * @param id_activite
	 *            the id_activite to set
	 */
	public void setId_activite(Integer id_activite) {
		this.id_activite = id_activite;
	}

	/**
	 * @return the id_danger
	 */
	public Integer getId_danger() {
		return id_danger;
	}

	/**
	 * @param id_danger
	 *            the id_danger to set
	 */
	public void setId_danger(Integer id_danger) {
		this.id_danger = id_danger;
	}

	/**
	 * @return the id_risque
	 */
	public Integer getId_risque() {
		return id_risque;
	}

	/**
	 * @param id_risque
	 *            the id_risque to set
	 */
	public void setId_risque(Integer id_risque) {
		this.id_risque = id_risque;
	}

	/**
	 * @return the id_gravEx
	 */
	public Integer getId_gravEx() {
		return id_gravEx;
	}

	/**
	 * @param id_gravEx
	 *            the id_gravEx to set
	 */
	public void setId_gravEx(Integer id_gravEx) {
		this.id_gravEx = id_gravEx;
	}

	/**
	 * @return the id_FreqEx
	 */
	public Integer getId_FreqEx() {
		return id_FreqEx;
	}

	/**
	 * @param id_FreqEx
	 *            the id_FreqEx to set
	 */
	public void setId_FreqEx(Integer id_FreqEx) {
		this.id_FreqEx = id_FreqEx;
	}

	/**
	 * @return the prevEx
	 */
	public String getPrevEx() {
		return prevEx;
	}

	/**
	 * @param prevEx
	 *            the prevEx to set
	 */
	public void setPrevEx(String prevEx) {
		this.prevEx = prevEx;
	}

	/**
	 * @return the id_gravMo
	 */
	public Integer getId_gravMo() {
		return id_gravMo;
	}

	/**
	 * @param id_gravMo
	 *            the id_gravMo to set
	 */
	public void setId_gravMo(Integer id_gravMo) {
		this.id_gravMo = id_gravMo;
	}

	/**
	 * @return the id_FreqMo
	 */
	public Integer getId_FreqMo() {
		return id_FreqMo;
	}

	/**
	 * @param id_FreqMo
	 *            the id_FreqMo to set
	 */
	public void setId_FreqMo(Integer id_FreqMo) {
		this.id_FreqMo = id_FreqMo;
	}

	/**
	 * @return the prevMo
	 */
	public String getPrevMo() {
		return prevMo;
	}

	/**
	 * @param prevMo
	 *            the prevMo to set
	 */
	public void setPrevMo(String prevMo) {
		this.prevMo = prevMo;
	};

}
