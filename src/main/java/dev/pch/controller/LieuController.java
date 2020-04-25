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

import dev.pch.domains.Lieu;
import dev.pch.repository.LieuRepo;
import dev.pch.vm.LieuVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController

public class LieuController {

	private LieuRepo lieuRepo;
	private static final Logger LOG = LoggerFactory.getLogger(dev.pch.controller.LieuController.class);

	public LieuController(LieuRepo lieuRepo) {
		super();
		this.lieuRepo = lieuRepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "lieus")
	public List<LieuVM> listerLieu() {
		List<Lieu> listeLieu = this.lieuRepo.findAll();

		return listeLieu.stream().map(r -> new LieuVM(r)).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.POST, path = "lieu")
	public ResponseEntity<String> creerLieu(@RequestParam("nom") String nom) {
		LOG.info(" Creer le lieu de nom : " + nom);

		// On vérifie si le lieu existe
		Optional<Lieu> lieuNew = this.lieuRepo.findByNom(nom);
		if (lieuNew.isPresent() && (nom != null) && (nom != "")) {
			String messageErreur = "";
			messageErreur = "Lieu de nom : " + nom + " introuvable..";
			LOG.error(messageErreur);
			// throw new ElementNotFoundException(messageErreur);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageErreur);
		} else {
			LOG.info(">>>> Creer le lieu de nom : " + nom);
			Lieu nouveauLieu = new Lieu(nom);

			this.lieuRepo.save(nouveauLieu);
			return ResponseEntity.status(HttpStatus.OK).body("Le lieu a été créé avec succès!");
		}

	}

	@RequestMapping(method = RequestMethod.POST, path = "lieum")
	public ResponseEntity<String> creerLieu(@RequestParam("id") Integer idav, @RequestParam("nomap") String nomap) {
		LOG.info(" Modifier le Lieu d'id: " + idav);

		// On vérifie si le lieu existe
		Optional<Lieu> lieuNew = this.lieuRepo.findById(idav);
		if (lieuNew.isPresent() && (idav != null) && (nomap != null) && (nomap != "")) {

			LOG.info(">>>> Modifier le lieu d'ID : " + idav + " avec " + nomap);
			Lieu modifLieuNom = new Lieu(idav, nomap);

			this.lieuRepo.save(modifLieuNom);
			return ResponseEntity.status(HttpStatus.OK).body("Le Lieu été modifié avec succès!");
		} else {

			String messageErreur = "";
			messageErreur = "Lieu d'ID : " + idav + " introuvable..";
			LOG.error(messageErreur);
			// throw new ElementNotFoundException(messageErreur);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageErreur);
		}

	}

}
