/**
 * 
 */
package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Activites;

/**
 * @author Thierry Dumas
 *
 */
public interface ActivitesRepo extends JpaRepository<Activites, Integer> {

	Optional<Activites> findByNom(String nom);

	Optional<Activites> findById(int id);

}
