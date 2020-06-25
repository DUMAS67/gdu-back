/**
 * 
 */
package dev.pch.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Définition de la Table CREATION qui renseigne les dates de création et
 * modification du DUER
 */

@Entity

public class Creation {

	@Id

	private Integer id;
	/** Id de la liste des dangers */

	@NotNull
	private String date;

	/** Date du duer */

	public Creation() {
	}

	public Creation(Integer id, @NotNull String date) {
		super();
		this.id = id;
		this.date = date;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
