/**
 * 
 */
package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.PlanActionSpecifique;

/**
 * @author Thierry Dumas
 *
 */

/*
 * Définition des requêtes utilisées dans le contrôleur de Plan d'Actions
 * Spécifique
 */

public interface PlanActionSpecifiqueRepo extends JpaRepository<PlanActionSpecifique, Integer> {

	@Override
	Optional<PlanActionSpecifique> findById(Integer id);

}
