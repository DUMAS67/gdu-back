/**
 * 
 */
package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Risques;

/**
 * @author Thierry Dumas
 *
 */

/* Définition des requêtes utilisées dans le contrôleur de Risques */
public interface RisquesRepo extends JpaRepository<Risques, Integer> {

	Optional<Risques> findById(int id);

}
