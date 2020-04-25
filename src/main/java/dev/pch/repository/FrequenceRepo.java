/**
 * 
 */
package dev.pch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Frequence;

/**
 * @author Thierry Dumas
 *
 */
public interface FrequenceRepo extends JpaRepository<Frequence, Integer> {

}
