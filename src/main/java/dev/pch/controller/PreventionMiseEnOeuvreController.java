/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.PreventionMiseEnOeuvre;
import dev.pch.repository.PreventionMiseEnOeuvreRepo;
import dev.pch.vm.PreventionMiseEnOeuvreVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/pmos")
public class PreventionMiseEnOeuvreController {

	private PreventionMiseEnOeuvreRepo preventionMiseEnOeuvreRepo;

	public PreventionMiseEnOeuvreController(PreventionMiseEnOeuvreRepo preventionMiseEnOeuvreRepo) {
		super();
		this.preventionMiseEnOeuvreRepo = preventionMiseEnOeuvreRepo;
	}

	@GetMapping
	public List<PreventionMiseEnOeuvreVM> listerPreventionMiseEnOeuvre() {
		List<PreventionMiseEnOeuvre> listePreventionMiseEnOeuvre = this.preventionMiseEnOeuvreRepo.findAll();

		return listePreventionMiseEnOeuvre.stream().map(r -> new PreventionMiseEnOeuvreVM(r))
				.collect(Collectors.toList());
	}

}
