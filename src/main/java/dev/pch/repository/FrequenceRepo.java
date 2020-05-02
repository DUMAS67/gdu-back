/**
 * 
 */
package dev.pch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Frequence;

/**
 * @author Thierry Dumas
 *
 */
public interface FrequenceRepo extends JpaRepository<Frequence, Integer> {

	Optional<Frequence> findByValeur(int valeur);

	Optional<Frequence> findById(int id);
}
