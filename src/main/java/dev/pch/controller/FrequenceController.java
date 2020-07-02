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

import dev.pch.domains.Frequence;
import dev.pch.repository.FrequenceRepo;
import dev.pch.vm.FrequenceVM;

/**
 * @author Thierry Dumas
 */
/*
 * Classe qui définit les accès à la table FREQUENCE pour la lecture et
 * l'écriture de données
 */

@RestController
public class FrequenceController {

	private FrequenceRepo frequenceRepo;

	public FrequenceController(FrequenceRepo frequenceRepo) {
		super();
		this.frequenceRepo = frequenceRepo;
	}

	// Crér une liste de toutes les fréquences de la table FREQUENCE
	@RequestMapping(method = RequestMethod.GET, path = "frequences")
	public List<FrequenceVM> listerFrequence() {
		List<Frequence> listeFrequence = this.frequenceRepo.findAll();

		return listeFrequence.stream().map(r -> new FrequenceVM(r)).collect(Collectors.toList());
	}

	/* Trouve un enregistrement de la table FREQUENCE par un identifiant : id */
	@RequestMapping(method = RequestMethod.GET, path = "frequence")
	public Optional<Frequence> trouverFrequence(@RequestParam("id") int id) {
		Optional<Frequence> frequence = this.frequenceRepo.findById(id);

		return frequence;
	}
}
