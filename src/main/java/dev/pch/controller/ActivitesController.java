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

import dev.pch.domains.Activites;
import dev.pch.repository.ActivitesRepo;
import dev.pch.vm.ActivitesVM;

/**
 * @author Thierry Dumas
 *
 *         Classe qui définie toutes les fonctions d'écriture, lecture sur la
 *         table ACTIVITES de la base de donnée gdu-bd
 */
@RestController

public class ActivitesController {

	private ActivitesRepo activitesRepo;
	private static final Logger LOG = LoggerFactory.getLogger(dev.pch.controller.ActivitesController.class);

	public ActivitesController(ActivitesRepo activitesRepo) {
		super();
		this.activitesRepo = activitesRepo;
	}

	/* Récupération de la liste de toutes les activités */
	@RequestMapping(method = RequestMethod.GET, path = "activites")
	public List<ActivitesVM> listerActivites() {
		List<Activites> listeActivites = this.activitesRepo.findAll();

		return listeActivites.stream().map(r -> new ActivitesVM(r)).collect(Collectors.toList());
	}

	/* Récupération d'une activité par son identifiant id */
	@RequestMapping(method = RequestMethod.GET, path = "activite")
	public Optional<Activites> trouverActivite(@RequestParam("id") int id) {
		Optional<Activites> activite = this.activitesRepo.findById(id);

		return activite;
	}

	/* Création de l'activité ayant un nouveau nom : nom */
	@RequestMapping(method = RequestMethod.POST, path = "activite")
	public ResponseEntity<String> creerActivite(@RequestParam("nom") String nom) {
		LOG.info(" Creer l'Activité de nom : " + nom);

		// On vérifie si l'activité existe
		Optional<Activites> activiteNew = this.activitesRepo.findByNom(nom);
		if (activiteNew.isPresent() && (nom != null) && (nom != "")) {
			String messageErreur = "";
			messageErreur = "Lieu d'Activité : " + nom + " existe déjà et/ou données incohérentes";
			LOG.error(messageErreur);

			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageErreur);
		} else {
			if (!activiteNew.isPresent() && (nom != null) && (nom != "")) {
				LOG.info(">>>> Creer l'activité de nom : " + nom);
				Activites nouvelleActivite = new Activites(nom);

				this.activitesRepo.save(nouvelleActivite);
				return ResponseEntity.status(HttpStatus.OK).body("L'activité a été créé avec succès!");
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Le libellé est incohérent");
			}
		}
	}

	/* Modifie le nom de l'activité recherché par son identifiant id */
	@RequestMapping(method = RequestMethod.POST, path = "activitem")
	public ResponseEntity<String> modifierActivite(@RequestParam("id") Integer idav,
			@RequestParam("nomap") String nomap) {
		LOG.info(" Modifier l'Activité d'id: " + idav);

		// On vérifie si le l'activié existe
		Optional<Activites> activiteNew = this.activitesRepo.findById(idav);
		if (activiteNew.isPresent() && (idav != null) && (nomap != null) && (nomap != "")) {

			LOG.info(">>>> Modifier l'activité d'ID : " + idav + " avec " + nomap);
			Activites modifActiviteNom = new Activites(idav, nomap);

			this.activitesRepo.save(modifActiviteNom);
			return ResponseEntity.status(HttpStatus.OK).body("L'Activité été modifié avec succès!");
		} else {

			String messageErreur = "";
			messageErreur = "Lieu d'ID : " + idav + " introuvable..";
			LOG.error(messageErreur);
			// throw new ElementNotFoundException(messageErreur);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageErreur);
		}

	}

}
