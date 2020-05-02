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

import dev.pch.domains.Frequence;
import dev.pch.repository.FrequenceRepo;
import dev.pch.vm.FrequenceVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
public class FrequenceController {

	private FrequenceRepo frequenceRepo;

	public FrequenceController(FrequenceRepo frequenceRepo) {
		super();
		this.frequenceRepo = frequenceRepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "frequences")
	public List<FrequenceVM> listerFrequence() {
		List<Frequence> listeFrequence = this.frequenceRepo.findAll();

		return listeFrequence.stream().map(r -> new FrequenceVM(r)).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, path = "frequence")
	public Optional<Frequence> trouverFrequence(@RequestParam("id") int id) {
		Optional<Frequence> frequence = this.frequenceRepo.findById(id);

		return frequence;
	}
}
