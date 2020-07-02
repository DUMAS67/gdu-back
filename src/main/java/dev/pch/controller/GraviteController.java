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

import dev.pch.domains.Gravite;
import dev.pch.repository.GraviteRepo;
import dev.pch.vm.GraviteVM;

/**
 * @author Thierry Dumas
 *
 */
/*
 * /* Classe qui définit les accès à la table GRAVITE pour la lecture et
 * l'écriture de données
 */

@RestController

public class GraviteController {

	private GraviteRepo graviteRepo;

	public GraviteController(GraviteRepo graviteRepo) {
		super();
		this.graviteRepo = graviteRepo;
	}

	// crée une liste de tous les enregistrements de la table GRAVITES
	@RequestMapping(method = RequestMethod.GET, path = "gravites")
	public List<GraviteVM> listerGravite() {
		List<Gravite> listeGravite = this.graviteRepo.findAll();

		return listeGravite.stream().map(r -> new GraviteVM(r)).collect(Collectors.toList());
	}

	/* Trouve un enregistrement de la table GRAVITE par son identifiant : id */
	@RequestMapping(method = RequestMethod.GET, path = "gravite")
	public Optional<Gravite> trouverGravite(@RequestParam("id") int id) {
		Optional<Gravite> gravite = this.graviteRepo.findById(id);

		return gravite;
	}

}