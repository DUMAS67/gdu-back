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

import dev.pch.domains.Risques;
import dev.pch.repository.RisquesRepo;
import dev.pch.vm.RisquesVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController

public class RisquesControler {

	private RisquesRepo risquesrepo;

	public RisquesControler(RisquesRepo risquesrepo) {
		super();
		this.risquesrepo = risquesrepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "risques")
	public List<RisquesVM> listerRisques() {
		List<Risques> listeRisques = this.risquesrepo.findAll();
		/*
		 * for (Risques r : listeRisques) { System.out.println(r.getNom()); }
		 */

		return listeRisques.stream().map(r -> new RisquesVM(r)).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, path = "risque")
	public Optional<Risques> trouverRisque(@RequestParam("id") int id) {
		Optional<Risques> risque = this.risquesrepo.findById(id);

		return risque;
	}
}
