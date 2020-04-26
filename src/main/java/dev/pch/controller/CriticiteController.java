/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Criticite;
import dev.pch.repository.CriticiteRepo;
import dev.pch.vm.CriticiteVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController

public class CriticiteController {

	private CriticiteRepo criticiteRepo;
	private static final Logger LOG = LoggerFactory.getLogger(dev.pch.controller.CriticiteController.class);

	public CriticiteController(CriticiteRepo criticiteRepo) {
		super();
		this.criticiteRepo = criticiteRepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/criticites")
	public List<CriticiteVM> listerCriticite() {
		List<Criticite> listeCriticite = this.criticiteRepo.findAll();

		return listeCriticite.stream().map(r -> new CriticiteVM(r)).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/criticite")
	public CriticiteVM trouverCriticite(@RequestParam("id") Integer id) {
		LOG.info(" Trouver la valeur de la criticite pour l'Id : " + id);
		Optional<Criticite> valeurCriticite = this.criticiteRepo.findById(id);
		if ((valeurCriticite.isPresent()) && (id != null) && (id < Integer.MAX_VALUE) && (id > Integer.MIN_VALUE)) {
			LOG.info(" l'id de la Criticité : " + id + " existe");

		}

		return new CriticiteVM(valeurCriticite.get());
	}

}
