/**
 * 
 */
package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Lieu;

/**
 * @author Thierry Dumas
 *
 */

/* Définition des requêtes utilisées dans le contrôleur de Lieu */

public interface LieuRepo extends JpaRepository<Lieu, Integer> {

	Optional<Lieu> findByNom(String nom);

	Optional<Lieu> findById(int id);

}
