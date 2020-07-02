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

/* Définition des requêtes utilisées dans le contrôleur d'activités */
public interface ActivitesRepo extends JpaRepository<Activites, Integer> {

	Optional<Activites> findByNom(String nom);

	Optional<Activites> findById(int id);

}
