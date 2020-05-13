/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Duer;
import dev.pch.domains.PlanActionSpecifique;
import dev.pch.domains.PlanActionSpecifiqueFront;
import dev.pch.repository.DuerRepo;
import dev.pch.repository.PlanActionSpecifiqueRepo;
import dev.pch.vm.DangersVM;
import dev.pch.vm.PlanActionSpecifiqueFrontVM;
import dev.pch.vm.PlanActionSpecifiqueVM;
import dev.pch.vm.RisquesVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController

public class PlanActionSpecifiqueController {

	private PlanActionSpecifiqueRepo planActionSpecifiqueRepo;
	private DuerRepo duerRepo;

	public PlanActionSpecifiqueController(PlanActionSpecifiqueRepo planActionSpecifiqueRepo, DuerRepo duerRepo) {
		super();
		this.planActionSpecifiqueRepo = planActionSpecifiqueRepo;
		this.duerRepo = duerRepo;
	}

	private static final Logger LOG = LoggerFactory.getLogger(dev.pch.controller.PlanActionSpecifiqueController.class);

	/* liste tous les plans d'action spécifique */
	@RequestMapping(method = RequestMethod.GET, path = "pass")
	public List<PlanActionSpecifiqueVM> listerPlanActionSpecifique() {
		List<PlanActionSpecifique> listePlanActionSpecifique = this.planActionSpecifiqueRepo.findAll();

		return listePlanActionSpecifique.stream().map(r -> new PlanActionSpecifiqueVM(r)).collect(Collectors.toList());
	}

	/* liste tous les plans d'action spécifique format PAS FRontVM */
	@RequestMapping(method = RequestMethod.GET, path = "passf")
	public List<PlanActionSpecifiqueFrontVM> listerPlanActionSpecifiqueFront() {
		List<PlanActionSpecifique> listePlanActionSpecifique = this.planActionSpecifiqueRepo.findAll();

		return listePlanActionSpecifique.stream().map(r -> new PlanActionSpecifiqueFrontVM(r))
				.collect(Collectors.toList());
	}

	/* Construire la liste des Pas de Dangers = ? */
	@RequestMapping(method = RequestMethod.GET, path = "passfdg")
	public List<PlanActionSpecifiqueFrontVM> listerPasByDanger(@RequestParam("id") Integer id) {
		List<PlanActionSpecifique> listePlanActionSpecifique = this.planActionSpecifiqueRepo.findAll();

		return listePlanActionSpecifique.stream().filter(pas -> pas.getIdDuer().getDanger().getId() == id)
				.map(r -> new PlanActionSpecifiqueFrontVM(r)).collect(Collectors.toList());
	}

	/* Construire la liste des Pas de risque = ? */
	@RequestMapping(method = RequestMethod.GET, path = "passfrq")
	public List<PlanActionSpecifiqueFrontVM> listerPasByRisque(@RequestParam("id") Integer id) {
		List<PlanActionSpecifique> listePlanActionSpecifique = this.planActionSpecifiqueRepo.findAll();

		return listePlanActionSpecifique.stream().filter(pas -> pas.getIdDuer().getRisque().getId() == id)
				.map(r -> new PlanActionSpecifiqueFrontVM(r)).collect(Collectors.toList());
	}

	/* Construire la liste des Pas de qui = ? */
	@RequestMapping(method = RequestMethod.GET, path = "passfqui")
	public List<PlanActionSpecifiqueFrontVM> listerPasByQui(@RequestParam("nom") String nom) {
		List<PlanActionSpecifique> listePlanActionSpecifique = this.planActionSpecifiqueRepo.findAll();

		return listePlanActionSpecifique.stream().filter(pas -> pas.getQui().equals(nom))
				.map(r -> new PlanActionSpecifiqueFrontVM(r)).collect(Collectors.toList());
	}

	/* trouve un plan d'action spécifique en fonction de son id */
	@RequestMapping(method = RequestMethod.GET, path = "pas")
	public Optional<PlanActionSpecifique> trouverPasById(@RequestParam("id") Integer id) {
		Optional<PlanActionSpecifique> pas = this.planActionSpecifiqueRepo.findById(id);
		return pas;
	}

	/* Création d'un Plan d'Action Spécifique */
	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "pasc")
	public ResponseEntity<String> creerPas(@RequestBody PlanActionSpecifiqueFront newPas) {

		Optional<Duer> existDuer = this.duerRepo.findById(newPas.getIdDuer());
		if ((newPas.getId() == null) && (existDuer.isPresent())) {
			LOG.info(" Début Création du Plan d'action spécifique : ");

			PlanActionSpecifique pasNew = new PlanActionSpecifique(null, existDuer.get(), newPas.getAction(),
					newPas.getBudget(), newPas.getQui(), newPas.getDelai(), newPas.isEtat());

			Duer modifDuer = existDuer.get();

			modifDuer.setPas(pasNew);

			planActionSpecifiqueRepo.save(pasNew);
			duerRepo.save(modifDuer);

			return ResponseEntity.status(HttpStatus.OK).body("Le Plan d'action spécifique est créé!");
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Le Plan d'action spécifique existe déjà ou données incohérentes!");
		}
	}

	/* trouver les Dangers existants dans la liste des Pas */
	@RequestMapping(method = RequestMethod.GET, path = "pasldg")
	public List<DangersVM> trouverDangerdansPas() {

		return this.planActionSpecifiqueRepo.findAll().stream().map(pas -> pas.getIdDuer().getDanger()).distinct()
				.map(dg -> new DangersVM(dg)).collect(Collectors.toList());

	}

	/* trouver les Risques existants dans la liste des Pas */
	@RequestMapping(method = RequestMethod.GET, path = "paslrq")
	public List<RisquesVM> trouverRisquesdansPas() {

		return this.planActionSpecifiqueRepo.findAll().stream().map(pas -> pas.getIdDuer().getRisque()).distinct()
				.map(rq -> new RisquesVM(rq)).collect(Collectors.toList());

	}

	/* trouver les qui existants dans la liste des Pas */
	@RequestMapping(method = RequestMethod.GET, path = "paslqui")
	public List<String> trouverQuidansPas() {

		return this.planActionSpecifiqueRepo.findAll().stream().map(pas -> pas.getQui()).distinct()
				.collect(Collectors.toList());

	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "pascm")
	public ResponseEntity<String> modifierPas(@RequestBody PlanActionSpecifiqueFront newPas) {

		Optional<Duer> existDuer = this.duerRepo.findById(newPas.getIdDuer());
		if ((newPas.getId() != null) && (existDuer.isPresent())) {
			LOG.info(" Début Modification du Plan d'action spécifique : ");

			PlanActionSpecifique pasNew = new PlanActionSpecifique(newPas.getId(), existDuer.get(), newPas.getAction(),
					newPas.getBudget(), newPas.getQui(), newPas.getDelai(), newPas.isEtat());

			Duer modifDuer = existDuer.get();

			modifDuer.setPas(pasNew);

			planActionSpecifiqueRepo.save(pasNew);
			duerRepo.save(modifDuer);

			return ResponseEntity.status(HttpStatus.OK).body("Le Plan d'action spécifique est modifié!");
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Le Plan d'action spécifique n'a pu être modifié !");
		}
	}

	/* Détruit un Pas */
	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "pasdet")
	public ResponseEntity<String> detruirePas(@RequestParam("id") Integer id, @RequestParam("iduer") Integer iduer) {
		// On vérifie si l'Id du Pas que l'on veut detruirre existe
		Optional<PlanActionSpecifique> idEx = this.planActionSpecifiqueRepo.findById(id);
		Optional<Duer> duerExist = this.duerRepo.findById(iduer);
		if (idEx.isPresent() && duerExist.isPresent()) {
			LOG.info(">>>> Début Destruction du Pas d' Id : " + id);
			LOG.info(">>>> Modification de la Clef du DUer : " + iduer);
			Duer modifDuer = duerExist.get();

			modifDuer.setPas(null);

			duerRepo.save(modifDuer);
			LOG.info(">>>> Clef Pas du Duer " + id + "  modifié");
			planActionSpecifiqueRepo.deleteById(id);

			return ResponseEntity.status(HttpStatus.OK).body(">>>> Le Pas est détruit  et Duer modifié");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Le Pas a détruire n'existe pas ou pas de Duer ayant ce pas!");
		}
	}
}