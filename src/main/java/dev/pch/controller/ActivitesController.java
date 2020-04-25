/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Activites;
import dev.pch.repository.ActivitesRepo;
import dev.pch.vm.ActivitesVM;

/**
 * @author Thierry Dumas
 *
 */
@RestController
@RequestMapping("/activites")

public class ActivitesController {

	private ActivitesRepo activitesRepo;

	public ActivitesController(ActivitesRepo activitesRepo) {
		super();
		this.activitesRepo = activitesRepo;
	}

	@GetMapping
	public List<ActivitesVM> listerActivites() {
		List<Activites> listeActivites = this.activitesRepo.findAll();

		return listeActivites.stream().map(r -> new ActivitesVM(r)).collect(Collectors.toList());
	}

}
