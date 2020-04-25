/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.PlanActionSpecifique;
import dev.pch.repository.PlanActionSpecifiqueRepo;
import dev.pch.vm.PlanActionSpecifiqueVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/pass")
public class PlanActionSpecifiqueController {

	private PlanActionSpecifiqueRepo planActionSpecifiqueRepo;

	public PlanActionSpecifiqueController(PlanActionSpecifiqueRepo planActionSpecifiqueRepo) {
		super();
		this.planActionSpecifiqueRepo = planActionSpecifiqueRepo;
	}

	@GetMapping
	public List<PlanActionSpecifiqueVM> listerPlanActionSpecifique() {
		List<PlanActionSpecifique> listePlanActionSpecifique = this.planActionSpecifiqueRepo.findAll();

		return listePlanActionSpecifique.stream().map(r -> new PlanActionSpecifiqueVM(r)).collect(Collectors.toList());
	}

}
