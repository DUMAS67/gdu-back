/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Duer;
import dev.pch.repository.DuerRepo;
import dev.pch.vm.DuerVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/duers")
public class DuerController {

	private DuerRepo duerRepo;

	public DuerController(DuerRepo duerRepo) {
		super();
		this.duerRepo = duerRepo;
	}

	@GetMapping
	public List<DuerVM> listerDuer() {
		List<Duer> listeDuer = this.duerRepo.findAll();

		return listeDuer.stream().map(r -> new DuerVM(r)).collect(Collectors.toList());
	}

}
