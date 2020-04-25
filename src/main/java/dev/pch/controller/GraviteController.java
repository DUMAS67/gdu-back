/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Gravite;
import dev.pch.repository.GraviteRepo;
import dev.pch.vm.GraviteVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/gravites")
public class GraviteController {

	private GraviteRepo graviteRepo;

	public GraviteController(GraviteRepo graviteRepo) {
		super();
		this.graviteRepo = graviteRepo;
	}

	@GetMapping
	public List<GraviteVM> listerGravite() {
		List<Gravite> listeGravite = this.graviteRepo.findAll();

		return listeGravite.stream().map(r -> new GraviteVM(r)).collect(Collectors.toList());
	}

}