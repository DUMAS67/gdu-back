/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.PreventionExistante;
import dev.pch.repository.PreventionExistanteRepo;
import dev.pch.vm.PreventionExistanteVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/pexs")
public class PreventionExistanteController {

	private PreventionExistanteRepo preventionExistanteRepo;

	public PreventionExistanteController(PreventionExistanteRepo preventionExistanteRepo) {
		super();
		this.preventionExistanteRepo = preventionExistanteRepo;
	}

	@GetMapping
	public List<PreventionExistanteVM> listerPreventionExistante() {
		List<PreventionExistante> listePreventionExistante = this.preventionExistanteRepo.findAll();

		return listePreventionExistante.stream().map(r -> new PreventionExistanteVM(r)).collect(Collectors.toList());
	}

}
