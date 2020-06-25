/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Risques;
import dev.pch.repository.RisquesRepo;
import dev.pch.vm.RisquesVM;

/**
 * @author Thierry Dumas
 *
 */
/*
 * Classe qui définit les accès à la table RISQUES pour la lecture et l'écriture
 * de données
 */

@RestController

public class RisquesControler {

	private RisquesRepo risquesrepo;

	public RisquesControler(RisquesRepo risquesrepo) {
		super();
		this.risquesrepo = risquesrepo;
	}

	// Crée une liste des tous les risques de la Table RISQUES
	@RequestMapping(method = RequestMethod.GET, path = "risques")
	public List<RisquesVM> listerRisques() {
		List<Risques> listeRisques = this.risquesrepo.findAll();

		return listeRisques.stream().map(r -> new RisquesVM(r)).collect(Collectors.toList());
	}

	/* Trouve un enregistrement de la table RISQUES par son identifiant : id */
	@RequestMapping(method = RequestMethod.GET, path = "risque")
	public Optional<Risques> trouverRisque(@RequestParam("id") int id) {
		Optional<Risques> risque = this.risquesrepo.findById(id);

		return risque;
	}
}
