/**
 * 
 */
package dev.pch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pch.domains.Activites;

/**
 * @author Thierry Dumas
 *
 */
public interface ActivitesRepo extends JpaRepository<Activites, Integer> {

}
