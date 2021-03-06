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

import dev.pch.domains.Ut;
import dev.pch.repository.UtRepo;
import dev.pch.vm.UtVM;

/**
 * @author Thierry Dumas
 *
 */
/*
 * Classe qui définit les accès à la table UT pour la lecture et l'écriture de
 * données
 */

@RestController

public class UtController {

	private UtRepo utRepo;

	private static final Logger LOG = LoggerFactory.getLogger(dev.pch.controller.UtController.class);

	public UtController(UtRepo utRepo) {
		super();
		this.utRepo = utRepo;
	}

	// Crée une liste de tous les enregistrements de la Table UT
	@RequestMapping(method = RequestMethod.GET, path = "uts")
	public List<UtVM> listerUt() {
		List<Ut> listeUt = this.utRepo.findAll();

		return listeUt.stream().map(r -> new UtVM(r)).collect(Collectors.toList());
	}

	/* Trouve un enregistrement de la table UT par son identifiant : id */

	@RequestMapping(method = RequestMethod.GET, path = "ut")
	public Optional<Ut> trouverUt(@RequestParam("id") int id) {
		Optional<Ut> ut = this.utRepo.findById(id);
		LOG.info(">>>> consulter l'Ut d'id : " + id);
		LOG.info("-> " + ut.isPresent());
		return ut;
	}
	/*
	 * Crée unenregistrement dans la table UT avec comme information son nom :
	 * nom
	 */

	@RequestMapping(method = RequestMethod.POST, path = "ut")
	public ResponseEntity<String> creerUt(@RequestParam("nom") String nom) {
		LOG.info(" Creer l UT de nom : " + nom);

		// On vérifie si l'Ut existe
		Optional<Ut> utNew = this.utRepo.findByNom(nom);
		if (utNew.isPresent() && (nom != null) && (nom != "")) {
			String messageErreur = "";
			messageErreur = "Ut de nom : " + nom + " existe déjà et/ou libellé incohérent";
			LOG.error(messageErreur);
			// throw new ElementNotFoundException(messageErreur);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageErreur);
		} else {
			if (!utNew.isPresent() && (nom != null) && (nom != "")) {
				LOG.info(">>>> Creer l Ut de nom : " + nom);
				// Creer l'UT
				Ut nouvelleUt = new Ut(nom);

				this.utRepo.save(nouvelleUt);
				return ResponseEntity.status(HttpStatus.OK).body("L Ut a été créé avec succès!");
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Les données de l Ut ne sont pas cohérentes");
			}
		}
	}

	/*
	 * Modifie un enregistrement de la table UT sélectionné par son identifiant
	 * : idav et pour nouveau nom : nomap
	 */
	@RequestMapping(method = RequestMethod.POST, path = "utm")
	public ResponseEntity<String> modifierUt(@RequestParam("id") Integer idav, @RequestParam("nomap") String nomap) {
		LOG.info(" Modifier l'UT d'id: " + idav);

		// On vérifie si l'Ut existe
		Optional<Ut> utNew = this.utRepo.findById(idav);
		if (utNew.isPresent() && (idav != null) && (nomap != null) && (nomap != "")) {

			LOG.info(">>>> Modifier l'Ut d'ID : " + idav + " avec " + nomap);
			Ut modifUtNom = new Ut(idav, nomap);

			this.utRepo.save(modifUtNom);
			return ResponseEntity.status(HttpStatus.OK).body("L'Ut a été modifié avec succès!");
		} else {

			String messageErreur = "";
			messageErreur = "Ut d'ID : " + idav + " introuvable..";
			LOG.error(messageErreur);
			// throw new ElementNotFoundException(messageErreur);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageErreur);
		}

	}
}