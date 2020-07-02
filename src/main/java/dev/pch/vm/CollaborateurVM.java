/**
 * 
 */
package dev.pch.vm;

/**
 * @author Thierry Dumas
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.pch.domains.Collaborateur;
import dev.pch.domains.Role;
import dev.pch.domains.RoleCollaborateur;

/**
 * Structure modèlisant un collaborateur servant à communiquer avec l'extérieur
 * (WEB API).
 */
/*
 * Classe qui permet de construire un objet CollaborateurVM qui récupère les
 * informations d'un objet Collaborateur Cette recopie assure une sécurité dans
 * le cas d'objet avec clef étrangères qui renseignent d'autres objets
 * succeptibles de changer
 */
public class CollaborateurVM {
	private Long id;
	// id récupéré de la table COLLABORATEUR
	private String email;
	// email récupéré de la table COLLABORATEUR
	private String nom;
	// valeur de nom récupérée de la table COLLABORATEUR
	private String prenom;
	// valeur du prenom récupéré de la table COLLABORATEUR
	private String numeroTel;
	// valeur du numero de téléphone récupéré de la table COLLABORATEUR
	private List<Role> roles = new ArrayList<>();
	// Tableau de valeurs de Roles récupéré de la table COLLABORATEUR

	public CollaborateurVM() {
	}

	public CollaborateurVM(Collaborateur collaborateur) {
		if (collaborateur != null) {
			this.id = collaborateur.getId();
			this.email = collaborateur.getEmail();
			this.nom = collaborateur.getNom();
			this.prenom = collaborateur.getPrenom();
			this.numeroTel = collaborateur.getNumeroTel();
			this.roles = collaborateur.getRoles().stream().map(roleCollaborateur -> roleCollaborateur.getRole())
					.collect(Collectors.toList());
		}
	}

	public Collaborateur toCollaborateur() {
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setId(this.id);
		collaborateur.setEmail(this.email);
		collaborateur.setNom(this.nom);
		collaborateur.setPrenom(this.prenom);
		collaborateur.setNumeroTel(this.numeroTel);
		List<RoleCollaborateur> rolesCollaborateur = this.roles.stream()
				.map(role -> new RoleCollaborateur(collaborateur, role)).collect(Collectors.toList());
		collaborateur.setRoles(rolesCollaborateur);
		return collaborateur;
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

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
