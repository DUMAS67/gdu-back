/**
 * 
 */
package dev.pch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.PreventionMiseEnOeuvre;

/**
 * @author Thierry Dumas
 *
 */
public interface PreventionMiseEnOeuvreRepo extends JpaRepository<PreventionMiseEnOeuvre, Integer> {

}
