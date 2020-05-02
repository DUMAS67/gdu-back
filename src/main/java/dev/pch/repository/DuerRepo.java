/**
 * 
 */
package dev.pch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Duer;
import dev.pch.domains.Ut;

/**
 * @author Thierry Dumas
 *
 */
public interface DuerRepo extends JpaRepository<Duer, Integer> {

	Optional<Duer> findById(int id);

	Optional<Duer> findByUt(Ut ut);

	List<Duer> findAllByUt(Ut ut);

}
