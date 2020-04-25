/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Criticite;
import dev.pch.repository.CriticiteRepo;
import dev.pch.vm.CriticiteVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/criticites")
public class CriticiteController {

	private CriticiteRepo criticiteRepo;

	public CriticiteController(CriticiteRepo criticiteRepo) {
		super();
		this.criticiteRepo = criticiteRepo;
	}

	@GetMapping
	public List<CriticiteVM> listerCriticite() {
		List<Criticite> listeCriticite = this.criticiteRepo.findAll();

		return listeCriticite.stream().map(r -> new CriticiteVM(r)).collect(Collectors.toList());
	}

}
