/**
 * 
 */
package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Ut;

/**
 * @author Thierry Dumas
 *
 */

/* Définition des requêtes utilisées dans le contrôleur d'UT */
public interface UtRepo extends JpaRepository<Ut, Integer> {

	Optional<Ut> findByNom(String nom);

	Optional<Ut> findById(int id);

}
