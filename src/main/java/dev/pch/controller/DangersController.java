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

import dev.pch.domains.Dangers;
import dev.pch.repository.DangersRepo;
import dev.pch.vm.DangersVM;

/**
 * @author Thierry Dumas
 */
/*
 * Classe qui définit les accès à la table DANGERS pour la lecture et l'écriture
 * de données
 */

@RestController

public class DangersController {

	private DangersRepo dangersRepo;
	private static final Logger LOG = LoggerFactory.getLogger(dev.pch.controller.DangersController.class);

	public DangersController(DangersRepo dangersRepo) {
		super();
		this.dangersRepo = dangersRepo;
	}

	/* Crée une liste de tous les Dangers de la Base de données gdu-db */
	@RequestMapping(method = RequestMethod.GET, path = "dangers")
	public List<DangersVM> listerDangers() {
		List<Dangers> listeDangers = this.dangersRepo.findAll();

		return listeDangers.stream().map(r -> new DangersVM(r)).collect(Collectors.toList());
	}

	/*
	 * Récupère les informations d'un danger de la table DANGERS par son
	 * identifiant : id
	 */
	@RequestMapping(method = RequestMethod.GET, path = "danger")
	public Optional<Dangers> trouverDangers(@RequestParam("id") int id) {
		Optional<Dangers> danger = this.dangersRepo.findById(id);

		return danger;
	}

	/* Crée un nouveau danger dans la table DANGERS */
	@RequestMapping(method = RequestMethod.POST, path = "danger")
	public ResponseEntity<String> creerDanger(@RequestParam("nom") String nom) {
		LOG.info(" Creer le danger de nom : " + nom);

		// On vérifie si le danger existe
		Optional<Dangers> dangerNew = this.dangersRepo.findByNom(nom);
		if (dangerNew.isPresent() && (nom != null) && (nom != "")) {
			String messageErreur = "";
			messageErreur = "Danger de nom : " + nom + " existe déjà et/ou données incohérentes";
			LOG.error(messageErreur);
			// throw new ElementNotFoundException(messageErreur);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageErreur);

		} else {
			if (!dangerNew.isPresent() && (nom != null) && (nom != "")) {

				LOG.info(">>>> Creer le Danger de nom : " + nom);
				Dangers nouveauDanger = new Dangers(nom);
				this.dangersRepo.save(nouveauDanger);
				return ResponseEntity.status(HttpStatus.OK).body("Le danger a été créé avec succès!");
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Le libellé est incohérent");
			}
		}

	}

	/*
	 * Modifie un danger de la table DANGER, sélectionné par son identifiant :
	 * idav de nouvau nom : nomap
	 */
	@RequestMapping(method = RequestMethod.POST, path = "dangerm")
	public ResponseEntity<String> modifierDanger(@RequestParam("id") Integer idav,
			@RequestParam("nomap") String nomap) {
		LOG.info(" Modifier le Danger d'id: " + idav);

		// On vérifie si le lieu existe
		Optional<Dangers> dangerNew = this.dangersRepo.findById(idav);
		if (dangerNew.isPresent() && (idav != null) && (nomap != null) && (nomap != "")) {

			LOG.info(">>>> Modifier le danger d'ID : " + idav + " avec " + nomap);
			Dangers modifDangersNom = new Dangers(idav, nomap);

			this.dangersRepo.save(modifDangersNom);
			return ResponseEntity.status(HttpStatus.OK).body("Le danger a été modifié avec succès!");
		} else {

			String messageErreur = "";
			messageErreur = "Danger d'ID : " + idav + " introuvable..";
			LOG.error(messageErreur);
			// throw new ElementNotFoundException(messageErreur);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageErreur);
		}

	}

}
