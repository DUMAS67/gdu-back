/**
 * 
 */
package dev.pch.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author Thierry Dumas
 *
 */

/* Définition de la Table COLLABORATEUR */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Collaborateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** Identifiant d'un collaborateur */

	@NotNull
	private String nom;
	/** Nom d'un collaborateur */

	@NotNull
	private String prenom;
	/** Prénom d'une collaborateur */

	@NotNull
	private String email;
	/** Adresse email d'un collaborateur */

	@NotNull
	private String motDePasse;
	/** Mot de passe d'un collaborateur */

	private String numeroTel;
	/** Numéro de téléphone d'un collaborateur */

	@OneToMany(mappedBy = "collaborateur", cascade = CascadeType.PERSIST)
	private List<RoleCollaborateur> roles;

	/**
	 * Constructeurs
	 */
	public Collaborateur() {
	}

	public Collaborateur(Long id, String nom, String prenom, String email, String motDePasse, String numeroTel,
			List<RoleCollaborateur> roles) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.numeroTel = numeroTel;
		this.roles = roles;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<RoleCollaborateur> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleCollaborateur> roles) {
		this.roles = roles;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Collaborateur && o != null && ((Collaborateur) o).getId().equals(this.id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Collaborateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse="
				+ motDePasse + ", numeroTel=" + numeroTel + "]";
	}
}