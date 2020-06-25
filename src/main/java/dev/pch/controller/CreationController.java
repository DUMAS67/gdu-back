/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Creation;
import dev.pch.repository.CreationRepo;
import dev.pch.vm.CreationVM;

/**
 * @author Thierry Dumas Classe qui lit et ecrit sur la table CREATION
 */

@RestController

public class CreationController {

	private CreationRepo creationRepo;

	private static final Logger LOG = LoggerFactory.getLogger(dev.pch.controller.CreationController.class);

	public CreationController(CreationRepo creationRepo) {
		super();
		this.creationRepo = creationRepo;
	}

	/*
	 * Donne la liste des Creations [seulement 3 lignes de données dans cette
	 * configuration de base
	 */
	@RequestMapping(method = RequestMethod.GET, path = "creas")
	public List<CreationVM> listerCrea() {
		List<Creation> listeCreation = this.creationRepo.findAll();

		return listeCreation.stream().map(r -> new CreationVM(r)).collect(Collectors.toList());
	}

	/* Trouve une Creation par son identifiant id */
	@RequestMapping(method = RequestMethod.GET, path = "creat")
	public Optional<Creation> trouverCrea(@RequestParam("id") int id) {
		Optional<Creation> idCrea = this.creationRepo.findById(id);

		return idCrea;
	}

	/*
	 * Définie une date de création : date pour l'identifiant de la table : id
	 * Creations
	 */

	@RequestMapping(method = RequestMethod.POST, path = "creatp")
	public ResponseEntity<String> CrerCrea(@RequestParam("id") int id, @RequestParam String date) {
		Optional<Creation> idModif = this.creationRepo.findById(id);

		if ((idModif.isPresent() && (Integer.valueOf(id) != null) && (id < 4) && (id > 0)) && (date != null)) {
			LOG.info(">>>> Modification Date du Duer d'ID : " + id);
			Creation modifCrea = new Creation(id, date);
			this.creationRepo.save(modifCrea);
			return ResponseEntity.status(HttpStatus.OK).body(">>>> : La date a été changée");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(">>>> : La date n'a pu être modifiée ou les données ne sont pas cohérentes");
		}
	}
}
