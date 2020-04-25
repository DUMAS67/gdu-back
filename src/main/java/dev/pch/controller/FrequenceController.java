/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Frequence;
import dev.pch.repository.FrequenceRepo;
import dev.pch.vm.FrequenceVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/frequences")
public class FrequenceController {

	private FrequenceRepo frequenceRepo;

	public FrequenceController(FrequenceRepo frequenceRepo) {
		super();
		this.frequenceRepo = frequenceRepo;
	}

	@GetMapping
	public List<FrequenceVM> listerFrequence() {
		List<Frequence> listeFrequence = this.frequenceRepo.findAll();

		return listeFrequence.stream().map(r -> new FrequenceVM(r)).collect(Collectors.toList());
	}

}
