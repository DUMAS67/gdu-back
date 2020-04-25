/**
 * 
 */
package dev.pch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Dangers;
import dev.pch.repository.DangersRepo;
import dev.pch.vm.DangersVM;

/**
 * @author Thierry Dumas
 *
 */

@RestController
@RequestMapping("/dangers")
public class DangersController {

	private DangersRepo dangersRepo;

	public DangersController(DangersRepo dangersRepo) {
		super();
		this.dangersRepo = dangersRepo;
	}

	@GetMapping
	public List<DangersVM> listerDangers() {
		List<Dangers> listeDangers = this.dangersRepo.findAll();

		return listeDangers.stream().map(r -> new DangersVM(r)).collect(Collectors.toList());
	}

}
