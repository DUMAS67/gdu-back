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
public class CollaborateurVM {
	private Long id;
	private String email;
	private String nom;
	private String prenom;
	private String numeroTel;
	private List<Role> roles = new ArrayList<>();

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
