/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Risques;
import dev.pch.repository.RisquesRepo;
import dev.pch.vm.RisquesVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/risques")
public class RisquesControler {

	private RisquesRepo risquesrepo;

	public RisquesControler(RisquesRepo risquesrepo) {
		super();
		this.risquesrepo = risquesrepo;
	}

	@GetMapping
	public List<RisquesVM> listerRisques() {
		List<Risques> listeRisques = this.risquesrepo.findAll();
		/*
		 * for (Risques r : listeRisques) { System.out.println(r.getNom()); }
		 */

		return listeRisques.stream().map(r -> new RisquesVM(r)).collect(Collectors.toList());
	}

}

/**
 * Retourne la liste des chauffeurs
 * 
 * @RequestMapping(method = RequestMethod.GET, path = "chauffeurs") public
 *                        List<ChauffeurVM> getChauffeur() { List<Chauffeur>
 *                        listeChauffeurs = this.chffRepo.findAll(); return
 *                        listeChauffeurs.stream().map(col -> new
 *                        ChauffeurVM(col)).collect(Collectors.toList()); }
 */