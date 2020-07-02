/**
 * 
 */
package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Creation;

/**
 * @author Thierry Dumas
 *
 */

/* Définition des requêtes utilisées dans le contrôleur de Création */
public interface CreationRepo extends JpaRepository<Creation, Integer> {

	Optional<Creation> findById(int id);

}
