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

@RestController

public class GraviteController {

	private GraviteRepo graviteRepo;

	public GraviteController(GraviteRepo graviteRepo) {
		super();
		this.graviteRepo = graviteRepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "gravites")
	public List<GraviteVM> listerGravite() {
		List<Gravite> listeGravite = this.graviteRepo.findAll();

		return listeGravite.stream().map(r -> new GraviteVM(r)).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, path = "gravite")
	public Optional<Gravite> trouverGravite(@RequestParam("id") int id) {
		Optional<Gravite> gravite = this.graviteRepo.findById(id);

		return gravite;
	}

}