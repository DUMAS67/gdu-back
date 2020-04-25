/**
 * 
 */
package dev.pch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Risques;

/**
 * @author Thierry Dumas
 *
 */
public interface RisquesRepo extends JpaRepository<Risques, Integer> {

}
