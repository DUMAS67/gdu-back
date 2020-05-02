/**
 * 
 */
package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Frequence;
import dev.pch.domains.PlanActionSpecifique;

/**
 * @author Thierry Dumas
 *
 */
public interface PlanActionSpecifiqueRepo extends JpaRepository<PlanActionSpecifique, Integer> {

	Optional<Frequence> findById(int id);

}
